package com.library.util;

public final class ValidationUtil {

    private ValidationUtil() {
    }

    public static void validateNotBlank(
            String value,
            String fieldName) {

        if(value == null || value.isBlank()) {

            throw new IllegalArgumentException(
                    fieldName + " cannot be blank"
            );
        }
    }

    public static void validateNotNull(
            Object obj,
            String fieldName) {

        if(obj == null) {

            throw new IllegalArgumentException(
                    fieldName + " cannot be null"
            );
        }
    }
}