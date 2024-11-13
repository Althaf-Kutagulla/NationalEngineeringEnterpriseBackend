package org.nationalengineering.exception;

public class WorkerNotFoundException extends RuntimeException {
    public WorkerNotFoundException(String message){
        super(message);
    }
}
