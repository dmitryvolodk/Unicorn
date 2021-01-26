package com.sg.flooring.service;

public class NoSuchStateException extends Exception {

    public NoSuchStateException(String message) {
        super(message);
    }

    public NoSuchStateException(String message,
            Throwable cause) {
        super(message, cause);
    }
}
