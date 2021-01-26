package com.sg.vendingmachinespringdi.dao;

import com.sg.vendingmachinespringdi.dto.Item;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineDaoFileImplTest {

    VendingMachineDao testDao;

    public VendingMachineDaoFileImplTest() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testmachine.txt";
        testDao = new VendingMachineDaoFileImpl(testFile);
    }

    @Test
    public void testUpdateGetItem() throws Exception {
        // Create our method test inputs
        String name = "Snickers Bar";
        Item item = testDao.getItem(name);
        item.setItemsNumber(item.getItemsNumber() - 1);

        //  Update the item in the DAO
        testDao.updateItem(name, item);
        // Get the item from the DAO
        Item retrievedItem = testDao.getItem(name);

        // Check the data is equal
        assertEquals(item.getName(),
                retrievedItem.getName(),
                "Checking item name.");
        assertEquals(item.getItemsNumber(),
                retrievedItem.getItemsNumber(),
                "Checking items number.");
        assertEquals(item.getCost(),
                retrievedItem.getCost(),
                "Checking item cost.");
    }

    @Test
    public void testUpdateGetAllItems() throws Exception {
        
        
        // Create our first item
        String firstName = "Clif Bar";
        Item firstItem = testDao.getItem(firstName);
        firstItem.setItemsNumber(firstItem.getItemsNumber() - 1);

        // Create our second item
        String secondName = "Sun Chips";
        Item secondItem = testDao.getItem(secondName);
        secondItem.setItemsNumber(secondItem.getItemsNumber() - 1);

        //  Update both items in the DAO
        testDao.updateItem(firstItem.getName(), firstItem);
        testDao.updateItem(secondItem.getName(), secondItem);

        // Retrieve the List of all items in the dao
        List<Item> allItems = testDao.getAllItems();

        // First check the general contest of the list
        assertNotNull(allItems, "The list of items must not null");
        assertEquals(5, allItems.size(), "List of items should have 5 items");

        // Then the specifics
        assertTrue(testDao.getAllItems().contains(firstItem),
                "The list of items should include Clif Bar");
        assertTrue(testDao.getAllItems().contains(secondItem),
                "The list of items should include Sun Chips");
        assertEquals(firstItem.getItemsNumber(), testDao.getItem(firstName).getItemsNumber(),
                "Checking first items number.");
        assertEquals(secondItem.getItemsNumber(), testDao.getItem(secondName).getItemsNumber(),
                "Checking second items number.");
    }
}
