package com.example.exception;

public class FailedException extends RuntimeException {
    public FailedException(String message) {
        super(message);
    }
}
