package com.rendezvous;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreamsClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.rendezvous.db.DBInitializer;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.StringUtils;

/**
 * Startup class of the application.
 *
 * @author Rupali Paunikar
 */
@EnableDynamoDBRepositories("com.rendezvous.repository")
@SpringBootApplication
@EnableScheduling
public class RendezvousApplication extends ServletInitializer {

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    private static DBInitializer dbInitializer;

    public static DBInitializer getDbInitializer() {
        return dbInitializer;
    }

    @Autowired

    public static void setDbInitializer(final DBInitializer dbInitializer) {
        RendezvousApplication.dbInitializer = dbInitializer;
    }

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(RendezvousApplication.class, args);
        dbInitializer.init();
    }

    /**
     * Config for {@link AWSCredentials}.
     *
     * @return config
     */
    @Bean
    public AWSCredentials awsCredentials() {
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }

    /**
     * Config for {@link AmazonDynamoDB}.
     *
     * @return config
     */
    @Bean
    public AmazonDynamoDB amazonDynamoDB(final AWSCredentials awsCredentials) {
        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(awsCredentials);
        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
        }
        return amazonDynamoDB;
    }

    /**
     * Config for {@link DynamoDBMapper}.
     *
     * @return config
     */
    @Bean
    public DynamoDBMapper dynamoDBMapper(final AmazonDynamoDBClient amazonDynamoDBClient) {
        return new DynamoDBMapper(amazonDynamoDBClient);
    }

    /**
     * Config for {@link AmazonDynamoDBStreamsClient}.
     *
     * @return config
     */
    @Bean
    public AmazonDynamoDBStreamsClient amazonDynamoDBStreamsAsyncClient(final AWSCredentials awsCredentials) {
        return new AmazonDynamoDBStreamsClient(awsCredentials);
    }

    /**
     * Config for {@link DynamoDB}.
     *
     * @return config
     */
    @Bean
    public DynamoDB dynamoDB(final AmazonDynamoDB amazonDynamoDB) {
        return new DynamoDB(amazonDynamoDB);
    }
}

