package com.sg.flooring.dao;

import com.sg.flooring.model.Order;
import com.sg.flooring.model.Product;
import com.sg.flooring.model.Tax;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FlooringDaoFileImplTest {

    FlooringDao testDao;

    public FlooringDaoFileImplTest() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        String testFlooringFile = "testflooring.txt";
        String testProductsFile = "testproducts.txt";
        String testTaxesFile = "testtaxes.txt";
        String testOrdersFile = "testorders.txt";
        // User the FileWriter to quickly blank the files
        new FileWriter(testFlooringFile);
        new FileWriter(testOrdersFile);
        testDao = new FlooringDaoFileImpl(testFlooringFile, testProductsFile, testTaxesFile, testOrdersFile);
    }

    @Test
    public void testAddGetOrder() throws Exception {
    // Specify the pattern of the incoming date
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        // Create our method test inputs
        Order order = new Order();
        Integer orderNumber = 1;
        order.setOrderNumber(orderNumber);
        order.setCustomerName("Ada Lovelace");
        order.setState("CA");
        order.setTaxRate(new BigDecimal("25"));
        order.setProductType("Tile");
        order.setArea(new BigDecimal("249"));
        order.setCostPerSquareFoot(new BigDecimal("3.50"));
        order.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        order.setMaterialCost(new BigDecimal("871.50"));
        order.setLaborCost(new BigDecimal("1033.35"));
        order.setTaxAmount(new BigDecimal("476.21"));
        order.setTotal(new BigDecimal("2381.06"));
        order.setOrderDate(LocalDate.parse("06-01-2021", formatter));

        //  Add the order to the DAO
        testDao.addOrder(orderNumber, order);
        // Get the order from the DAO
        Order retrievedOrder = testDao.getOrder(orderNumber);

        // Check the data is equal
        assertEquals(order.getOrderNumber(), retrievedOrder.getOrderNumber(), "Checking order number.");
        assertEquals(order.getCustomerName(), retrievedOrder.getCustomerName(), "Checking order's customer name.");
        assertEquals(order.getState(), retrievedOrder.getState(), "Checking order's state.");
        assertEquals(order.getTaxRate(), retrievedOrder.getTaxRate(), "Checking order's tax rate.");
        assertEquals(order.getProductType(), retrievedOrder.getProductType(), "Checking order's product type.");
        assertEquals(order.getArea(), retrievedOrder.getArea(), "Checking order's area.");
        assertEquals(order.getCostPerSquareFoot(), retrievedOrder.getCostPerSquareFoot(), "Checking order's cost per sq foot.");
        assertEquals(order.getLaborCostPerSquareFoot(), retrievedOrder.getLaborCostPerSquareFoot(), "Checking order's labor cost per sq foot.");
        assertEquals(order.getMaterialCost(), retrievedOrder.getMaterialCost(), "Checking order's material cost.");
        assertEquals(order.getLaborCost(), retrievedOrder.getLaborCost(), "Checking order's labor cost.");
        assertEquals(order.getTaxAmount(), retrievedOrder.getTaxAmount(), "Checking order's tax amount.");
        assertEquals(order.getTotal(), retrievedOrder.getTotal(), "Checking order's total.");
        assertEquals(order.getOrderDate(), retrievedOrder.getOrderDate(), "Checking order date.");
    }
    
    @Test
    public void testAddEditGetOrder() throws Exception {
    // Specify the pattern of the incoming date
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        // Create our method test inputs
        Order order = new Order();
        Integer orderNumber = 1;
        order.setOrderNumber(orderNumber);
        order.setCustomerName("Ada Lovelace");
        order.setState("CA");
        order.setTaxRate(new BigDecimal("25"));
        order.setProductType("Tile");
        order.setArea(new BigDecimal("249"));
        order.setCostPerSquareFoot(new BigDecimal("3.50"));
        order.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        order.setMaterialCost(new BigDecimal("871.50"));
        order.setLaborCost(new BigDecimal("1033.35"));
        order.setTaxAmount(new BigDecimal("476.21"));
        order.setTotal(new BigDecimal("2381.06"));
        order.setOrderDate(LocalDate.parse("06-01-2021", formatter));
        
        Order editedOrder = new Order();
        Integer editedOrderNumber = 1;
        editedOrder.setOrderNumber(editedOrderNumber);
        editedOrder.setCustomerName("Doctor Who");
        editedOrder.setState("WA");
        editedOrder.setTaxRate(new BigDecimal("9.25"));
        editedOrder.setProductType("Wood");
        editedOrder.setArea(new BigDecimal("243.00"));
        editedOrder.setCostPerSquareFoot(new BigDecimal("5.15"));
        editedOrder.setLaborCostPerSquareFoot(new BigDecimal("4.75"));
        editedOrder.setMaterialCost(new BigDecimal("1251.45"));
        editedOrder.setLaborCost(new BigDecimal("1154.25"));
        editedOrder.setTaxAmount(new BigDecimal("216.51"));
        editedOrder.setTotal(new BigDecimal("2622.21"));
        editedOrder.setOrderDate(LocalDate.parse("06-02-2021", formatter));

        // Add the order in the DAO
        testDao.addOrder(orderNumber, order);
        
        // Edit the order in the DAO
        testDao.editOrder(editedOrderNumber, editedOrder);
        
        // Get the order from the DAO
        Order retrievedOrder = testDao.getOrder(orderNumber);

        // Check the data is equal
        assertEquals(editedOrder.getOrderNumber(), retrievedOrder.getOrderNumber(), "Checking order number.");
        assertEquals(editedOrder.getCustomerName(), retrievedOrder.getCustomerName(), "Checking order's customer name.");
        assertEquals(editedOrder.getState(), retrievedOrder.getState(), "Checking order's state.");
        assertEquals(editedOrder.getTaxRate(), retrievedOrder.getTaxRate(), "Checking order's tax rate.");
        assertEquals(editedOrder.getProductType(), retrievedOrder.getProductType(), "Checking order's product type.");
        assertEquals(editedOrder.getArea(), retrievedOrder.getArea(), "Checking order's area.");
        assertEquals(editedOrder.getCostPerSquareFoot(), retrievedOrder.getCostPerSquareFoot(), "Checking order's cost per sq foot.");
        assertEquals(editedOrder.getLaborCostPerSquareFoot(), retrievedOrder.getLaborCostPerSquareFoot(), "Checking order's labor cost per sq foot.");
        assertEquals(editedOrder.getMaterialCost(), retrievedOrder.getMaterialCost(), "Checking order's material cost.");
        assertEquals(editedOrder.getLaborCost(), retrievedOrder.getLaborCost(), "Checking order's labor cost.");
        assertEquals(editedOrder.getTaxAmount(), retrievedOrder.getTaxAmount(), "Checking order's tax amount.");
        assertEquals(editedOrder.getTotal(), retrievedOrder.getTotal(), "Checking order's total.");
        assertEquals(editedOrder.getOrderDate(), retrievedOrder.getOrderDate(), "Checking order date.");
    }
    
        @Test
    public void testAddGetAllOrders() throws Exception {
    // Specify the pattern of the incoming date
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        // Create our first order
        Order firstOrder = new Order();
        firstOrder.setOrderNumber(1);
        firstOrder.setCustomerName("Ada Lovelace");
        firstOrder.setState("CA");
        firstOrder.setTaxRate(new BigDecimal("25"));
        firstOrder.setProductType("Tile");
        firstOrder.setArea(new BigDecimal("249"));
        firstOrder.setCostPerSquareFoot(new BigDecimal("3.50"));
        firstOrder.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        firstOrder.setMaterialCost(new BigDecimal("871.50"));
        firstOrder.setLaborCost(new BigDecimal("1033.35"));
        firstOrder.setTaxAmount(new BigDecimal("476.21"));
        firstOrder.setTotal(new BigDecimal("2381.06"));
        firstOrder.setOrderDate(LocalDate.parse("06-01-2021", formatter));

        // Create our second order
        Order secondOrder = new Order();
        secondOrder.setOrderNumber(2);
        secondOrder.setCustomerName("Doctor Who");
        secondOrder.setState("WA");
        secondOrder.setTaxRate(new BigDecimal("9.25"));
        secondOrder.setProductType("Wood");
        secondOrder.setArea(new BigDecimal("243.00"));
        secondOrder.setCostPerSquareFoot(new BigDecimal("5.15"));
        secondOrder.setLaborCostPerSquareFoot(new BigDecimal("4.75"));
        secondOrder.setMaterialCost(new BigDecimal("1251.45"));
        secondOrder.setLaborCost(new BigDecimal("1154.25"));
        secondOrder.setTaxAmount(new BigDecimal("216.51"));
        secondOrder.setTotal(new BigDecimal("2622.21"));
        secondOrder.setOrderDate(LocalDate.parse("06-02-2021", formatter));
        
        //  Add both our orders to the DAO
        testDao.addOrder(firstOrder.getOrderNumber(), firstOrder);
        testDao.addOrder(secondOrder.getOrderNumber(), secondOrder);
        
        // Retrieve the list of all orders within the DAO
        List<Order> allOrders = testDao.getAllOrders();
        
        // First check the general contents of the list
        assertNotNull(allOrders, "The list of orders must not null");
        assertEquals(2, allOrders.size(), "List of orders should have 2 orders.");
        
        // Then the specifics
        assertTrue(testDao.getAllOrders().contains(firstOrder), "The list of orders should include Ada.");
        assertTrue(testDao.getAllOrders().contains(secondOrder), "The list of orders should include Doctor.");
    }

        @Test
    public void testRemoveOrder() throws Exception {
    // Specify the pattern of the incoming date
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        // Create two new orders
        Order firstOrder = new Order();
        firstOrder.setOrderNumber(1);
        firstOrder.setCustomerName("Ada Lovelace");
        firstOrder.setState("CA");
        firstOrder.setTaxRate(new BigDecimal("25"));
        firstOrder.setProductType("Tile");
        firstOrder.setArea(new BigDecimal("249"));
        firstOrder.setCostPerSquareFoot(new BigDecimal("3.50"));
        firstOrder.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        firstOrder.setMaterialCost(new BigDecimal("871.50"));
        firstOrder.setLaborCost(new BigDecimal("1033.35"));
        firstOrder.setTaxAmount(new BigDecimal("476.21"));
        firstOrder.setTotal(new BigDecimal("2381.06"));
        firstOrder.setOrderDate(LocalDate.parse("06-01-2021", formatter));

        Order secondOrder = new Order();
        secondOrder.setOrderNumber(2);
        secondOrder.setCustomerName("Doctor Who");
        secondOrder.setState("WA");
        secondOrder.setTaxRate(new BigDecimal("9.25"));
        secondOrder.setProductType("Wood");
        secondOrder.setArea(new BigDecimal("243.00"));
        secondOrder.setCostPerSquareFoot(new BigDecimal("5.15"));
        secondOrder.setLaborCostPerSquareFoot(new BigDecimal("4.75"));
        secondOrder.setMaterialCost(new BigDecimal("1251.45"));
        secondOrder.setLaborCost(new BigDecimal("1154.25"));
        secondOrder.setTaxAmount(new BigDecimal("216.51"));
        secondOrder.setTotal(new BigDecimal("2622.21"));
        secondOrder.setOrderDate(LocalDate.parse("06-02-2021", formatter));
        
        // Add both to the DAO
        testDao.addOrder(firstOrder.getOrderNumber(), firstOrder);
        testDao.addOrder(secondOrder.getOrderNumber(), secondOrder);
        
        // Remove the first order - #1 - Ada
        Order removedOrder = testDao.removeOrder(firstOrder.getOrderNumber());
        
        // Check that the correct object was removed
        assertEquals(removedOrder, firstOrder, "The removed order should be #1 - Ada");
        
        // Get all the orders
        List<Order> allOrders = testDao.getAllOrders();
        
        // First check the general contents of the list
        assertNotNull(allOrders, "All orders list should be not null");
        assertEquals(1, allOrders.size(), "All orders should only have 1 order.");
        
        // Then the specifics
        assertFalse(allOrders.contains(firstOrder), "All orders should NOT include #1 - Ada.");
        assertTrue(allOrders.contains(secondOrder), "The list of orders should include #2 - Doctor.");
        
        // Remove the second order - #2 - Doctor
        removedOrder = testDao.removeOrder(secondOrder.getOrderNumber());
        // Check that the correct object was removed.
        assertEquals(removedOrder, secondOrder, "The removed order should be #2 - Doctor");
        
        // Retrieve all the orders again, and check the list
        allOrders = testDao.getAllOrders();
        
        // Check the contents of the list - it should be empty
        assertTrue(allOrders.isEmpty(), "The retrieved list of orders should be empty.");
        
        // Try to 'get' both orders by their old order number - they should be null!
        Order retrievedOrder = testDao.getOrder(firstOrder.getOrderNumber());
        assertNull(retrievedOrder, "Ada was removed, should be null.");
        
        retrievedOrder = testDao.getOrder(secondOrder.getOrderNumber());
        assertNull(retrievedOrder, "Doctor was removed, should be null.");
    }
    
    @Test
    public void testGetProduct() throws Exception {
        // Create our method test inputs
        String productType = "Tile";
        Product product = new Product(productType);
        product.setCostPerSquareFoot(new BigDecimal("3.50"));
        product.setLaborCostPerSquareFoot(new BigDecimal("4.15"));

        // Get the product from the DAO
        Product retrievedProduct = testDao.getProduct(productType);

        // Check the data is equal
        assertEquals(product.getProductType(), retrievedProduct.getProductType(), "Checking product type.");
        assertEquals(product.getCostPerSquareFoot(), retrievedProduct.getCostPerSquareFoot(), "Checking Cost Per Square Foot.");
        assertEquals(product.getLaborCostPerSquareFoot(), retrievedProduct.getLaborCostPerSquareFoot(), "Checking Labor Cost Per Square Foot.");
    }
    
    @Test
    public void testGetTax() throws Exception {
        // Create our method test inputs
        String stateAbbreviation = "CA";
        Tax tax = new Tax(stateAbbreviation);
        tax.setStateName("California");
        tax.setTaxRate(new BigDecimal("25.00"));

        // Get the tax from the DAO
        Tax retrievedTax = testDao.getTax(stateAbbreviation);

        // Check the data is equal
        assertEquals(tax.getStateAbbreviation(), retrievedTax.getStateAbbreviation(), "Checking state abbreviation.");
        assertEquals(tax.getStateName(), retrievedTax.getStateName(), "Checking state name.");
        assertEquals(tax.getTaxRate(), retrievedTax.getTaxRate(), "Checking tax rate.");
    }
}
