package com.dynamodb;

public enum Tables {
    DUMMY_TABLE("dummy-table"),
    STUDENT("student");

    private final String name;

    private Tables(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
