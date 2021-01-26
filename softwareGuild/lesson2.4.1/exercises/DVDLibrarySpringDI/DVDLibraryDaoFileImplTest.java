package com.sg.dvdlibraryspringdi.dao;

import com.sg.dvdlibraryspringdi.dto.DVD;
import java.io.FileWriter;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DVDLibraryDaoFileImplTest {

    DVDLibraryDao testDao;

    public DVDLibraryDaoFileImplTest() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testlibrary.txt";
        // User the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new DVDLibraryDaoFileImpl(testFile);
    }

    @Test
    public void testAddGetDVD() throws Exception {
        // Create our method test inputs
        String title = "Scorpions";
        DVD dvd = new DVD(title);
        dvd.setReleaseDate("12/16/1970");
        dvd.setMPAARating("*****");
        dvd.setDirectorName("Klaus Meine");
        dvd.setStudio("Conny Plank");
        dvd.setUserRating("Cool!");
        
        // Add the dvd to the DAO
        testDao.addDVD(title, dvd);
        // Get the dvd from the DAO
        DVD retrievedDVD = testDao.getDVD(title);
        
        // Check the data is equal
        assertEquals(dvd.getTitle(), retrievedDVD.getTitle(), "Checking dvd title.");
        assertEquals(dvd.getReleaseDate(), retrievedDVD.getReleaseDate(), "Checking dvd release date.");
        assertEquals(dvd.getMPAARating(), retrievedDVD.getMPAARating(), "Checking dvd MPAA Rating.");
        assertEquals(dvd.getDirectorName(), retrievedDVD.getDirectorName(), "Checking dvd Director Name.");
        assertEquals(dvd.getStudio(), retrievedDVD.getStudio(), "Checking dvd Studio.");
        assertEquals(dvd.getUserRating(), retrievedDVD.getUserRating(), "Checking dvd User Rating.");
    }
    
    @Test
    public void testAddGetAllDVDs() throws Exception {
        // Create our first dvd
        DVD firstDVD = new DVD("Scorpions");
        firstDVD.setReleaseDate("12/16/1970");
        firstDVD.setMPAARating("*****");
        firstDVD.setDirectorName("Klaus Meine");
        firstDVD.setStudio("Conny Plank");
        firstDVD.setUserRating("Cool!");
        
        // Create our second dvd
        DVD secondDVD = new DVD("Beatles");
        secondDVD.setReleaseDate("10/01/1960");
        secondDVD.setMPAARating("*****");
        secondDVD.setDirectorName("John Lennon");
        secondDVD.setStudio("Abbey Road");
        secondDVD.setUserRating("Very good!");
        
        // Add both our dvds to the DAO
        testDao.addDVD(firstDVD.getTitle(), firstDVD);
        testDao.addDVD(secondDVD.getTitle(), secondDVD);
        
        // Retrieve the list of all DVDs within the DAO
        List<DVD> allDVDs = testDao.getAllDVDs();
        
        // First check the general contents of the list
        assertNotNull(allDVDs, "The list of DVDs must not null.");
        assertEquals(2, allDVDs.size(), "List of DVDs should have 2 DVDs.");
        
        // Then the specifics
        assertTrue(testDao.getAllDVDs().contains(firstDVD), "The list of DVDs should include Scorpions.");
        assertTrue(testDao.getAllDVDs().contains(secondDVD), "The list of DVDs should include Beatles.");
    }
    
    @Test
    public void testRemoveDVD() throws Exception {
        // Create tow new dvds
        DVD firstDVD = new DVD("Scorpions");
        firstDVD.setReleaseDate("12/16/1970");
        firstDVD.setMPAARating("*****");
        firstDVD.setDirectorName("Klaus Meine");
        firstDVD.setStudio("Conny Plank");
        firstDVD.setUserRating("Cool!");
        
        DVD secondDVD = new DVD("Beatles");
        secondDVD.setReleaseDate("10/01/1960");
        secondDVD.setMPAARating("*****");
        secondDVD.setDirectorName("John Lennon");
        secondDVD.setStudio("Abbey Road");
        secondDVD.setUserRating("Very good!");
        
        // Add both to the DAO
        testDao.addDVD(firstDVD.getTitle(), firstDVD);
        testDao.addDVD(secondDVD.getTitle(), secondDVD);
        
        // Remove the first dvd - Scorpions
        DVD removedDVD = testDao.removeDVD(firstDVD.getTitle());
        
        // Check that the correct object was removed.
        assertEquals(removedDVD, firstDVD, "The removed dvd should be Scorpions.");
                
        // Retrieve the list of all DVDs within the DAO
        List<DVD> allDVDs = testDao.getAllDVDs();
        
        // First check the general contents of the list
        assertNotNull(allDVDs, "All DVDS list should be not null.");
        assertEquals(1, allDVDs.size(), "List of DVDs should have  DVD.");
        
        // Then the specifics
        assertFalse(allDVDs.contains(firstDVD), "All DVDs should NOT include Scorpions.");
        assertTrue(allDVDs.contains(secondDVD), "All DVDs should include Beatles.");
        
        // Remove the second dvd
        removedDVD = testDao.removeDVD(secondDVD.getTitle());
        // Check that the correct object was removed.
        assertEquals(removedDVD, secondDVD, "The removed dvd should be Beatles.");
        
        // Retrieve all the DVDs again, and check the list.
        allDVDs = testDao.getAllDVDs();
        
        // Check the contents of the list - it should be empty
        assertTrue(allDVDs.isEmpty(), "The retrieved list of DVDs should be empty.");
        
        // Try to 'get' both DVDs by their old title - they should be null!
        DVD retrievedDVD = testDao.getDVD(firstDVD.getTitle());
        assertNull(retrievedDVD, "Scorpions was removed, should be null.");
        
        retrievedDVD = testDao.getDVD(secondDVD.getTitle());
        assertNull(retrievedDVD, "Beatles was removed, should be null.");
    }
}
