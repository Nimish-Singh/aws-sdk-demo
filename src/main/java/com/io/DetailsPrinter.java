package com.io;

import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputDescription;
import com.amazonaws.services.dynamodbv2.model.TableDescription;

import java.util.List;

public class DetailsPrinter {
    private static final String TABLE_NAMES = "Table names:";
    private static final String DETAILS_FOR_TABLE = "Details for table: %s \n\n";
    private static final String TABLE_STATUS = "Table status: %s \n";
    private static final String ITEM_COUNT = "Item count: %s \n";
    private static final String TABLE_SIZE = "Table size (bytes): %s \n";
    private static final String ATTRIBUTE_OF_TYPE = "Attribute: %s of type: %s \n";
    private static final String KEY_OF_TYPE = "Key: %s of type: %s \n";
    private static final String RCUS = "RCUs: %s \n";
    private static final String WCUS = "WCUs: %s \n";

    public static void printTableList(List<String> names) {
        System.out.println(TABLE_NAMES);
        names.forEach(System.out::println);
    }

    public static void printTableDetails(TableDescription description) {
        System.out.println();
        System.out.printf(DETAILS_FOR_TABLE, description.getTableName());
        System.out.printf(TABLE_STATUS, description.getTableStatus());
        System.out.printf(ITEM_COUNT, description.getItemCount());
        System.out.printf(TABLE_SIZE, description.getTableSizeBytes());
        printAttributeDefinitions(description.getAttributeDefinitions());
        printKeySchema(description.getKeySchema());
        printProvisionedThroughput(description.getProvisionedThroughput());
    }

    private static void printAttributeDefinitions(List<AttributeDefinition> attributeDefinitions) {
        attributeDefinitions.forEach(attribute -> System.out.printf(ATTRIBUTE_OF_TYPE, attribute.getAttributeName(), attribute.getAttributeType()));
    }

    private static void printKeySchema(List<KeySchemaElement> keySchema) {
        keySchema.forEach(key -> System.out.printf(KEY_OF_TYPE, key.getAttributeName(), key.getKeyType()));
    }

    private static void printProvisionedThroughput(ProvisionedThroughputDescription provisionedThroughput) {
        System.out.printf(RCUS, provisionedThroughput.getReadCapacityUnits());
        System.out.printf(WCUS, provisionedThroughput.getReadCapacityUnits());
    }
}
