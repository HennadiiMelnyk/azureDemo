package com.azure.test.azureDemo.domain;

public enum UserStatus {

    Active("Active"),
    InActive("InActive");

    private final String name;

    UserStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
