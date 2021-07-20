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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HeroDaoDBTest {

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

    public HeroDaoDBTest() {
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
    public void testAddAndGetHero() {
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);

        Organization organization = new Organization();
        organization.setOrganizationName("Test name");
        organization.setOrganizationDescription("Test description");
        organization.setOrganizationContactInfo("Test contact info");
        organization = organizationDao.addOrganization(organization);
        List<Organization> organizations = new ArrayList<>();
        organizations.add(organization);

        Hero hero = new Hero();
        hero.setHeroName("Test Hero name");
        hero.setHeroDescription("Test hero description");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizations);
        hero = heroDao.addHero(hero);

        Hero fromDao = heroDao.getHeroById((hero.getHeroId()));
        assertEquals(hero, fromDao);
    }

    @Test
    public void testGetAllHeroes() {
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);

        Organization organization = new Organization();
        organization.setOrganizationName("Test name");
        organization.setOrganizationDescription("Test description");
        organization.setOrganizationContactInfo("Test contact info");
        organization = organizationDao.addOrganization(organization);

        List<Organization> organizations = new ArrayList<>();
        organizations.add(organization);

        Hero hero = new Hero();
        hero.setHeroName("Test hero name");
        hero.setHeroDescription("Test hero description");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizations);
        hero = heroDao.addHero(hero);

        Hero hero2 = new Hero();
        hero2.setHeroName("Test second hero name");
        hero2.setHeroDescription("Test second hero description");
        hero2.setSuperpower(superpower);
        hero2.setOrganizations(organizations);
        hero2 = heroDao.addHero(hero2);

        List<Hero> heroes = heroDao.getAllHeroes();
        assertEquals(2, heroes.size());
        assertTrue(heroes.contains(hero));
        assertTrue(heroes.contains(hero2));
    }

    @Test
    public void testUpdateHeroes() {
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);

        Organization organization = new Organization();
        organization.setOrganizationName("Test name");
        organization.setOrganizationDescription("Test description");
        organization.setOrganizationContactInfo("Test contact info");
        organization = organizationDao.addOrganization(organization);

        List<Organization> organizations = new ArrayList<>();
        organizations.add(organization);

        Hero hero = new Hero();
        hero.setHeroName("Test hero name");
        hero.setHeroDescription("Test hero description");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizations);
        hero = heroDao.addHero(hero);

        Hero fromDao = heroDao.getHeroById(hero.getHeroId());
        assertEquals(hero, fromDao);

        hero.setHeroName("New Test Hero Name");
        Organization organization2 = new Organization();
        organization2.setOrganizationName("Test second organization name");
        organization2.setOrganizationDescription("Test second organization descripition");
        organization2.setOrganizationContactInfo("Test second organization contact info");
        organization2 = organizationDao.addOrganization(organization2);
        organizations.add(organization2);
        hero.setOrganizations(organizations);

        heroDao.updateHero(hero);

        assertNotEquals(hero, fromDao);

        fromDao = heroDao.getHeroById(hero.getHeroId());
        assertEquals(hero, fromDao);
    }

    @Test
    public void testDeleteHeroById() {
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);

        Organization organization = new Organization();
        organization.setOrganizationName("Test name");
        organization.setOrganizationDescription("Test description");
        organization.setOrganizationContactInfo("Test contact info");
        organization = organizationDao.addOrganization(organization);

        List<Organization> organizations = new ArrayList<>();
        organizations.add(organization);

        Hero hero = new Hero();
        hero.setHeroName("Test hero name");
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
        sighting = sightingDao.addSighting(sighting);

        Hero fromDao = heroDao.getHeroById(hero.getHeroId());
        assertEquals(hero, fromDao);

        heroDao.deleteHero(hero.getHeroId());

        fromDao = heroDao.getHeroById(hero.getHeroId());
        assertNull(fromDao);
    }

    @Test
    public void testGetHeroesAtLocation() {
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

        // 3 heroes
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
        hero2.setOrganizations(organizations);
        hero2 = heroDao.addHero(hero2);

        Hero hero3 = new Hero();
        hero3.setHeroName("Test Second Hero name");
        hero3.setHeroDescription("Test Second hero description");
        hero3.setSuperpower(superpower);
        hero3.setOrganizations(organizations);
        hero3 = heroDao.addHero(hero3);

        // 2 locations
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

        // 3 sightings
        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate localDateSighting = LocalDate.parse("01-01-1999", formatter);
        sighting.setDate(localDateSighting);
        sighting = sightingDao.addSighting(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setHero(hero2);
        sighting2.setLocation(location2);
        LocalDate localDateSighting2 = LocalDate.parse("02-01-1999", formatter);
        sighting2.setDate(localDateSighting2);
        sighting2 = sightingDao.addSighting(sighting2);

        Sighting sighting3 = new Sighting();
        sighting3.setHero(hero3);
        sighting3.setLocation(location);
        LocalDate localDateSighting3 = LocalDate.parse("03-01-1999", formatter);
        sighting3.setDate(localDateSighting3);
        sighting3 = sightingDao.addSighting(sighting3);

        List<Hero> heroes = heroDao.getHeroesAtLocation(location);
        assertEquals(2, heroes.size());
        assertTrue(heroes.contains(hero));
        assertFalse(heroes.contains(hero2));
        assertTrue(heroes.contains(hero3));
    }

    @Test
    public void testGetHeroesForOrganization() {
        // 1 superpower
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);

        // 2 organizations
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

        List<Organization> organizations = new ArrayList<>();
        organizations.add(organization);
        organizations.add(organization2);

        List<Organization> organizations2 = new ArrayList<>();
        organizations2.add(organization2);

        // 3 heroes
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

        List<Hero> heroes = heroDao.getHeroesForOrganization(organization);
        assertEquals(2, heroes.size());
        assertTrue(heroes.contains(hero));
        assertFalse(heroes.contains(hero2));
        assertTrue(heroes.contains(hero3));
    }

    @Test
    public void testUpdatePhoto() {
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test Name");
        superpower = superpowerDao.addSuperpower(superpower);

        Organization organization = new Organization();
        organization.setOrganizationName("Test name");
        organization.setOrganizationDescription("Test description");
        organization.setOrganizationContactInfo("Test contact info");
        organization = organizationDao.addOrganization(organization);

        List<Organization> organizations = new ArrayList<>();
        organizations.add(organization);

        Hero hero = new Hero();
        hero.setHeroName("Test hero name");
        hero.setHeroDescription("Test hero description");
        hero.setSuperpower(superpower);
        // hero.setPhotoName("Test photo name");
        hero.setOrganizations(organizations);
        hero = heroDao.addHero(hero);

        Hero fromDao = heroDao.getHeroById(hero.getHeroId());
        assertEquals(hero, fromDao);

        hero.setPhotoName("New Test Photo Name");

        heroDao.updatePhotoName(hero);

        assertNotEquals(hero, fromDao);

        fromDao = heroDao.getHeroById(hero.getHeroId());
        assertEquals(hero, fromDao);
    }
}
