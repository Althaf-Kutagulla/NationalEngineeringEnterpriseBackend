package org.nationalengineering.exception;

public class ProductUsageNotFoundException extends RuntimeException {
    public ProductUsageNotFoundException(String message) {
        super(message);
    }
}
