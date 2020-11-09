package com.sg.addressbookunittests.dao;

import com.sg.addressbookunittests.dto.Address;
import java.io.FileWriter;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressBookDaoFileImplTest {
    
    AddressBookDao testDao;
    
    public AddressBookDaoFileImplTest() {
    }
    
    @BeforeEach
    public void setUp() throws Exception{
        String testFile = "testbook.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new AddressBookDaoFileImpl(testFile);
        System.out.println("Checking if setUp method is working before any test methods.");
    }
    
    @Test
    public void testAddGetAddress() throws Exception {
        // Create our method test inputs
        String lastName = "Volodkevich";
        Address address = new Address(lastName);
        address.setFirstName("Dmitry");
        address.setStreetAddress("105 Alstead St Apt 6");
        address.setCity("Quincy");
        address.setState("MA");
        address.setZipCode("02171");
        
        // Add the address to the DAO
        testDao.addAddress(lastName, address);
        // Get the address from the DAO
        Address retrievedAddress = testDao.getAddress(lastName);
        
        // Check the data is equal
        assertEquals(address.getLastName(), retrievedAddress.getLastName(), "Checking last name.");
        assertEquals(address.getFirstName(), retrievedAddress.getFirstName(), "Checking first name.");
        assertEquals(address.getStreetAddress(), retrievedAddress.getStreetAddress(), "Checking street address.");
        assertEquals(address.getCity(), retrievedAddress.getCity(), "Checking city.");
        assertEquals(address.getState(), retrievedAddress.getState(), "Checking state.");
        assertEquals(address.getZipCode(), retrievedAddress.getZipCode(), "Checking ZipCode.");
    }
    
   @Test
   public void testAddGetAllAddresses() throws Exception{
       // Create our first address
       Address firstAddress = new Address("Volodkevich");
        firstAddress.setFirstName("Dmitry");
        firstAddress.setStreetAddress("105 Alstead St Apt 6");
        firstAddress.setCity("Quincy");
        firstAddress.setState("MA");
        firstAddress.setZipCode("02171");
        
       // Create our second address
       Address secondAddress = new Address("Similien");
        secondAddress.setFirstName("Violette");
        secondAddress.setStreetAddress("35 Brooks Ave Apt 25");
        secondAddress.setCity("Quincy");
        secondAddress.setState("MA");
        secondAddress.setZipCode("02169");
        
        // Add both our addresses to the DAO
        testDao.addAddress(firstAddress.getLastName(), firstAddress);
        testDao.addAddress(secondAddress.getLastName(), secondAddress);
        
        // Retrieve the list of all addresses within the DAO
        List<Address> allAddresses = testDao.getAllAddresses();
        
        // First check the general contents of the list
        assertNotNull(allAddresses, "The list of addresses must not null.");
        assertEquals(2, allAddresses.size(), "List of addresses should have 2 addresses.");
        
        // Then the specifics
        assertTrue(testDao.getAllAddresses().contains(firstAddress), "The list of addresses should include Volodkevich.");
        assertTrue(testDao.getAllAddresses().contains(secondAddress), "The list of addresses should include Similien.");
   }
   
   @Test
   public void testRemoveAddress() throws Exception{
       // Create two new addresses
       Address firstAddress = new Address("Volodkevich");
        firstAddress.setFirstName("Dmitry");
        firstAddress.setStreetAddress("105 Alstead St Apt 6");
        firstAddress.setCity("Quincy");
        firstAddress.setState("MA");
        firstAddress.setZipCode("02171");
        
       Address secondAddress = new Address("Similien");
        secondAddress.setFirstName("Violette");
        secondAddress.setStreetAddress("35 Brooks Ave Apt 25");
        secondAddress.setCity("Quincy");
        secondAddress.setState("MA");
        secondAddress.setZipCode("02169");
        
        // Add both to the DAO
        testDao.addAddress(firstAddress.getLastName(), firstAddress);
        testDao.addAddress(secondAddress.getLastName(), secondAddress);
        
        // Remove the first address - Volodkevich
        Address removedAddress = testDao.removeAddress(firstAddress.getLastName());
        
        // Check that the correct object was removed.
        assertEquals(removedAddress, firstAddress, "The removed address should be for Volodkevich.");
        
        // Get all the addresses.
        List<Address> allAddresses = testDao.getAllAddresses();
        
        // First check the general contents of the list
        assertNotNull(allAddresses, "All addresses list should be not null.");
        assertEquals(1, allAddresses.size(), "All addresses should only have 1 address.");
        
        // Then the specifics
        assertFalse(allAddresses.contains(firstAddress), "All addresses should NOT include Volodkevich.");
        assertTrue(allAddresses.contains(secondAddress), "All addresses should include Similien.");
        
        // Remove the second address
        removedAddress = testDao.removeAddress(secondAddress.getLastName());
        // Check that the correct object was removed.
        assertEquals(removedAddress, secondAddress, "The removed address should have Similien.");
        
        // Retrieve all of the addresses again, and check the list.
        allAddresses = testDao.getAllAddresses();
        
        // Check the contents of the list - it should be empty
        assertTrue(allAddresses.isEmpty(), "The retrieved list of students should be empty.");;
        
        // Try to 'get' both addresses by their old last names = they should be null!
        Address retrievedAddress = testDao.getAddress(firstAddress.getLastName());
        assertNull(retrievedAddress, "Volodkevich was removed, should be null.");
        
        retrievedAddress = testDao.getAddress(secondAddress.getLastName());
        assertNull(retrievedAddress, "Similien was removed, should be null.");
   }
}
