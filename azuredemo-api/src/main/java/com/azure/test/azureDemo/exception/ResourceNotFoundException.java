package com.azure.test.azureDemo.exception;

/**
 * Thrown by each service implementations when the requested resource not found.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Create a new ResourceNotFoundException
     *
     * @param message the message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
