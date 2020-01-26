package com.azure.test.azureDemo.domain;

/**
 * This enum is responsible for access to something resource into this system
 */
public enum Role {

    ADMIN("Admin"),
    USER("User");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
