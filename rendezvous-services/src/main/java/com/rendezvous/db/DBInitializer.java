package com.rendezvous.db;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.Projection;
import com.amazonaws.services.dynamodbv2.model.ProjectionType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;

import javax.annotation.PostConstruct;

import com.rendezvous.entity.DineOutPlan;
import com.rendezvous.entity.MoviePlan;
import com.rendezvous.entity.OutingPlan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class to create dynamo db tables.
 *
 * @author Rupali Paunikar
 */
@Component
public class DBInitializer {
    private Logger logger = LoggerFactory.getLogger(DBInitializer.class);

    private DynamoDBMapper mapper;
    private DynamoDB client;

    @Autowired
    public DBInitializer(final DynamoDBMapper mapper, final DynamoDB client) {
        this.mapper = mapper;
        this.client = client;
    }

    @PostConstruct
    public void init() throws InterruptedException {
        createTable(OutingPlan.class);
        createTable(DineOutPlan.class);
        createTable(MoviePlan.class);
    }

    /**
     * Method to create table.
     *
     * @param tClass the class
     * @throws InterruptedException the {@link InterruptedException}.
     */
    private void createTable(final Class<?> tClass) throws InterruptedException {
        final CreateTableRequest request = mapper.generateCreateTableRequest(tClass);
        final ProvisionedThroughput provisionedThroughput = new ProvisionedThroughput(1L, 1L);
        request.setProvisionedThroughput(provisionedThroughput);
        request.getGlobalSecondaryIndexes().forEach(index -> {
                    index.setProvisionedThroughput(provisionedThroughput);
                    index.setProjection(new Projection().withProjectionType(ProjectionType.ALL));
                }
        );

        try {
            final Table table = client.createTable(request);
            table.waitForActive();
        } catch (ResourceInUseException e) {
            logger.info("Table {} already exists", request.getTableName());
        }
    }
}
