package com.sg.superherosightings.dao;

import com.sg.superherosightings.dao.OrganizationDaoDB.OrganizationMapper;
import com.sg.superherosightings.dao.SuperpowerDaoDB.SuperpowerMapper;
import com.sg.superherosightings.entities.Hero;
import com.sg.superherosightings.entities.Location;
import com.sg.superherosightings.entities.Organization;
import com.sg.superherosightings.entities.Superpower;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HeroDaoDB implements HeroDao{

    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public Hero getHeroById(int heroId) {
         try {
            final String SELECT_HERO_BY_ID = "SELECT * FROM hero WHERE heroId = ?";
            Hero hero = jdbc.queryForObject(SELECT_HERO_BY_ID, new HeroMapper(), heroId);
            hero.setSuperpower(getSuperpowerForHero(heroId));
            hero.setOrganizations(getOrganizationsForHero(heroId));
            return hero;
        } catch(DataAccessException ex) {
            return null;
        }
    }

    private Superpower getSuperpowerForHero(int heroId) {
        final String SELECT_SUPERPOWER_FOR_HERO = "SELECT s.* FROM superpower s "
                + "JOIN hero h ON h.superpowerId = s.superpowerId WHERE h.heroId = ?";
        return jdbc.queryForObject(SELECT_SUPERPOWER_FOR_HERO, new SuperpowerMapper(), heroId);
    }

    private List<Organization> getOrganizationsForHero(int heroId) {
        final String SELECT_ORGANIZATIONS_FOR_HERO = "SELECT o.* FROM organization o "
                + "JOIN hero_organization ho ON ho.organizationId = o.organizationId WHERE ho.heroId = ?";
        return jdbc.query(SELECT_ORGANIZATIONS_FOR_HERO, new OrganizationMapper(), heroId);
    }

    @Override
    public List<Hero> getAllHeroes() {
        final String SELECT_ALL_HEROES = "SELECT * FROM hero";
        List<Hero> heroes = jdbc.query(SELECT_ALL_HEROES, new HeroMapper());
        associateSuperpowerAndOrganizations(heroes);
        return heroes;
    }
    
    private void associateSuperpowerAndOrganizations(List<Hero> heroes) {
        for (Hero hero : heroes) {
            hero.setSuperpower(getSuperpowerForHero(hero.getHeroId()));
            hero.setOrganizations(getOrganizationsForHero(hero.getHeroId()));
        }
    }

    @Override
    @Transactional
    public Hero addHero(Hero hero) {
        final String INSERT_HERO = "INSERT INTO hero(heroName, heroDescription, superpowerId) "
                + "VALUES(?,?,?)";
        jdbc.update(INSERT_HERO,
                hero.getHeroName(),
                hero.getHeroDescription(),
                hero.getSuperpower().getSuperpowerId());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        hero.setHeroId(newId);
        insertHeroOrganization(hero);
        return hero;
    }
    
    private void insertHeroOrganization(Hero hero) {
        final String INSERT_HERO_ORGANIZATION = "INSERT INTO "
                + "hero_organization(heroId, organizationId) VALUES(?,?)";
        for(Organization organization : hero.getOrganizations()) {
            jdbc.update(INSERT_HERO_ORGANIZATION, 
                    hero.getHeroId(),
                    organization.getOrganizationId());
        }
    }

    @Override
    @Transactional
    public void updateHero(Hero hero) {
        final String UPDATE_HERO = "UPDATE hero SET heroName = ?, heroDescription = ?, "
                + "superpowerId = ? WHERE heroId = ?";
        jdbc.update(UPDATE_HERO, 
                hero.getHeroName(), 
                hero.getHeroDescription(), 
                hero.getSuperpower().getSuperpowerId(),
                hero.getHeroId());
        
        final String DELETE_HERO_ORGANIZATION = "DELETE FROM hero_organization WHERE heroId = ?";
        jdbc.update(DELETE_HERO_ORGANIZATION, hero.getHeroId());
        insertHeroOrganization(hero);
    }

    @Override
    @Transactional
    public void deleteHero(int heroId) {
        final String DELETE_HERO_ORGANIZATION = "DELETE FROM hero_organization WHERE heroId = ?";
        jdbc.update(DELETE_HERO_ORGANIZATION, heroId);
        
        final String DELETE_SIGHTING = "DELETE FROM sighting WHERE heroId = ?";
        jdbc.update(DELETE_SIGHTING, heroId);
        
        final String DELETE_HERO = "DELETE FROM hero WHERE heroId = ?";
        jdbc.update(DELETE_HERO, heroId);
    }

    @Override
    public List<Hero> getHeroesAtLocation(Location location) {
        final String SELECT_HEROES_AT_LOCATION = "SELECT h.* FROM hero h JOIN "
                + "sighting s ON s.heroId = h.heroId WHERE s.locationId = ?";
        List<Hero> heroes = jdbc.query(SELECT_HEROES_AT_LOCATION, 
                new HeroMapper(), location.getLocationId());
        associateSuperpowerAndOrganizations(heroes);
        return heroes;
    }

    @Override
    public List<Hero> getHeroesForOrganization(Organization organization) {
        final String SELECT_HEROES_FOR_ORGANIZATION = "SELECT h.* FROM hero h JOIN "
                + "hero_organization ho ON ho.heroId = h.heroId WHERE ho.organizationId = ?";
        List<Hero> heroes = jdbc.query(SELECT_HEROES_FOR_ORGANIZATION, 
                new HeroMapper(), organization.getOrganizationId());
        associateSuperpowerAndOrganizations(heroes);
        return heroes;
    }
    
    public static final class HeroMapper implements RowMapper<Hero> {

        @Override
        public Hero mapRow(ResultSet rs, int index) throws SQLException {
            Hero hero = new Hero();
            hero.setHeroId(rs.getInt("heroId"));
            hero.setHeroName(rs.getString("heroName"));
            hero.setHeroDescription(rs.getString("heroDescription"));
            return hero;
        }
        
    }
}
