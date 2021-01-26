package com.sg.flooring.service;

import com.sg.flooring.dao.FlooringPersistenceException;
import com.sg.flooring.model.Order;
import com.sg.flooring.model.Product;
import com.sg.flooring.model.Tax;
import java.time.LocalDate;
import java.util.List;

public interface FlooringServiceLayer {

    void createOrder(Order order) throws
            FlooringPersistenceException,
            IncorrectDateException,
            FlooringDataValidationException,
            NoSuchStateException,
            NoSuchProductTypeException,
            InvalidAreaException;

    List<Order> getAllOrders() throws
            FlooringPersistenceException;
    
    List<Order> getAllOrders(LocalDate date) throws
            FlooringPersistenceException,
            NoSuchOrderException;

    Order getOrder(Integer orderNumber) throws
            FlooringPersistenceException;

    void editOrder(Order order) throws
            FlooringPersistenceException,
            FlooringDataValidationException,
            NoSuchStateException,
            NoSuchProductTypeException,
            InvalidAreaException;

    Order removeOrder(Integer orderNumber) throws
            FlooringPersistenceException;
    
    Product getProduct(String productType) throws 
            FlooringPersistenceException,
            NoSuchProductTypeException;
    
    Tax getTax(String stateAbbreviation) throws 
            FlooringPersistenceException,
            NoSuchStateException;
    
    Order calculate(Order order) throws FlooringPersistenceException, 
            NoSuchProductTypeException,
            NoSuchStateException;
}
