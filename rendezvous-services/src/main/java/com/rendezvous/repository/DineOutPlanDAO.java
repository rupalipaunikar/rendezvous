package com.rendezvous.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.rendezvous.entity.DineOutPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO class for {@link DineOutPlan}.
 *
 * @author Rupali Paunikar
 */
@Repository
public class DineOutPlanDAO {

    private DynamoDB client;
    private AmazonDynamoDB dynamoDB;
    private DynamoDBMapper mapper;

    public DynamoDB getClient() {
        return client;
    }

    @Autowired
    public void setClient(final DynamoDB client) {
        this.client = client;
    }

    public AmazonDynamoDB getDynamoDB() {
        return dynamoDB;
    }

    @Autowired
    public void setDynamoDB(final AmazonDynamoDB dynamoDB) {
        this.dynamoDB = dynamoDB;
    }

    public DynamoDBMapper getMapper() {
        return mapper;
    }

    @Autowired
    public void setMapper(final DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Method to find list of {@link DineOutPlan} by user id.
     *
     * @param userId the userId
     * @return the list of {@link DineOutPlan}.
     */
    public List<DineOutPlan> findByUserId(final String userId) {
        Map<String, AttributeValue> lastKeyEvaluated;

        do {
            final Map<String, AttributeValue> values = new HashMap<>();
            values.put(":val", new AttributeValue().withS(userId));
            final ScanRequest scanRequest = new ScanRequest()
                    .withLimit(100)
                    .withTableName("dine_out_plan")
                    .withExpressionAttributeValues(values)
                    .withFilterExpression("userId = :val")
                    .withProjectionExpression("userId");

            final ScanResult scanResult = dynamoDB.scan(scanRequest);
            scanResult.getItems().forEach(System.out::println);
            lastKeyEvaluated = scanResult.getLastEvaluatedKey();
        }
        while (null != lastKeyEvaluated);
        return null;
    }
}
