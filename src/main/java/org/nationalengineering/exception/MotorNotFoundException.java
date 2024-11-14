package org.nationalengineering.exception;

public class MotorNotFoundException extends RuntimeException {
    public MotorNotFoundException(String message) {
        super(message);
    }
}
