package com.sg.monsterousdaotesting.dao.implementations.buggy;

import com.sg.monsterousdaotesting.dao.MonsterDao;
import com.sg.monsterousdaotesting.model.Monster;
import com.sg.monsterousdaotesting.model.MonsterType;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BadMonsterDaoDTest {
    
    MonsterDao testDao;
    
    public BadMonsterDaoDTest() {
    }
    
    @BeforeEach
    public void setUp() throws Exception{
        testDao = new BadMonsterDaoD();
    }

    @Test
    public void testAddGetMonster() throws Exception {
        // Create our method test inputs
        int monsterId = 1;
        String name = "Lion";
        MonsterType type = MonsterType.YETI;
        int peopleEaten = 3;
        String favoriteFood = "mashmello";
        Monster monster = new Monster(name, type, peopleEaten, favoriteFood);
        
        // Add the monster to the DAO
        testDao.addMonster(monsterId, monster);
        // Get the monster from the DAO
        Monster retrievedMonster = testDao.getMonster(monsterId);
        
        // Check the data is equal
        assertEquals(monster.getName(), retrievedMonster.getName(), "Checking monster name.");
        assertEquals(monster.getType(), retrievedMonster.getType(), "Checking monster type.");
        assertEquals(monster.getPeopleEaten(), retrievedMonster.getPeopleEaten(), "Checking monster people eaten.");
        assertEquals(monster.getFavoriteFood(), retrievedMonster.getFavoriteFood(), "Checking monster favorite food.");
    }
    
    @Test
    public void testAddGetAllMonsters() throws Exception{
        // Create our first monster
        int firstMonsterId = 1;
        Monster firstMonster = new Monster("Lion", MonsterType.YETI, 3, "mashmello");
        
        // Create our second monster
        int secondMonsterId = 2;
        Monster secondMonster = new Monster("Tiger", MonsterType.SWAMPTHING, 5, "beef");
        
        // Add both our monsters to the DAO
        testDao.addMonster(firstMonsterId, firstMonster);
        testDao.addMonster(secondMonsterId, secondMonster);
        
        // Retrieve the list of all monsters within the DAO
        List<Monster> allMonsters = testDao.getAllMonsters();
        
        // First check the general contents of the list
        assertNotNull(allMonsters, "The list of monsters must not null.");
        assertEquals(2, allMonsters.size(), "List of monsters should have 2 monsters.");
        
        // Then the specifics
        assertTrue(testDao.getAllMonsters().contains(firstMonster), "The list of monsters should include Lion.");
        assertTrue(testDao.getAllMonsters().contains(secondMonster), "The list of monsters should include Tiger.");
    }
    
    @Test
    public void testRemoveMonster() throws Exception{
        // Create two new monsters
        int firstMonsterId = 1;
        Monster firstMonster = new Monster("Lion", MonsterType.YETI, 3, "mashmello");
        
        int secondMonsterId = 2;
        Monster secondMonster = new Monster("Tiger", MonsterType.SWAMPTHING, 5, "beef");
        
        // Add both to the DAO
        testDao.addMonster(firstMonsterId, firstMonster);
        testDao.addMonster(secondMonsterId, secondMonster);
        
        // Remove the first monster - Lion
        Monster removedMonster = testDao.removeMonster(firstMonsterId);
        
        // Check that the correct object was removed
        assertEquals(removedMonster, firstMonster, "The removed monster should be Lion.");
        
        // Get all the monsters
        List<Monster> allMonsters = testDao.getAllMonsters();
        
        // First check the general content of the list
        assertNotNull(allMonsters, "All monsters list should be not null.");
        assertEquals(1, allMonsters.size(), "All monsters should only have 1 monster.");
        
        // Then the specifics
        assertFalse(allMonsters.contains(firstMonster), "All monsters should NOT include Lion.");
        assertTrue(allMonsters.contains(secondMonster), "All monsters should include Tiger.");
        
        // Remove the second monster
        removedMonster = testDao.removeMonster(secondMonsterId);
        // Check that the correct object was removed
        assertEquals(removedMonster, secondMonster, "The removed monster should be Tiger.");
        
        // Retrieve all of the monsters again, and check the list
        allMonsters = testDao.getAllMonsters();
        
        // Check the content of the list - it should be empty
        assertTrue(allMonsters.isEmpty(), "The retrieved list of monsters should be empty.");
        
        // Try to 'get' both monsters by the old id - they should be null!
        Monster retrievedMonster = testDao.getMonster(firstMonsterId);
        assertNull(retrievedMonster, "Lion was removed, should be null.");
        
        retrievedMonster = testDao.getMonster(secondMonsterId);
        assertNull(retrievedMonster, "Tiger was removed, should be null.");
        
    }
    
    @Test
    public void testUpdateMonster() throws Exception{
        // Create out method test inputs
        int monsterId = 1;
        Monster firstMonster = new Monster("Lion", MonsterType.YETI, 3, "mashmello");
        
        Monster secondMonster = new Monster("Tiger", MonsterType.SWAMPTHING, 5, "beef");
        
        // Add the monster to the DAO
        testDao.addMonster(monsterId, firstMonster);
        
        // Replace the monster in the DAO from the Lion to the Tiger.
        testDao.updateMonster(monsterId, secondMonster);
        
        // Get the monster from the DAO
        Monster retrievedMonster = testDao.getMonster(monsterId);
        
        // Check data is equal
        assertEquals(retrievedMonster.getName(), secondMonster.getName(), "Checking monster name.");
        assertEquals(retrievedMonster.getType(), secondMonster.getType(), "Checking monster type.");
        assertEquals(retrievedMonster.getPeopleEaten(), secondMonster.getPeopleEaten(), "Checking monster people eaten.");
        assertEquals(retrievedMonster.getFavoriteFood(), secondMonster.getFavoriteFood(), "Checking monster favorite food.");
    }
}
