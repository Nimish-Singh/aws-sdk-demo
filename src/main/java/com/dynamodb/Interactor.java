package com.dynamodb;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.TableCollection;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.TableDescription;

import java.util.ArrayList;
import java.util.List;

public class Interactor {
    private DynamoDB dynamoDB;

    public Interactor(DynamoDB dynamoDB) {
        this.dynamoDB = dynamoDB;
    }

    public List<String> listTables() {
        List<String> tableNames = new ArrayList<>();
        TableCollection<ListTablesResult> tables = dynamoDB.listTables();

        for (Table table : tables) {
            tableNames.add(table.getTableName());
        }
        return tableNames;
    }

    public TableDescription describeTable(Tables table) {
        return dynamoDB.getTable(table.getName()).describe();
    }
}
