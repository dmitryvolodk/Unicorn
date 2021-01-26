package com.sg.flooring.service;

public class NoSuchProductTypeException extends Exception {

    public NoSuchProductTypeException(String message) {
        super(message);
    }

    public NoSuchProductTypeException(String message,
            Throwable cause) {
        super(message, cause);
    }
}
