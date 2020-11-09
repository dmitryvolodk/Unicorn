package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineServiceLayerImplTest {

    private VendingMachineServiceLayer service;

    public VendingMachineServiceLayerImplTest() {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();

        service = new VendingMachineServiceLayerImpl(dao, auditDao);
    }

    @Test
    public void testCreateValidPurchase() {
        // ARRANGE
        // Snickers Bar::5::1.89
        Item item = new Item("Snickers Bar");
        item.setItemsNumber(5);
        item.setCost(new BigDecimal("1.89"));
        BigDecimal money = new BigDecimal("2");
        // ACT
        try {
            service.updateItem(item.getName(), money);
        } catch (VendingMachinePersistenceException
                | VendingMachineInsufficientFundsException
                | VendingMachineNoItemInventoryException e) {
            // ASSERT
            fail("Purchase was valid. No exception should have been thrown.");
        }
    }

    @Test
    public void testCreateInsufficientFundPurchase() throws Exception{
        // ARRANGE
        // Snickers Bar::5::1.89
        Item item = new Item("Snickers Bar");
        item.setItemsNumber(5);
        item.setCost(new BigDecimal("1.89"));
        BigDecimal money = new BigDecimal("1");
        // ACT
        try {
            service.updateItem(item.getName(), money);
            fail("Expected Insufficient Fund Exception was not thrown.");
        } catch (VendingMachinePersistenceException
                | VendingMachineNoItemInventoryException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (VendingMachineInsufficientFundsException e) {
            return;
        }
    }

    @Test
    public void testCreateNoInventoryPurchase(){
        // ARRANGE
        // Mars Bar::0::2.01
        Item item = new Item("Mars Bar");
        item.setItemsNumber(0);
        item.setCost(new BigDecimal("2.01"));
        BigDecimal money = new BigDecimal("3");
        // ACT
        try {
            service.updateItem(item.getName(), money);
            fail("Expected No Inventory Exception was not thrown.");
        } catch (VendingMachinePersistenceException
                | VendingMachineInsufficientFundsException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (VendingMachineNoItemInventoryException e) {
            return;
        }
    }

    @Test
    public void testGetAllItems() throws Exception{
        // ARRANGE
        // Snickers Bar::5::1.89
        Item testCloneOne = new Item("Snickers Bar");
        testCloneOne.setItemsNumber(5);
        testCloneOne.setCost(new BigDecimal("1.89"));
        // Mars Bar::0::2.01
        Item testCloneTwo = new Item("Mars Bar");
        testCloneTwo.setItemsNumber(0);
        testCloneTwo.setCost(new BigDecimal("2.01"));
        
        // ACT & ASSERT
        assertEquals(2, service.getAllItems().size(), "Should only have two items.");
        assertTrue(service.getAllItems().contains(testCloneOne), "The first item should be Snickers Bar.");
        assertTrue(service.getAllItems().contains(testCloneTwo), "The second item should be Mars Bar.");
    }
    
    @Test
    public void testGetItem() throws Exception{
        // ARRANGE
        // Snickers Bar::5::1.89
        Item testClone = new Item("Snickers Bar");
        testClone.setItemsNumber(5);
        testClone.setCost(new BigDecimal("1.89"));
        
        // ACT & ASSERT
        Item shouldBeSnickersBar = service.getItem("Snickers Bar");
        assertNotNull(shouldBeSnickersBar, "Getting Snickers Bar should be not null.");
        assertEquals(testClone, shouldBeSnickersBar, "Item stored under Snickers Bar should be Snickers Bar.");
        
        Item shouldBeNull = service.getItem("Doritos Chips");
        assertNull(shouldBeNull, "Getting Doritos Chips should be null.");
    }
}
