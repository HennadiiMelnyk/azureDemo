package com.azure.test.azureDemo.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

/**
 *
 */
public final class IdGeneratorUtils {

    public static String generateUserId() {
        return RandomStringUtils.randomNumeric(20);
    }

    /**
     * Generate id in UUID format.
     *
     * @return random generated id
     * @see UUID#randomUUID()
     */
    public static String generateUUID() {
        return UUID
                .randomUUID()
                .toString();
    }
}
