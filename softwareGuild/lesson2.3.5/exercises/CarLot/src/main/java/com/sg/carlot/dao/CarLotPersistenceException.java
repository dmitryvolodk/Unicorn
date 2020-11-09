package com.sg.carlot.dao;

public class CarLotPersistenceException extends Exception {

    public CarLotPersistenceException(String message) {
        super(message);
    }

    public CarLotPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
