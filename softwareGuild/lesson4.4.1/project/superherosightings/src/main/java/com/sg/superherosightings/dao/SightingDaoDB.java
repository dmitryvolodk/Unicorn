package com.sg.superherosightings.dao;

import com.sg.superherosightings.dao.HeroDaoDB.HeroMapper;
import com.sg.superherosightings.dao.LocationDaoDB.LocationMapper;
import com.sg.superherosightings.entities.Hero;
import com.sg.superherosightings.entities.Location;
import com.sg.superherosightings.entities.Organization;
import com.sg.superherosightings.entities.Sighting;
import com.sg.superherosightings.entities.Superpower;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SightingDaoDB implements SightingDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Sighting getSightingById(int sightingId) {
        try {// create a script of DATA to be able to reset and test
            final String SELECT_SIGHTING_BY_ID = "SELECT * FROM sighting WHERE sightingId = ?";
            Sighting sighting = jdbc.queryForObject(SELECT_SIGHTING_BY_ID, new SightingMapper(), sightingId);
            sighting.setLocation(getLocationForSighting(sightingId));
            sighting.setHero(getHeroForSighting(sightingId));
            return sighting;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    private Location getLocationForSighting(int sightingId) {
        final String SELECT_LOCATION_FOR_SIGHTING = "SELECT l.* FROM location l "
                + "JOIN sighting s ON s.locationId = l.locationId WHERE s.sightingId = ?";
        return jdbc.queryForObject(SELECT_LOCATION_FOR_SIGHTING, new LocationMapper(), sightingId);
    }

    private Hero getHeroForSighting(int sightingId) {
        try {
            final String SELECT_HERO_FOR_SIGHTING = "SELECT h.* FROM hero h "
                    + "JOIN sighting s ON s.heroId = h.heroId WHERE s.sightingId = ?";
            Hero hero = jdbc.queryForObject(SELECT_HERO_FOR_SIGHTING, new HeroMapper(), sightingId);
            hero.setSuperpower(getSuperpowerForHero(hero.getHeroId()));
            hero.setOrganizations(getOrganizationsForHero(hero.getHeroId()));
            return hero;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    private Superpower getSuperpowerForHero(int heroId) {
        final String SELECT_SUPERPOWER_FOR_HERO = "SELECT s.* FROM superpower s "
                + "JOIN hero h ON h.superpowerId = s.superpowerId WHERE h.heroId = ?";
        return jdbc.queryForObject(SELECT_SUPERPOWER_FOR_HERO, new SuperpowerDaoDB.SuperpowerMapper(), heroId);
    }

    private List<Organization> getOrganizationsForHero(int heroId) {
        final String SELECT_ORGANIZATIONS_FOR_HERO = "SELECT o.* FROM organization o "
                + "JOIN hero_organization ho ON ho.organizationId = o.organizationId WHERE ho.heroId = ?";
        return jdbc.query(SELECT_ORGANIZATIONS_FOR_HERO, new OrganizationDaoDB.OrganizationMapper(), heroId);
    }

    @Override
    public List<Sighting> getAllSightings() {
        final String SELECT_ALL_SIGHTINGS = "SELECT * FROM sighting";
        List<Sighting> sightings = jdbc.query(SELECT_ALL_SIGHTINGS, new SightingMapper());
        associateLocationAndHero(sightings);
        return sightings;
    }

    private void associateLocationAndHero(List<Sighting> sightings) {
        for (Sighting sighting : sightings) {
            sighting.setLocation(getLocationForSighting(sighting.getSightingId()));
            sighting.setHero(getHeroForSighting(sighting.getSightingId()));
        }
    }

    @Override
    @Transactional
    public Sighting addSighting(Sighting sighting) {
        final String INSERT_SIGHTING = "INSERT INTO sighting(locationId, heroId, date) "
                + "VALUES(?,?,?)";
        jdbc.update(INSERT_SIGHTING,
                sighting.getLocation().getLocationId(),
                sighting.getHero().getHeroId(),
                Date.valueOf(sighting.getDate()));

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        sighting.setSightingId(newId);
        return sighting;
    }

    @Override
    public void updateSighting(Sighting sighting) {
        final String UPDATE_SIGHTING = "UPDATE sighting SET locationId = ?, heroId = ?, "
                + "Date = ? WHERE sightingId = ?";
        jdbc.update(UPDATE_SIGHTING,
                sighting.getLocation().getLocationId(),
                sighting.getHero().getHeroId(),
                Date.valueOf(sighting.getDate()),
                sighting.getSightingId());
    }

    @Override
    public void deleteSightingById(int sightingId) {
        final String DELETE_SIGHTING = "DELETE FROM sighting WHERE sightingId = ?";
        jdbc.update(DELETE_SIGHTING, sightingId);
    }

    @Override
    public List<Sighting> getSightingsForDate(LocalDate date) {
        final String SELECT_SIGHTINGS_FOR_DATE = "SELECT * FROM sighting WHERE date = ?";
        List<Sighting> sightings = jdbc.query(SELECT_SIGHTINGS_FOR_DATE,
                new SightingMapper(), Date.valueOf(date));
        associateLocationAndHero(sightings);
        return sightings;
    }

    @Override
    public List<Sighting> getTenMostRecentSightings() {
        final String SELECT_TEN_RECENT_SIGHTINGS = "SELECT * FROM sighting ORDER BY date DESC LIMIT 0, 10";
        List<Sighting> sightings = jdbc.query(SELECT_TEN_RECENT_SIGHTINGS,
                new SightingMapper());
        associateLocationAndHero(sightings);
        return sightings;
    }

    public static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int index) throws SQLException {
            Sighting sighting = new Sighting();
            sighting.setSightingId(rs.getInt("sightingId"));
            sighting.setDate(rs.getDate("date").toLocalDate());
            return sighting;
        }

    }

}
