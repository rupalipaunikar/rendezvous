package com.rendezvous;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Startup class of the application.
 *
 * @author Rupali Paunikar
 */
@EnableDynamoDBRepositories("com.rendezvous.repository")
@SpringBootApplication
@EnableScheduling
public class RendezvousApplication extends ServletInitializer {

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(RendezvousApplication.class, args); 
    }
}

