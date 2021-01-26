package com.sg.flooring.service;

import com.sg.flooring.dao.FlooringDao;
import com.sg.flooring.dao.FlooringPersistenceException;
import com.sg.flooring.model.Order;
import com.sg.flooring.model.Product;
import com.sg.flooring.model.Tax;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FlooringServiceLayerImpl implements FlooringServiceLayer {

    FlooringDao dao;

    public FlooringServiceLayerImpl(FlooringDao dao) {
        this.dao = dao;
    }

    @Override
    public void createOrder(Order order) throws
            FlooringPersistenceException,
            IncorrectDateException,
            FlooringDataValidationException,
            NoSuchStateException,
            NoSuchProductTypeException,
            InvalidAreaException {

        //Validate the name of the customer and throw an exception if needed
        validateNameData(order);

        // Verify the date - it should be in the future. Throw exception otherwise.
        validateDate(order);

        // Check if state exists.Throw exception otherwise.
        validateState(order);

        // Check if product exists.Throw exception otherwise.
        validateProduct(order);

        // Check if the area is valid. Throw exception otherwise
        validateArea(order);

        // We passed all our business rules checks so we can go 
        // and persist the Order object 
        dao.addOrder(order.getOrderNumber(), order);
    }

    @Override
    public List<Order> getAllOrders() throws FlooringPersistenceException {
        return dao.getAllOrders();
    }

    @Override
    public List<Order> getAllOrders(LocalDate date) throws
            FlooringPersistenceException,
            NoSuchOrderException {
        int orderAmount = 0;
        List<Order> orderList = dao.getAllOrders();
        List<Order> sortedOrderList = new ArrayList<Order>();
        for (Order o : orderList) {
            if (o.getOrderDate().isEqual(date)) {
                orderAmount++;
                sortedOrderList.add(o);
            }
        }

        if (orderAmount == 0) {
            throw new NoSuchOrderException("ERROR: Could not get order(s). Order(s) for "
                    + date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")) + " doesn't exist");
        }

        return sortedOrderList;
    }

    @Override
    public Order getOrder(Integer orderNumber) throws FlooringPersistenceException {
        return dao.getOrder(orderNumber);
    }

    @Override
    public void editOrder(Order order) throws FlooringPersistenceException,
            FlooringDataValidationException,
            NoSuchStateException,
            NoSuchProductTypeException,
            InvalidAreaException {

        //Validate the name of the customer and throw an exception if needed
        validateNameData(order);

        // Check if state exists.Throw exception otherwise.
        validateState(order);

        // Check if product exists.Throw exception otherwise.
        validateProduct(order);

        // Check if the area is valid. Throw exception otherwise
        validateArea(order);

        // We passed all our business rules checks so we can go 
        // and persist the Order object 
        dao.editOrder(order.getOrderNumber(), order);
    }

    @Override
    public Order removeOrder(Integer orderNumber) throws FlooringPersistenceException {
        return dao.removeOrder(orderNumber);
    }

    @Override
    public Product getProduct(String productType) throws FlooringPersistenceException, NoSuchProductTypeException {
        Product product = dao.getProduct(productType);
        if (productType == null
                || productType.trim().length() == 0
                || product == null) {
            throw new NoSuchProductTypeException("ERROR: Could not get a product. Product "
                    + productType + " doesn't exist");
        }
        return product;
    }

    @Override
    public Tax getTax(String stateAbbreviation) throws FlooringPersistenceException, NoSuchStateException {
        Tax tax = dao.getTax(stateAbbreviation);
        if (stateAbbreviation == null
                || stateAbbreviation.trim().length() == 0
                || tax == null) {
            throw new NoSuchStateException("ERROR: Could not get a state. State "
                    + stateAbbreviation + " doesn't exist");
        }
        return tax;
    }

    @Override
    public Order calculate(Order newOrder) throws FlooringPersistenceException, 
            NoSuchProductTypeException,
            NoSuchStateException {
        Product newProduct = getProduct(newOrder.getProductType());
        Tax newTax = getTax(newOrder.getState());
        BigDecimal materialCost = newOrder.getArea().multiply(newProduct.getCostPerSquareFoot());
        BigDecimal laborCost = newOrder.getArea().multiply(newProduct.getLaborCostPerSquareFoot());
        BigDecimal taxRateDecimal = newTax.getTaxRate().divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
        BigDecimal tax = materialCost.add(laborCost).multiply(taxRateDecimal);
        BigDecimal total = materialCost.add(laborCost).add(tax);
        newOrder.setTaxRate(newTax.getTaxRate());
        newOrder.setCostPerSquareFoot(newProduct.getCostPerSquareFoot());
        newOrder.setLaborCostPerSquareFoot(newProduct.getLaborCostPerSquareFoot());
        newOrder.setMaterialCost(materialCost.setScale(2, RoundingMode.HALF_UP));
        newOrder.setLaborCost(laborCost.setScale(2, RoundingMode.HALF_UP));
        newOrder.setTaxAmount(tax.setScale(2, RoundingMode.HALF_UP));
        newOrder.setTotal(total.setScale(2, RoundingMode.HALF_UP));

        return newOrder;
    }

    private void validateNameData(Order order) throws FlooringDataValidationException {

        if (order.getCustomerName() == null
                || order.getCustomerName().trim().length() == 0
                || !Pattern.matches("[a-zA-Z0-9\\s]+", order.getCustomerName())) {

            throw new FlooringDataValidationException(
                    "ERROR: Name should be included and should have only spaces and characters [a-z][A-Z][0-9].");
        }
    }

    private void validateDate(Order order) throws IncorrectDateException {

        if (!order.getOrderDate().isAfter(LocalDate.now())) {

            throw new IncorrectDateException(
                    "ERROR: Date must be in the future.");
        }
    }

    private void validateState(Order order) throws NoSuchStateException, FlooringPersistenceException {

        if (dao.getTax(order.getState()) == null) {
            
            throw new NoSuchStateException("ERROR: Could not create/edit order. State "
                    + order.getState() + " doesn't exist");
        }
    }

    private void validateProduct(Order order) throws NoSuchProductTypeException, FlooringPersistenceException {

        if (dao.getProduct(order.getProductType()) == null) {
            
            throw new NoSuchProductTypeException("ERROR: Could not create/edit order. Product "
                    + order.getProductType() + " doesn't exist");
        }
    }

    private void validateArea(Order order) throws InvalidAreaException, FlooringPersistenceException {

        if (order.getArea().compareTo(new BigDecimal("100")) < 0) {
            
            throw new InvalidAreaException("ERROR: Could not create/edit order. Area "
                    + order.getArea() + " should be positive number and min of 100 sq ft.");
        }
    }
}
