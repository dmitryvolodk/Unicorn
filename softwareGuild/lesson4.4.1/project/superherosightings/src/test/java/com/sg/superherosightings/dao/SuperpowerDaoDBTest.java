package com.sg.superherosightings.dao;

import com.sg.superherosightings.entities.Hero;
import com.sg.superherosightings.entities.Location;
import com.sg.superherosightings.entities.Organization;
import com.sg.superherosightings.entities.Sighting;
import com.sg.superherosightings.entities.Superpower;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class SuperpowerDaoDBTest {
    
    @Autowired
    SuperpowerDao superpowerDao;
    
    @Autowired
    LocationDao locationDao;
    
    @Autowired
    OrganizationDao organizationDao;
    
    @Autowired
    HeroDao heroDao;
    
    @Autowired
    SightingDao sightingDao;
    
    public SuperpowerDaoDBTest() {
    }
    
    @BeforeEach
    public void setUp() {
        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        for(Superpower superpower : superpowers){
            superpowerDao.deleteSuperpowerById(superpower.getSuperpowerId());
        }
        
        List<Location> locations = locationDao.getAllLocations();
        for(Location location : locations){
            locationDao.deleteLocationById(location.getLocationId());
        }
        
        List<Organization> organizations = organizationDao.getAllOrganizations();
        for(Organization organization : organizations){
            organizationDao.deleteOrganizationById(organization.getOrganizationId());
        }
        
        List<Hero> heroes = heroDao.getAllHeroes();
        for(Hero hero : heroes){
            heroDao.deleteHero(hero.getHeroId());
        }
        
        List<Sighting> sightings = sightingDao.getAllSightings();
        for(Sighting sighting : sightings){
            sightingDao.deleteSightingById(sighting.getSightingId());
        }
    }

    @Test
    public void testAddAndGetSuperpower() {
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);
        
        Superpower fromDao = superpowerDao.getSuperpowerById(superpower.getSuperpowerId());
        
        assertEquals(superpower, fromDao);
    }
    
    @Test
    public void testGetAllSuperpowers(){
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);
        
        Superpower superpower2 = new Superpower();
        superpower2.setSuperpowerName("Test Name");
        superpower2 = superpowerDao.addSuperpower(superpower2);
        
        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        
        assertEquals(2, superpowers.size());
        assertTrue(superpowers.contains(superpower));
        assertTrue(superpowers.contains(superpower2));
    }
    
    @Test
    public void testUpdateSuperpower(){
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);
        
        Superpower fromDao = superpowerDao.getSuperpowerById(superpower.getSuperpowerId());
        assertEquals(superpower, fromDao);
        
        superpower.setSuperpowerName("New Test Name");
        superpowerDao.updateSuperpower(superpower);
        
        assertNotEquals(superpower, fromDao);
        
        fromDao = superpowerDao.getSuperpowerById(superpower.getSuperpowerId());
        
        assertEquals(superpower, fromDao);
    }
    
    @Test
    public void testDeleteSuperpowerById(){
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);
        
        Organization organization = new Organization();
        organization.setOrganizationName("Test Organization Name");
        organization.setOrganizationDescription("Test organization description");
        organization.setOrganizationContactInfo("Test organization contact info");
        organization = organizationDao.addOrganization(organization);
        List<Organization> organizations = new ArrayList<>();
        organizations.add(organization);
        
        Hero hero = new Hero();
        hero.setHeroName("Test Hero name");
        hero.setHeroDescription("Test hero description");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizations);
        hero = heroDao.addHero(hero);
        
        Location location = new Location();
        location.setLocationName("Test location name");
        location.setLocationDescription("Test location description");
        location.setLocationAddress("Test location address");
        location.setLatitude("Test location latidude");
        location.setLongitude("Test location longitude");
        location = locationDao.addLocation(location);
        
        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate localDateSighting = LocalDate.parse("01-01-1999", formatter);        
        sighting.setDate(localDateSighting);
        
        Superpower fromDao = superpowerDao.getSuperpowerById(superpower.getSuperpowerId());
        assertEquals(superpower, fromDao);
        
        superpowerDao.deleteSuperpowerById(superpower.getSuperpowerId());
        
        fromDao = superpowerDao.getSuperpowerById(superpower.getSuperpowerId());
        assertNull(fromDao);
    }
}
