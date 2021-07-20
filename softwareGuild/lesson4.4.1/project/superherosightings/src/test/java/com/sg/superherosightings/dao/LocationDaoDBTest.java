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

@SpringBootTest
public class LocationDaoDBTest {
        
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
    
    public LocationDaoDBTest() {
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
    public void testAddAndGetLocation() {
        Location location = new Location();
        location.setLocationName("Test name");
        location.setLocationDescription("Test description");
        location.setLocationAddress("Test address");
        location.setLongitude("Test longitude");
        location.setLatitude("Test latitude");
        location = locationDao.addLocation(location);
        
        Location fromDao = locationDao.getLocationById(location.getLocationId());
        
        assertEquals(location, fromDao);
    }
    
    @Test
    public void testGetAllLocations(){
        Location location = new Location();
        location.setLocationName("Test name");
        location.setLocationDescription("Test description");
        location.setLocationAddress("Test address");
        location.setLongitude("Test longitude");
        location.setLatitude("Test latitude");
        location = locationDao.addLocation(location);
        
        Location location2 = new Location();
        location2.setLocationName("Test second name");
        location2.setLocationDescription("Test second description");
        location2.setLocationAddress("Test second address");
        location2.setLongitude("Test second longitude");
        location2.setLatitude("Test second latitude");
        location2 = locationDao.addLocation(location2);
        
        List<Location> locations = locationDao.getAllLocations();
        
        assertEquals(2, locations.size());
        assertTrue(locations.contains(location));
        assertTrue(locations.contains(location2));
    }
    
    @Test
    public void testUpdateLocation(){
        Location location = new Location();
        location.setLocationName("Test name");
        location.setLocationDescription("Test description");
        location.setLocationAddress("Test address");
        location.setLongitude("Test longitude");
        location.setLatitude("Test latitude");
        location = locationDao.addLocation(location);
        
        Location fromDao = locationDao.getLocationById(location.getLocationId());
        assertEquals(location, fromDao);
        
        location.setLocationName("Tiger's name");
        locationDao.updateLocation(location);
        
        assertNotEquals(location, fromDao);
        
        fromDao = locationDao.getLocationById(location.getLocationId());
        
        assertEquals(location, fromDao);
    }
    
    @Test
    public void testDeleteLocationById(){
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
        location.setLocationName("Test name");
        location.setLocationDescription("Test description");
        location.setLocationAddress("Test address");
        location.setLongitude("Test longitude");
        location.setLatitude("Test latitude");
        location = locationDao.addLocation(location);
        
        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate localDateSighting = LocalDate.parse("11-01-1999", formatter);
        sighting.setDate(localDateSighting);
        sighting = sightingDao.addSighting(sighting);
        
        Location fromDao = locationDao.getLocationById(location.getLocationId());
        assertEquals(location, fromDao);
        
        locationDao.deleteLocationById(location.getLocationId());
        
        fromDao = locationDao.getLocationById(location.getLocationId());
        assertNull(fromDao);
    }
    
    @Test
    public void testGetLocationsForHero(){
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);
        
        Organization organization = new Organization();
        organization.setOrganizationName("Test name");
        organization.setOrganizationDescription("Test description");
        organization.setOrganizationContactInfo("Test contact info");
        organization = organizationDao.addOrganization(organization);
        
        Organization organization2 = new Organization();
        organization2.setOrganizationName("Test second name");
        organization2.setOrganizationDescription("Test second description");
        organization2.setOrganizationContactInfo("Test second contact info");
        organization2 = organizationDao.addOrganization(organization2);
        
        Organization organization3 = new Organization();
        organization3.setOrganizationName("Test third name");
        organization3.setOrganizationDescription("Test third description");
        organization3.setOrganizationContactInfo("Test third contact info");
        organization3 = organizationDao.addOrganization(organization3);
        
        List<Organization> organizations = new ArrayList<>();
        List<Organization> organizations2 = new ArrayList<>();
        organizations.add(organization);
        organizations2.add(organization2);
        organizations2.add(organization3);
        
        Hero hero = new Hero();
        hero.setHeroName("Test Hero name");
        hero.setHeroDescription("Test hero description");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizations);
        hero = heroDao.addHero(hero);
        
        Hero hero2 = new Hero();
        hero2.setHeroName("Test Second Hero name");
        hero2.setHeroDescription("Test Second hero description");
        hero2.setSuperpower(superpower);
        hero2.setOrganizations(organizations2);
        hero2 = heroDao.addHero(hero2);
        
        Hero hero3 = new Hero();
        hero3.setHeroName("Test Second Hero name");
        hero3.setHeroDescription("Test Second hero description");
        hero3.setSuperpower(superpower);
        hero3.setOrganizations(organizations);
        hero3 = heroDao.addHero(hero3);
        
        Location location = new Location();
        location.setLocationName("Test location name");
        location.setLocationDescription("Test location description");
        location.setLocationAddress("Test location address");
        location.setLatitude("Test location latidude");
        location.setLongitude("Test location longitude");
        location = locationDao.addLocation(location);
        
        Location location2 = new Location();
        location2.setLocationName("Test second location name");
        location2.setLocationDescription("Test second location description");
        location2.setLocationAddress("Test second location address");
        location2.setLatitude("Test second location latidude");
        location2.setLongitude("Test second location longitude");
        location2 = locationDao.addLocation(location2);
        
        Location location3 = new Location();
        location3.setLocationName("Test third location name");
        location3.setLocationDescription("Test third location description");
        location3.setLocationAddress("Test third location address");
        location3.setLatitude("Test third location latidude");
        location3.setLongitude("Test third location longitude");
        location3 = locationDao.addLocation(location3);
        
        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate localDateSighting = LocalDate.parse("01-01-1999", formatter);        
        sighting.setDate(localDateSighting);
        sighting = sightingDao.addSighting(sighting);
        
        Sighting sighting2 = new Sighting();
        sighting2.setHero(hero);
        sighting2.setLocation(location2);
        LocalDate localDateSighting2 = LocalDate.parse("02-01-1999", formatter);        
        sighting2.setDate(localDateSighting2);
        sighting2 = sightingDao.addSighting(sighting2);
        
        Sighting sighting3 = new Sighting();
        sighting3.setHero(hero3);
        sighting3.setLocation(location3);
        LocalDate localDateSighting3 = LocalDate.parse("03-01-1999", formatter);        
        sighting3.setDate(localDateSighting3);
        sighting3 = sightingDao.addSighting(sighting3);
        
        List<Location> locationsFromDao = locationDao.getLocationsForHero(hero);
        
        assertEquals(2, locationsFromDao.size());
        assertTrue(locationsFromDao.contains(location));
        assertTrue(locationsFromDao.contains(location2));
    }
}
