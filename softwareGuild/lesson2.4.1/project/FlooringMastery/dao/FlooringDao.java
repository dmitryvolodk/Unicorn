package com.sg.flooring.dao;

import com.sg.flooring.model.Order;
import com.sg.flooring.model.Product;
import com.sg.flooring.model.Tax;
import java.util.List;

public interface FlooringDao {

    /**
     * Adds the given Order to the floor and associates it with the given
     * order number. If there is already an order associated with the given
     * order number it will return that order object, otherwise it will return
     * null.
     *
     * @param orderNumber number with which order is to be associated
     * @param order order to be added to the floor
     * @return the Order object previously associated with the given order
     * number if it exists, null otherwise
     * @throws com.sg.flooring.dao.FlooringPersistenceException
     */
    Order addOrder(int orderNumber, Order order) throws FlooringPersistenceException;

    /**
     * Returns an int list containing the order numbers 
     * of all orders in the floor.
     *
     * @return int list containing the order numbers
     * of all orders in the floor
     * @throws com.sg.flooring.dao.FlooringPersistenceException
     */
    List<Order> getAllOrders() throws FlooringPersistenceException;
    
    /**
     * Returns the Order object associated with the given order number. Returns
     * null if no such Order exists
     *
     * @param orderNumber order number of the order to retrieve
     * @return the Order object associated with the given order number, null if
     * no such Order exists
     * @throws com.sg.flooring.dao.FlooringPersistenceException
     */
    Order getOrder(Integer orderNumber) throws FlooringPersistenceException;

    /**
     * Edits the given order in the Floor and associates it with the given
     * order number. If there is already an order associated with the given
     * order number it will return that order object, otherwise it will return
     * null.
     *
     * @param orderNumber with which order is to be associated
     * @param order order to be edited in the floor
     * @return the order object previously associated with the given order
     * number if it exists, null otherwise
     * @throws com.sg.flooring.dao.FlooringPersistenceException
     */
    Order editOrder(int orderNumber, Order order) throws FlooringPersistenceException;

    /**
     * Removes from the floor the order associated with the given order number.
     * Returns the order object that is being removed or null if there is no
     * order associated with the given id
     *
     * @param orderNumber number of order to be removed
     * @return Order object that was removed or null if no order was
     * associated with the given order number
     * @throws com.sg.flooring.dao.FlooringPersistenceException
     */
    Order removeOrder(int orderNumber) throws FlooringPersistenceException;
    
    /**
     * Returns the Product object associated with the given product type. 
     * Returns null if no such Product exists
     *
     * @param productType product type of the Product to retrieve
     * @return the Product object associated with the given product type, null 
     * if no such Product exists
     * @throws com.sg.flooring.dao.FlooringPersistenceException
     */
    Product getProduct(String productType) throws FlooringPersistenceException;
    
    /**
     * Returns the Tax object associated with the given state abbreviation. 
     * Returns null if no such Tax exists
     *
     * @param stateAbbreviation state abbreviation of the Tax to retrieve
     * @return the Tax object associated with the given state abbreviation, null 
     * if no such Tax exists
     * @throws com.sg.flooring.dao.FlooringPersistenceException
     */
    Tax getTax(String stateAbbreviation) throws FlooringPersistenceException;
}
