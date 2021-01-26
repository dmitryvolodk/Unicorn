package com.sg.flooring.service;

public class InvalidAreaException extends Exception {

    public InvalidAreaException(String message) {
        super(message);
    }

    public InvalidAreaException(String message,
            Throwable cause) {
        super(message, cause);
    }
}
