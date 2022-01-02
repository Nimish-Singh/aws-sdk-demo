package com;

import com.configuration.DynamoDbClient;
import com.dynamodb.Interactor;
import com.dynamodb.Tables;

import static com.io.DetailsPrinter.printTableDetails;
import static com.io.DetailsPrinter.printTableList;

public class Main {
    private static Interactor dynamoDbInteractor;

    private static void wireUpDependencies() {
        dynamoDbInteractor = new Interactor(DynamoDbClient.dynamoDBClient());
    }

    public static void main(String[] args) {
        wireUpDependencies();

        printTableList(dynamoDbInteractor.listTables());
        printTableDetails(dynamoDbInteractor.describeTable(Tables.STUDENT));
    }
}
