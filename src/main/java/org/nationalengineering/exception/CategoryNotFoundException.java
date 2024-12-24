package org.nationalengineering.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String messgae) {
        super(messgae);
    }
}
