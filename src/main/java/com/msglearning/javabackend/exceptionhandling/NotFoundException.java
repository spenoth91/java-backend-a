package com.msglearning.javabackend.exceptionhandling;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
