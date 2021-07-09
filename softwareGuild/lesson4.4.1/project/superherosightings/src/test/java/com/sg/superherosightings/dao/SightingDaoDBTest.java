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
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class SightingDaoDBTest {

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

    public SightingDaoDBTest() {
    }

    @BeforeEach
    public void setUp() {
        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        for (Superpower superpower : superpowers) {
            superpowerDao.deleteSuperpowerById(superpower.getSuperpowerId());
        }

        List<Location> locations = locationDao.getAllLocations();
        for (Location location : locations) {
            locationDao.deleteLocationById(location.getLocationId());
        }

        List<Organization> organizations = organizationDao.getAllOrganizations();
        for (Organization organization : organizations) {
            organizationDao.deleteOrganizationById(organization.getOrganizationId());
        }

        List<Hero> heroes = heroDao.getAllHeroes();
        for (Hero hero : heroes) {
            heroDao.deleteHero(hero.getHeroId());
        }

        List<Sighting> sightings = sightingDao.getAllSightings();
        for (Sighting sighting : sightings) {
            sightingDao.deleteSightingById(sighting.getSightingId());
        }
    }

    @Test
    public void testAddAndGetSighting() {
        // 1 superpower
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);

        // 1 organization
        Organization organization = new Organization();
        organization.setOrganizationName("Test name");
        organization.setOrganizationDescription("Test description");
        organization.setOrganizationContactInfo("Test contact info");
        organization = organizationDao.addOrganization(organization);

        List<Organization> organizations = new ArrayList<>();
        organizations.add(organization);

        // 1 hero
        Hero hero = new Hero();
        hero.setHeroName("Test Hero name");
        hero.setHeroDescription("Test hero description");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizations);
        hero = heroDao.addHero(hero);

        // 1 location
        Location location = new Location();
        location.setLocationName("Test location name");
        location.setLocationDescription("Test location description");
        location.setLocationAddress("Test location address");
        location.setLatitude("Test location latidude");
        location.setLongitude("Test location longitude");
        location = locationDao.addLocation(location);

        // 1 sighting
        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDateSighting = LocalDate.parse("1999-01-01", formatter);
        sighting.setDate(localDateSighting);
        sighting = sightingDao.addSighting(sighting);

        Sighting fromDao = sightingDao.getSightingById(sighting.getSightingId());
        assertEquals(sighting, fromDao);
        // assertEquals(sighting.getDate(), fromDao.getDate());

    }

    @Test
    public void tesGetAllSightings() {
        // 1 superpower
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);

        // 1 organization
        Organization organization = new Organization();
        organization.setOrganizationName("Test name");
        organization.setOrganizationDescription("Test description");
        organization.setOrganizationContactInfo("Test contact info");
        organization = organizationDao.addOrganization(organization);

        List<Organization> organizations = new ArrayList<>();
        organizations.add(organization);

        // 1 hero
        Hero hero = new Hero();
        hero.setHeroName("Test Hero name");
        hero.setHeroDescription("Test hero description");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizations);
        hero = heroDao.addHero(hero);

        // 1 location
        Location location = new Location();
        location.setLocationName("Test location name");
        location.setLocationDescription("Test location description");
        location.setLocationAddress("Test location address");
        location.setLatitude("Test location latidude");
        location.setLongitude("Test location longitude");
        location = locationDao.addLocation(location);

        // 2 sightings
        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDateSighting = LocalDate.parse("1999-01-01", formatter);
        sighting.setDate(localDateSighting);
        sighting = sightingDao.addSighting(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setHero(hero);
        sighting2.setLocation(location);
        LocalDate localDateSighting2 = LocalDate.parse("1999-02-01", formatter);
        sighting2.setDate(localDateSighting2);
        sighting2 = sightingDao.addSighting(sighting2);

        List<Sighting> sightings = sightingDao.getAllSightings();
        assertEquals(2, sightings.size());
        assertTrue(sightings.contains(sighting));
        assertTrue(sightings.contains(sighting2));
    }

    @Test
    public void testUpdateSighting() {
        // 1 superpower
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);

        // 1 organization
        Organization organization = new Organization();
        organization.setOrganizationName("Test name");
        organization.setOrganizationDescription("Test description");
        organization.setOrganizationContactInfo("Test contact info");
        organization = organizationDao.addOrganization(organization);

        List<Organization> organizations = new ArrayList<>();
        organizations.add(organization);

        // 1 hero
        Hero hero = new Hero();
        hero.setHeroName("Test Hero name");
        hero.setHeroDescription("Test hero description");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizations);
        hero = heroDao.addHero(hero);

        // 1 location
        Location location = new Location();
        location.setLocationName("Test location name");
        location.setLocationDescription("Test location description");
        location.setLocationAddress("Test location address");
        location.setLatitude("Test location latidude");
        location.setLongitude("Test location longitude");
        location = locationDao.addLocation(location);

        // 1 sighting
        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDateSighting = LocalDate.parse("1999-01-01", formatter);
        sighting.setDate(localDateSighting);
        sighting = sightingDao.addSighting(sighting);

        Sighting fromDao = sightingDao.getSightingById(sighting.getSightingId());
        assertEquals(sighting, fromDao);

        LocalDate localDateSighting2 = LocalDate.parse("2000-02-02", formatter);
        sighting.setDate(localDateSighting2);
        sighting = sightingDao.addSighting(sighting);

        sightingDao.updateSighting(sighting);

        assertNotEquals(sighting, fromDao);

        fromDao = sightingDao.getSightingById(sighting.getSightingId());
        assertEquals(sighting, fromDao);
    }

    @Test
    public void testDeleteSightingById() {
        // 1 superpower
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);

        // 1 organization
        Organization organization = new Organization();
        organization.setOrganizationName("Test name");
        organization.setOrganizationDescription("Test description");
        organization.setOrganizationContactInfo("Test contact info");
        organization = organizationDao.addOrganization(organization);

        List<Organization> organizations = new ArrayList<>();
        organizations.add(organization);

        // 1 hero
        Hero hero = new Hero();
        hero.setHeroName("Test Hero name");
        hero.setHeroDescription("Test hero description");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizations);
        hero = heroDao.addHero(hero);

        // 1 location
        Location location = new Location();
        location.setLocationName("Test location name");
        location.setLocationDescription("Test location description");
        location.setLocationAddress("Test location address");
        location.setLatitude("Test location latidude");
        location.setLongitude("Test location longitude");
        location = locationDao.addLocation(location);

        // 1 sighting
        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDateSighting = LocalDate.parse("1999-01-01", formatter);
        sighting.setDate(localDateSighting);
        sighting = sightingDao.addSighting(sighting);

        Sighting fromDao = sightingDao.getSightingById(sighting.getSightingId());
        assertEquals(sighting, fromDao);
        
        sightingDao.deleteSightingById(sighting.getSightingId());
        
        fromDao = sightingDao.getSightingById(sighting.getSightingId());
        assertNull(fromDao);
    }
        
    @Test
    public void testGetSightingsForDate(){
        // 1 superpower
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);

        // 1 organization
        Organization organization = new Organization();
        organization.setOrganizationName("Test name");
        organization.setOrganizationDescription("Test description");
        organization.setOrganizationContactInfo("Test contact info");
        organization = organizationDao.addOrganization(organization);

        List<Organization> organizations = new ArrayList<>();
        organizations.add(organization);

        // 1 hero
        Hero hero = new Hero();
        hero.setHeroName("Test Hero name");
        hero.setHeroDescription("Test hero description");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizations);
        hero = heroDao.addHero(hero);

        // 3 locations
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
        
        // 3 sightings
        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDateSighting = LocalDate.parse("1999-01-01", formatter);        
        sighting.setDate(localDateSighting);
        sighting = sightingDao.addSighting(sighting);
        
        Sighting sighting2 = new Sighting();
        sighting2.setHero(hero);
        sighting2.setLocation(location2);
        LocalDate localDateSighting2 = LocalDate.parse("1999-02-01", formatter);        
        sighting2.setDate(localDateSighting2);
        sighting2 = sightingDao.addSighting(sighting2);
        
        Sighting sighting3 = new Sighting();
        sighting3.setHero(hero);
        sighting3.setLocation(location3);
        LocalDate localDateSighting3 = LocalDate.parse("1999-01-01", formatter);        
        sighting3.setDate(localDateSighting3);
        sighting3 = sightingDao.addSighting(sighting3);
        
        LocalDate date = LocalDate.parse("1999-01-01", formatter);
        List<Sighting> sightings = sightingDao.getSightingsForDate(date);
        
        assertEquals(2, sightings.size());
        assertTrue(sightings.contains(sighting));
        assertFalse(sightings.contains(sighting2));
        assertTrue(sightings.contains(sighting3));
    }
    
    @Test
    public void testGetTenMostRecentSightings(){
        // 1 superpower
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);

        // 1 organization
        Organization organization = new Organization();
        organization.setOrganizationName("Test name");
        organization.setOrganizationDescription("Test description");
        organization.setOrganizationContactInfo("Test contact info");
        organization = organizationDao.addOrganization(organization);

        List<Organization> organizations = new ArrayList<>();
        organizations.add(organization);

        // 1 hero
        Hero hero = new Hero();
        hero.setHeroName("Test Hero name");
        hero.setHeroDescription("Test hero description");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizations);
        hero = heroDao.addHero(hero);

        // 1 location
        Location location = new Location();
        location.setLocationName("Test location name");
        location.setLocationDescription("Test location description");
        location.setLocationAddress("Test location address");
        location.setLatitude("Test location latidude");
        location.setLongitude("Test location longitude");
        location = locationDao.addLocation(location);
        
        // 15 sightings
        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDateSighting = LocalDate.parse("1999-01-01", formatter);        
        sighting.setDate(localDateSighting);
        sighting = sightingDao.addSighting(sighting);
        
        Sighting sighting2 = new Sighting();
        sighting2.setHero(hero);
        sighting2.setLocation(location);
        LocalDate localDateSighting2 = LocalDate.parse("1999-01-02", formatter);        
        sighting2.setDate(localDateSighting2);
        sighting2 = sightingDao.addSighting(sighting2);
        
        Sighting sighting3 = new Sighting();
        sighting3.setHero(hero);
        sighting3.setLocation(location);
        LocalDate localDateSighting3 = LocalDate.parse("1999-01-03", formatter);        
        sighting3.setDate(localDateSighting3);
        sighting3 = sightingDao.addSighting(sighting3);
        
        Sighting sighting4 = new Sighting();
        sighting4.setHero(hero);
        sighting4.setLocation(location);
        LocalDate localDateSighting4 = LocalDate.parse("1999-01-04", formatter);        
        sighting4.setDate(localDateSighting4);
        sighting4 = sightingDao.addSighting(sighting4);
        
        Sighting sighting5 = new Sighting();
        sighting5.setHero(hero);
        sighting5.setLocation(location);
        LocalDate localDateSighting5 = LocalDate.parse("1999-01-05", formatter);        
        sighting5.setDate(localDateSighting5);
        sighting5 = sightingDao.addSighting(sighting5);
        
        Sighting sighting6 = new Sighting();
        sighting6.setHero(hero);
        sighting6.setLocation(location);
        LocalDate localDateSighting6 = LocalDate.parse("1999-01-06", formatter);        
        sighting6.setDate(localDateSighting6);
        sighting6 = sightingDao.addSighting(sighting6);
        
        Sighting sighting7 = new Sighting();
        sighting7.setHero(hero);
        sighting7.setLocation(location);
        LocalDate localDateSighting7 = LocalDate.parse("1999-01-07", formatter);        
        sighting7.setDate(localDateSighting7);
        sighting7 = sightingDao.addSighting(sighting7);
        
        Sighting sighting8 = new Sighting();
        sighting8.setHero(hero);
        sighting8.setLocation(location);
        LocalDate localDateSighting8 = LocalDate.parse("1999-01-08", formatter);        
        sighting8.setDate(localDateSighting8);
        sighting8 = sightingDao.addSighting(sighting8);
        
        Sighting sighting9 = new Sighting();
        sighting9.setHero(hero);
        sighting9.setLocation(location);
        LocalDate localDateSighting9 = LocalDate.parse("1999-01-09", formatter);        
        sighting9.setDate(localDateSighting9);
        sighting9 = sightingDao.addSighting(sighting9);
        
        Sighting sighting10 = new Sighting();
        sighting10.setHero(hero);
        sighting10.setLocation(location);
        LocalDate localDateSighting10 = LocalDate.parse("1999-01-10", formatter);        
        sighting10.setDate(localDateSighting10);
        sighting10 = sightingDao.addSighting(sighting10);
        
        Sighting sighting11 = new Sighting();
        sighting11.setHero(hero);
        sighting11.setLocation(location);
        LocalDate localDateSighting11 = LocalDate.parse("1999-01-11", formatter);        
        sighting11.setDate(localDateSighting11);
        sighting11 = sightingDao.addSighting(sighting11);
        
        Sighting sighting12 = new Sighting();
        sighting12.setHero(hero);
        sighting12.setLocation(location);
        LocalDate localDateSighting12 = LocalDate.parse("1999-01-12", formatter);        
        sighting12.setDate(localDateSighting12);
        sighting12 = sightingDao.addSighting(sighting12);
        
        Sighting sighting13 = new Sighting();
        sighting13.setHero(hero);
        sighting13.setLocation(location);
        LocalDate localDateSighting13 = LocalDate.parse("1999-01-13", formatter);        
        sighting13.setDate(localDateSighting13);
        sighting13 = sightingDao.addSighting(sighting13);
        
        Sighting sighting14 = new Sighting();
        sighting14.setHero(hero);
        sighting14.setLocation(location);
        LocalDate localDateSighting14 = LocalDate.parse("1999-01-14", formatter);        
        sighting14.setDate(localDateSighting14);
        sighting14 = sightingDao.addSighting(sighting14);
        
        Sighting sighting15 = new Sighting();
        sighting15.setHero(hero);
        sighting15.setLocation(location);
        LocalDate localDateSighting15 = LocalDate.parse("1999-01-15", formatter);        
        sighting15.setDate(localDateSighting15);
        sighting15 = sightingDao.addSighting(sighting15);
        
        List<Sighting> sightings = sightingDao.getTenMostRecentSightings();
        
        assertEquals(10, sightings.size());
        assertFalse(sightings.contains(sighting));
        assertFalse(sightings.contains(sighting2));
        assertFalse(sightings.contains(sighting3));
        assertFalse(sightings.contains(sighting4));
        assertFalse(sightings.contains(sighting5));
        assertTrue(sightings.contains(sighting6));
        assertTrue(sightings.contains(sighting7));
        assertTrue(sightings.contains(sighting8));
        assertTrue(sightings.contains(sighting9));
        assertTrue(sightings.contains(sighting10));
        assertTrue(sightings.contains(sighting11));
        assertTrue(sightings.contains(sighting12));
        assertTrue(sightings.contains(sighting13));
        assertTrue(sightings.contains(sighting14));
        assertTrue(sightings.contains(sighting15));
    }
}
