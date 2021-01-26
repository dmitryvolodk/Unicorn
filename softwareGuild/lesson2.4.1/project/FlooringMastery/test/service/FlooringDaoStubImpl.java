package com.sg.flooring.service;

import com.sg.flooring.dao.FlooringDao;
import com.sg.flooring.dao.FlooringPersistenceException;
import com.sg.flooring.model.Order;
import com.sg.flooring.model.Product;
import com.sg.flooring.model.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FlooringDaoStubImpl implements FlooringDao {

    public Order onlyOrder;
    public Product onlyProduct;
    public Tax onlyTax;

    public FlooringDaoStubImpl() {
        onlyOrder = new Order();
        onlyOrder.setOrderNumber(1);
        onlyOrder.setCustomerName("Ada Lovelace");
        onlyOrder.setState("CA");
        onlyOrder.setTaxRate(new BigDecimal("25"));
        onlyOrder.setProductType("Tile");
        onlyOrder.setArea(new BigDecimal("249"));
        onlyOrder.setCostPerSquareFoot(new BigDecimal("3.50"));
        onlyOrder.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        onlyOrder.setMaterialCost(new BigDecimal("871.50"));
        onlyOrder.setLaborCost(new BigDecimal("1033.35"));
        onlyOrder.setTaxAmount(new BigDecimal("476.21"));
        onlyOrder.setTotal(new BigDecimal("2381.06"));
        onlyOrder.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        
        String productType = "Tile";
        onlyProduct = new Product(productType);
        onlyProduct.setCostPerSquareFoot(new BigDecimal("3.50"));
        onlyProduct.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        
        String stateAbbreviation = "CA";
        onlyTax = new Tax(stateAbbreviation);
        onlyTax.setStateName("California");
        onlyTax.setTaxRate(new BigDecimal("25.00"));
    }

    public FlooringDaoStubImpl(Order testOrder) {
        this.onlyOrder = testOrder;
    }

    @Override
    public Order addOrder(int orderNumber, Order order) throws FlooringPersistenceException {
        if (orderNumber == onlyOrder.getOrderNumber()) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public List<Order> getAllOrders() throws FlooringPersistenceException {
        List<Order> orderList = new ArrayList<>();
        orderList.add(onlyOrder);
        return orderList;
    }

    @Override
    public Order getOrder(Integer orderNumber) throws FlooringPersistenceException {
        if (orderNumber == onlyOrder.getOrderNumber()) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order editOrder(int orderNumber, Order order) throws FlooringPersistenceException {
        if (orderNumber == onlyOrder.getOrderNumber()) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order removeOrder(int orderNumber) throws FlooringPersistenceException {
        if (orderNumber == onlyOrder.getOrderNumber()) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Product getProduct(String productType) throws FlooringPersistenceException {
        if (productType.equals(onlyProduct.getProductType())) {
            return onlyProduct;
        } else {
            return null;
        }
    }

    @Override
    public Tax getTax(String stateAbbreviation) throws FlooringPersistenceException {
        if (stateAbbreviation.equals(onlyTax.getStateAbbreviation())) {
            return onlyTax;
        } else {
            return null;
        }
    }

}
