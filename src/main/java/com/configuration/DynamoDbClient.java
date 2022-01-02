package com.configuration;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class DynamoDbClient {
    public static DynamoDB dynamoDBClient() {
        return new DynamoDB(standardClient());
    }

    private static AmazonDynamoDB standardClient() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withRegion(Regions.AP_SOUTH_1)
                .build();
    }
}
