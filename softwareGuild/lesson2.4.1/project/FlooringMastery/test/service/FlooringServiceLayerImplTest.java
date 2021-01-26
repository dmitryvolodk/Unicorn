package com.sg.flooring.service;

import com.sg.flooring.dao.FlooringDao;
import com.sg.flooring.dao.FlooringPersistenceException;
import com.sg.flooring.model.Order;
import com.sg.flooring.model.Product;
import com.sg.flooring.model.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlooringServiceLayerImplTest {

    private FlooringServiceLayer service;

    public FlooringServiceLayerImplTest() {
        // Wire the Service Layer with stub implementation of the Dao
        // FlooringDao dao = new FlooringDaoStubImpl();
        // service = new FlooringServiceLayerImpl(dao);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("serviceLayer", FlooringServiceLayer.class);
    }

    @Test
    public void testCreateValidOrder() throws Exception {
        // ARRANGE
        Order order = new Order();
        order.setOrderNumber(2);
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
        order.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        // ACT
        try {
            service.createOrder(order);
        } catch (FlooringPersistenceException
                | IncorrectDateException
                | FlooringDataValidationException
                | NoSuchStateException
                | NoSuchProductTypeException
                | InvalidAreaException e) {
            // ASSERT
            fail("Order was valid. No exception should have been thrown.");
        }
    }

    @Test
    public void testCreateIncorrectDateOrder() throws Exception {
        // ARRANGE
        Order order = new Order();
        order.setOrderNumber(2);
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
        order.setOrderDate(LocalDate.parse("06-01-2013", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        // ACT
        try {
            service.createOrder(order);
            fail("Expected Incorrect Date Exception was not thrown.");
        } catch (FlooringPersistenceException
                | FlooringDataValidationException
                | NoSuchStateException
                | NoSuchProductTypeException
                | InvalidAreaException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (IncorrectDateException e) {
            return;
        }
    }

    @Test
    public void testCreateOrderBlankNameInvalidData() throws Exception {
        // ARRANGE
        Order order = new Order();
        order.setOrderNumber(2);
        order.setCustomerName(" ");
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
        order.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        // ACT
        try {
            service.createOrder(order);
            fail("Expected Data Validation Exception was not thrown.");
        } catch (FlooringPersistenceException
                | IncorrectDateException
                | NoSuchStateException
                | NoSuchProductTypeException
                | InvalidAreaException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (FlooringDataValidationException e) {
            return;
        }
    }

    @Test
    public void testCreateOrderWrongSymbolInvalidData() throws Exception {
        // ARRANGE
        Order order = new Order();
        order.setOrderNumber(2);
        order.setCustomerName("Ada L*ovelace");
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
        order.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        // ACT
        try {
            service.createOrder(order);
            fail("Expected Data Validation Exception was not thrown.");
        } catch (FlooringPersistenceException
                | IncorrectDateException
                | NoSuchStateException
                | NoSuchProductTypeException
                | InvalidAreaException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (FlooringDataValidationException e) {
            return;
        }
    }

    @Test
    public void testCreateOrderNoSuchState() throws Exception {
        // ARRANGE
        Order order = new Order();
        order.setOrderNumber(2);
        order.setCustomerName("Ada Lovelace");
        order.setState("MA");
        order.setTaxRate(new BigDecimal("25"));
        order.setProductType("Tile");
        order.setArea(new BigDecimal("249"));
        order.setCostPerSquareFoot(new BigDecimal("3.50"));
        order.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        order.setMaterialCost(new BigDecimal("871.50"));
        order.setLaborCost(new BigDecimal("1033.35"));
        order.setTaxAmount(new BigDecimal("476.21"));
        order.setTotal(new BigDecimal("2381.06"));
        order.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        // ACT
        try {
            service.createOrder(order);
            fail("Expected No Such State Exception was not thrown.");
        } catch (FlooringPersistenceException
                | IncorrectDateException
                | FlooringDataValidationException
                | NoSuchProductTypeException
                | InvalidAreaException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (NoSuchStateException e) {
            return;
        }
    }

    @Test
    public void testCreateOrderNoSuchProduct() throws Exception {
        // ARRANGE
        Order order = new Order();
        order.setOrderNumber(2);
        order.setCustomerName("Ada Lovelace");
        order.setState("CA");
        order.setTaxRate(new BigDecimal("25"));
        order.setProductType("Plastic");
        order.setArea(new BigDecimal("249"));
        order.setCostPerSquareFoot(new BigDecimal("3.50"));
        order.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        order.setMaterialCost(new BigDecimal("871.50"));
        order.setLaborCost(new BigDecimal("1033.35"));
        order.setTaxAmount(new BigDecimal("476.21"));
        order.setTotal(new BigDecimal("2381.06"));
        order.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        // ACT
        try {
            service.createOrder(order);
            fail("Expected No Such Product Type Exception was not thrown.");
        } catch (FlooringPersistenceException
                | IncorrectDateException
                | FlooringDataValidationException
                | NoSuchStateException
                | InvalidAreaException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (NoSuchProductTypeException e) {
            return;
        }
    }

    @Test
    public void testCreateOrderInvalidAreaLessHundred() throws Exception {
        // ARRANGE
        Order order = new Order();
        order.setOrderNumber(2);
        order.setCustomerName("Ada Lovelace");
        order.setState("CA");
        order.setTaxRate(new BigDecimal("25"));
        order.setProductType("Tile");
        order.setArea(new BigDecimal("99.00"));
        order.setCostPerSquareFoot(new BigDecimal("3.50"));
        order.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        order.setMaterialCost(new BigDecimal("871.50"));
        order.setLaborCost(new BigDecimal("1033.35"));
        order.setTaxAmount(new BigDecimal("476.21"));
        order.setTotal(new BigDecimal("2381.06"));
        order.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        // ACT
        try {
            service.createOrder(order);
            fail("Expected Invalid Area Exception was not thrown.");
        } catch (FlooringPersistenceException
                | IncorrectDateException
                | FlooringDataValidationException
                | NoSuchStateException
                | NoSuchProductTypeException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (InvalidAreaException e) {
            return;
        }
    }

    @Test
    public void testCreateOrderInvalidNegativeArea() throws Exception {
        // ARRANGE
        Order order = new Order();
        order.setOrderNumber(2);
        order.setCustomerName("Ada Lovelace");
        order.setState("CA");
        order.setTaxRate(new BigDecimal("25"));
        order.setProductType("Tile");
        order.setArea(new BigDecimal("-249.00"));
        order.setCostPerSquareFoot(new BigDecimal("3.50"));
        order.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        order.setMaterialCost(new BigDecimal("871.50"));
        order.setLaborCost(new BigDecimal("1033.35"));
        order.setTaxAmount(new BigDecimal("476.21"));
        order.setTotal(new BigDecimal("2381.06"));
        order.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        // ACT
        try {
            service.createOrder(order);
            fail("Expected Invalid Area Exception was not thrown.");
        } catch (FlooringPersistenceException
                | IncorrectDateException
                | FlooringDataValidationException
                | NoSuchStateException
                | NoSuchProductTypeException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (InvalidAreaException e) {
            return;
        }
    }

    @Test
    public void testGetAllOrders() throws Exception {
        // ARRANGE
        Order testClone = new Order();
        testClone.setOrderNumber(1);
        testClone.setCustomerName("Ada Lovelace");
        testClone.setState("CA");
        testClone.setTaxRate(new BigDecimal("25"));
        testClone.setProductType("Tile");
        testClone.setArea(new BigDecimal("249"));
        testClone.setCostPerSquareFoot(new BigDecimal("3.50"));
        testClone.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        testClone.setMaterialCost(new BigDecimal("871.50"));
        testClone.setLaborCost(new BigDecimal("1033.35"));
        testClone.setTaxAmount(new BigDecimal("476.21"));
        testClone.setTotal(new BigDecimal("2381.06"));
        testClone.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));

        // ACT & ASSERT
        assertEquals(1, service.getAllOrders().size(), "Should only have one order.");

        assertTrue(service.getAllOrders().contains(testClone), "The one order should be Ada. - #1");
    }

    @Test
    public void testGetAllOrdersByDateExistingOrder() throws Exception {
        // ARRANGE - the order #1 for Ada is already in the Stubed DAO

        // ACT
        try {
            service.getAllOrders(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        } catch (FlooringPersistenceException
                | NoSuchOrderException e) {
            // ASSERT
            fail("Order was valid. No exception should have been thrown.");
        }
    }

    @Test
    public void testGetAllOrdersByDateIncorrectDate() throws Exception {
        // ARRANGE - the order #1 for Ada is already in the Stubed DAO

        // ACT
        try {
            service.getAllOrders(LocalDate.parse("06-02-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
            fail("Expected No Such Order Exception was not thrown.");
        } catch (FlooringPersistenceException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (NoSuchOrderException e) {
            return;
        }
    }

    @Test
    public void testGetOrder() throws Exception {
        // ARRANGE
        Order testClone = new Order();
        testClone.setOrderNumber(1);
        testClone.setCustomerName("Ada Lovelace");
        testClone.setState("CA");
        testClone.setTaxRate(new BigDecimal("25"));
        testClone.setProductType("Tile");
        testClone.setArea(new BigDecimal("249"));
        testClone.setCostPerSquareFoot(new BigDecimal("3.50"));
        testClone.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        testClone.setMaterialCost(new BigDecimal("871.50"));
        testClone.setLaborCost(new BigDecimal("1033.35"));
        testClone.setTaxAmount(new BigDecimal("476.21"));
        testClone.setTotal(new BigDecimal("2381.06"));
        testClone.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));

        // ACT & ASSERT
        Order shouldBeAda = service.getOrder(1);
        assertNotNull(shouldBeAda, "Getting 1 should be not null.");
        assertEquals(testClone, shouldBeAda, "Order stored under 1 should be Ada.");

        Order shouldBeNull = service.getOrder(2);
        assertNull(shouldBeNull, "Getting 2 should be null.");
    }

    @Test
    public void testEditValidOrder() throws Exception {
        // ARRANGE
        Order order = new Order();
        order.setOrderNumber(2);
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
        order.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        // ACT
        try {
            service.editOrder(order);
        } catch (FlooringPersistenceException
                | FlooringDataValidationException
                | NoSuchStateException
                | NoSuchProductTypeException
                | InvalidAreaException e) {
            // ASSERT
            fail("Order was valid. No exception should have been thrown.");
        }
    }

    @Test
    public void testEditOrderBlankNameInvalidData() throws Exception {
        // ARRANGE
        Order order = new Order();
        order.setOrderNumber(2);
        order.setCustomerName(" ");
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
        order.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        // ACT
        try {
            service.editOrder(order);
            fail("Expected Data Validation Exception was not thrown.");
        } catch (FlooringPersistenceException
                | NoSuchStateException
                | NoSuchProductTypeException
                | InvalidAreaException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (FlooringDataValidationException e) {
            return;
        }
    }

    @Test
    public void testEditOrderWrongSymbolInvalidData() throws Exception {
        // ARRANGE
        Order order = new Order();
        order.setOrderNumber(2);
        order.setCustomerName("Ada L*ovelace");
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
        order.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        // ACT
        try {
            service.editOrder(order);
            fail("Expected Data Validation Exception was not thrown.");
        } catch (FlooringPersistenceException
                | NoSuchStateException
                | NoSuchProductTypeException
                | InvalidAreaException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (FlooringDataValidationException e) {
            return;
        }
    }

    @Test
    public void testEditOrderNoSuchState() throws Exception {
        // ARRANGE
        Order order = new Order();
        order.setOrderNumber(2);
        order.setCustomerName("Ada Lovelace");
        order.setState("MA");
        order.setTaxRate(new BigDecimal("25"));
        order.setProductType("Tile");
        order.setArea(new BigDecimal("249"));
        order.setCostPerSquareFoot(new BigDecimal("3.50"));
        order.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        order.setMaterialCost(new BigDecimal("871.50"));
        order.setLaborCost(new BigDecimal("1033.35"));
        order.setTaxAmount(new BigDecimal("476.21"));
        order.setTotal(new BigDecimal("2381.06"));
        order.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        // ACT
        try {
            service.editOrder(order);
            fail("Expected No Such State Exception was not thrown.");
        } catch (FlooringPersistenceException
                | FlooringDataValidationException
                | NoSuchProductTypeException
                | InvalidAreaException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (NoSuchStateException e) {
            return;
        }
    }

    @Test
    public void testEditOrderNoSuchProduct() throws Exception {
        // ARRANGE
        Order order = new Order();
        order.setOrderNumber(2);
        order.setCustomerName("Ada Lovelace");
        order.setState("CA");
        order.setTaxRate(new BigDecimal("25"));
        order.setProductType("Plastic");
        order.setArea(new BigDecimal("249"));
        order.setCostPerSquareFoot(new BigDecimal("3.50"));
        order.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        order.setMaterialCost(new BigDecimal("871.50"));
        order.setLaborCost(new BigDecimal("1033.35"));
        order.setTaxAmount(new BigDecimal("476.21"));
        order.setTotal(new BigDecimal("2381.06"));
        order.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        // ACT
        try {
            service.editOrder(order);
            fail("Expected No Such Product Type Exception was not thrown.");
        } catch (FlooringPersistenceException
                | FlooringDataValidationException
                | NoSuchStateException
                | InvalidAreaException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (NoSuchProductTypeException e) {
            return;
        }
    }

    @Test
    public void testEditOrderInvalidAreaLessHundred() throws Exception {
        // ARRANGE
        Order order = new Order();
        order.setOrderNumber(2);
        order.setCustomerName("Ada Lovelace");
        order.setState("CA");
        order.setTaxRate(new BigDecimal("25"));
        order.setProductType("Tile");
        order.setArea(new BigDecimal("99.00"));
        order.setCostPerSquareFoot(new BigDecimal("3.50"));
        order.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        order.setMaterialCost(new BigDecimal("871.50"));
        order.setLaborCost(new BigDecimal("1033.35"));
        order.setTaxAmount(new BigDecimal("476.21"));
        order.setTotal(new BigDecimal("2381.06"));
        order.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        // ACT
        try {
            service.editOrder(order);
            fail("Expected Invalid Area Exception was not thrown.");
        } catch (FlooringPersistenceException
                | FlooringDataValidationException
                | NoSuchStateException
                | NoSuchProductTypeException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (InvalidAreaException e) {
            return;
        }
    }

    @Test
    public void testEditOrderInvalidNegativeArea() throws Exception {
        // ARRANGE
        Order order = new Order();
        order.setOrderNumber(2);
        order.setCustomerName("Ada Lovelace");
        order.setState("CA");
        order.setTaxRate(new BigDecimal("25"));
        order.setProductType("Tile");
        order.setArea(new BigDecimal("-249"));
        order.setCostPerSquareFoot(new BigDecimal("3.50"));
        order.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        order.setMaterialCost(new BigDecimal("871.50"));
        order.setLaborCost(new BigDecimal("1033.35"));
        order.setTaxAmount(new BigDecimal("476.21"));
        order.setTotal(new BigDecimal("2381.06"));
        order.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        // ACT
        try {
            service.editOrder(order);
            fail("Expected Invalid Area Exception was not thrown.");
        } catch (FlooringPersistenceException
                | FlooringDataValidationException
                | NoSuchStateException
                | NoSuchProductTypeException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (InvalidAreaException e) {
            return;
        }
    }

    @Test
    public void testRemoveOrder() throws Exception {
        // ARRANGE
        Order testClone = new Order();
        testClone.setOrderNumber(1);
        testClone.setCustomerName("Ada Lovelace");
        testClone.setState("CA");
        testClone.setTaxRate(new BigDecimal("25"));
        testClone.setProductType("Tile");
        testClone.setArea(new BigDecimal("249"));
        testClone.setCostPerSquareFoot(new BigDecimal("3.50"));
        testClone.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        testClone.setMaterialCost(new BigDecimal("871.50"));
        testClone.setLaborCost(new BigDecimal("1033.35"));
        testClone.setTaxAmount(new BigDecimal("476.21"));
        testClone.setTotal(new BigDecimal("2381.06"));
        testClone.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));

        // ACT & ASSERT
        Order shouldBeAda = service.removeOrder(1);
        assertNotNull(shouldBeAda, "Removing 1 should be not null.");
        assertEquals(testClone, shouldBeAda, "Order removed from 1 should be Ada.");

        Order shouldBeNull = service.removeOrder(2);
        assertNull(shouldBeNull, "Removing 2 should be null.");
    }

    @Test
    public void testGetProduct() throws Exception {
        // ARRANGE
        String productType = "Tile";
        Product testClone = new Product(productType);
        testClone.setCostPerSquareFoot(new BigDecimal("3.50"));
        testClone.setLaborCostPerSquareFoot(new BigDecimal("4.15"));

        // ACT & ASSERT
        Product shouldBeTile = service.getProduct(productType);
        assertNotNull(shouldBeTile, "Getting Tile should be not null.");
        assertEquals(testClone, shouldBeTile, "Product stored under Tile should be Tile.");
    }

    @Test
    public void testGetProductExistingProduct() throws Exception {
        // ARRANGE - the product Tile is already in the Stubed DAO

        // ACT
        try {
            Product product = service.getProduct("Tile");
        } catch (FlooringPersistenceException
                | NoSuchProductTypeException e) {
            // ASSERT
            fail("Product was valid. No exception should have been thrown.");
        }
    }

    @Test
    public void testGetProductInvalidProduct() throws Exception {
        // ARRANGE - the product Tile is already in the Stubed DAO

        // ACT
        try {
            Product product = service.getProduct("Plastic");
            fail("Expected No Such Product Exception was not thrown.");
        } catch (FlooringPersistenceException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (NoSuchProductTypeException e) {
            return;
        }
    }

    @Test
    public void testGetTax() throws Exception {
        // ARRANGE
        String stateAbbreviation = "CA";
        Tax testClone = new Tax(stateAbbreviation);
        testClone.setStateName("California");
        testClone.setTaxRate(new BigDecimal("25.00"));

        // ACT & ASSERT
        Tax shouldBeCalifornia = service.getTax(stateAbbreviation);
        assertNotNull(shouldBeCalifornia, "Getting California should be not null.");
        assertEquals(testClone, shouldBeCalifornia, "Tax stored under California should be California.");
    }

    @Test
    public void testGetTaxExistingTax() throws Exception {
        // ARRANGE - the tax CA is already in the Stubed DAO

        // ACT
        try {
            Tax tax = service.getTax("CA");
        } catch (FlooringPersistenceException
                | NoSuchStateException e) {
            // ASSERT
            fail("Tax was valid. No exception should have been thrown.");
        }
    }

    @Test
    public void testGetTaxInvalidTax() throws Exception {
        // ARRANGE - the tax CA is already in the Stubed DAO

        // ACT
        try {
            Tax tax = service.getTax("MA");
            fail("Expected No Such State Exception was not thrown.");
        } catch (FlooringPersistenceException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (NoSuchStateException e) {
            return;
        }
    }

    @Test
    public void testCalculate() throws Exception {
        // ARRANGE
        Integer orderNumber = 1;

        Order inputOrder = new Order();
        inputOrder.setOrderNumber(orderNumber);
        inputOrder.setCustomerName("Ada Lovelace");
        inputOrder.setState("CA");
        inputOrder.setProductType("Tile");
        inputOrder.setArea(new BigDecimal("249.00"));
        inputOrder.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));

        Order testClone = new Order();
        testClone.setOrderNumber(orderNumber);
        testClone.setCustomerName("Ada Lovelace");
        testClone.setState("CA");
        testClone.setTaxRate(new BigDecimal("25.00"));
        testClone.setProductType("Tile");
        testClone.setArea(new BigDecimal("249.00"));
        testClone.setCostPerSquareFoot(new BigDecimal("3.50"));
        testClone.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        testClone.setMaterialCost(new BigDecimal("871.50"));
        testClone.setLaborCost(new BigDecimal("1033.35"));
        testClone.setTaxAmount(new BigDecimal("476.21"));
        testClone.setTotal(new BigDecimal("2381.06"));
        testClone.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));

        // ACT & ASSERT
        Order shouldBeCorrectAda = service.calculate(inputOrder);
        assertNotNull(shouldBeCorrectAda, "Calculating Ada should be not null.");
        assertEquals(testClone.getOrderNumber(), shouldBeCorrectAda.getOrderNumber(), "OrderNumber should be calculated correctly.");
        assertEquals(testClone.getCustomerName(), shouldBeCorrectAda.getCustomerName(), "CustomerName should be calculated correctly.");
        assertEquals(testClone.getState(), shouldBeCorrectAda.getState(), "State should be calculated correctly.");
        assertEquals(testClone.getTaxRate(), shouldBeCorrectAda.getTaxRate(), "TaxRate should be calculated correctly.");
        assertEquals(testClone.getProductType(), shouldBeCorrectAda.getProductType(), "ProductType should be calculated correctly.");
        assertEquals(testClone.getArea(), shouldBeCorrectAda.getArea(), "Area should be calculated correctly.");
        assertEquals(testClone.getCostPerSquareFoot(), shouldBeCorrectAda.getCostPerSquareFoot(), "CostPerSqFoot should be calculated correctly.");
        assertEquals(testClone.getLaborCostPerSquareFoot(), shouldBeCorrectAda.getLaborCostPerSquareFoot(), "LaborCostPerSqFoot should be calculated correctly.");
        assertEquals(testClone.getMaterialCost(), shouldBeCorrectAda.getMaterialCost(), "MaterialCost should be calculated correctly.");
        assertEquals(testClone.getLaborCost(), shouldBeCorrectAda.getLaborCost(), "LaborCost should be calculated correctly.");
        assertEquals(testClone.getTaxAmount(), shouldBeCorrectAda.getTaxAmount(), "TaxAmount should be calculated correctly.");
        assertEquals(testClone.getTotal(), shouldBeCorrectAda.getTotal(), "Total should be calculated correctly.");
        assertEquals(testClone.getOrderDate(), shouldBeCorrectAda.getOrderDate(), "OrderDate should be calculated correctly.");
        assertEquals(testClone, shouldBeCorrectAda, "Order for Ada should be calculated correctly.");
    }

    @Test
    public void testCalculateExistingProductAndState() throws Exception {
        // ARRANGE
        Integer orderNumber = 1;

        Order inputOrder = new Order();
        inputOrder.setOrderNumber(orderNumber);
        inputOrder.setCustomerName("Ada Lovelace");
        inputOrder.setState("CA");
        inputOrder.setProductType("Tile");
        inputOrder.setArea(new BigDecimal("249"));
        inputOrder.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));

        // ACT
        try {
            Order order = service.calculate(inputOrder);
        } catch (FlooringPersistenceException
                | NoSuchProductTypeException
                | NoSuchStateException e) {
            // ASSERT
            fail("Product was valid. No exception should have been thrown.");
        }
    }

    @Test
    public void testCalculateInvalidProduct() throws Exception {
        // ARRANGE
        Integer orderNumber = 1;

        Order inputOrder = new Order();
        inputOrder.setOrderNumber(orderNumber);
        inputOrder.setCustomerName("Ada Lovelace");
        inputOrder.setState("CA");
        inputOrder.setProductType("Plastic");
        inputOrder.setArea(new BigDecimal("249"));
        inputOrder.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));

        // ACT
        try {
            Order order = service.calculate(inputOrder);
            fail("Expected No Such Product Exception was not thrown.");
        } catch (FlooringPersistenceException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (NoSuchProductTypeException e) {
            return;
        }
    }

    @Test
    public void testCalculateInvalidTax() throws Exception {
        // ARRANGE
        Integer orderNumber = 1;

        Order inputOrder = new Order();
        inputOrder.setOrderNumber(orderNumber);
        inputOrder.setCustomerName("Ada Lovelace");
        inputOrder.setState("MA");
        inputOrder.setProductType("Tile");
        inputOrder.setArea(new BigDecimal("249"));
        inputOrder.setOrderDate(LocalDate.parse("06-01-2021", DateTimeFormatter.ofPattern("MM-dd-yyyy")));

        // ACT
        try {
            Order order = service.calculate(inputOrder);
            fail("Expected No Such State Exception was not thrown.");
        } catch (FlooringPersistenceException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (NoSuchStateException e) {
            return;
        }
    }
}
