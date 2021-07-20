package com.sg.superherosightings.dao;

import com.sg.superherosightings.entities.Hero;
import com.sg.superherosightings.entities.Location;
import com.sg.superherosightings.entities.Organization;
import com.sg.superherosightings.entities.Sighting;
import com.sg.superherosightings.entities.Superpower;
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
public class OrganizationDaoDBTest {
        
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
    
    public OrganizationDaoDBTest() {
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
    public void testAddAndGetOrganization() {
        Organization organization = new Organization();
        organization.setOrganizationName("Test name");
        organization.setOrganizationDescription("Test description");
        organization.setOrganizationContactInfo("Test contact info");
        organization = organizationDao.addOrganization(organization);
        
        Organization fromDao = organizationDao.getOrganizationById(organization.getOrganizationId());
        
        assertEquals(organization, fromDao);
    }
    
    @Test
    public void getAllOrganizations(){
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
        
        List<Organization> organizations = organizationDao.getAllOrganizations();
        
        assertEquals(2, organizations.size());
        assertTrue(organizations.contains(organization));
        assertTrue(organizations.contains(organization2));
    }
    
    @Test
    public void testUpdateOrganization(){
        Organization organization = new Organization();
        organization.setOrganizationName("Test name");
        organization.setOrganizationDescription("Test description");
        organization.setOrganizationContactInfo("Test contact info");
        organization = organizationDao.addOrganization(organization);
        
        Organization fromDao = organizationDao.getOrganizationById(organization.getOrganizationId());
        assertEquals(organization, fromDao);
        
        organization.setOrganizationName("Test new name");
        organizationDao.updateOrganization(organization);
        assertNotEquals(organization, fromDao);
        
        fromDao = organizationDao.getOrganizationById(organization.getOrganizationId());
        assertEquals(organization, fromDao);
    }
    
    @Test
    public void testDeleteOrganizationById(){
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName("Test name");
        superpower = superpowerDao.addSuperpower(superpower);
        
        Organization organization = new Organization();
        organization.setOrganizationName("Test name");
        organization.setOrganizationDescription("Test description");
        organization.setOrganizationContactInfo("Test contact info");
        organization = organizationDao.addOrganization(organization);
        
        List<Organization> organizations = new ArrayList<>();
        organizations.add(organization);
        
        Hero hero = new Hero();
        hero.setHeroName("Test name");
        hero.setHeroDescription("Test description");
        hero.setSuperpower(superpower);
        hero.setOrganizations(organizations);
        
        Organization fromDao = organizationDao.getOrganizationById(organization.getOrganizationId());
        assertEquals(organization, fromDao);
        
        organizationDao.deleteOrganizationById(organization.getOrganizationId());
        
        fromDao = organizationDao.getOrganizationById(organization.getOrganizationId());
        assertNull(fromDao);
    }
    
    @Test
    public void testGetOrganizationsForHero(){
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
        
        List<Organization> organizationsFromDao = organizationDao.getOrganizationsForHero(hero2);
        
        assertEquals(2, organizationsFromDao.size());
        assertTrue(organizationsFromDao.contains(organization2));
        assertTrue(organizationsFromDao.contains(organization3));
    }
}
