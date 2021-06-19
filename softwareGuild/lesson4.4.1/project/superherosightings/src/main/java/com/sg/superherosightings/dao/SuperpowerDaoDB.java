package com.sg.superherosightings.dao;

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
public class SuperpowerDaoDB implements SuperpowerDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Superpower getSuperpowerById(int superpowerId) {
        try {
            final String GET_SUPERPOWER_BY_ID = "SELECT * FROM superpower WHERE superpowerId = ?";
            return jdbc.queryForObject(GET_SUPERPOWER_BY_ID, new SuperpowerMapper(), superpowerId);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Superpower> getAllSuperpowers() {
        final String GET_ALL_SUPERPOWERS = "SELECT * FROM superpower";
        return jdbc.query(GET_ALL_SUPERPOWERS, new SuperpowerMapper());
    }

    @Override
    @Transactional
    public Superpower addSuperpower(Superpower superpower) {
        final String INSERT_SUPERPOWER = "INSERT INTO superpower(superpowerName) " +
                "VALUES(?)";
        jdbc.update(INSERT_SUPERPOWER,
                superpower.getSuperpowerName());
        
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        superpower.setSuperpowerId(newId);
        return superpower;
    }

    @Override
    public void updateSuperpower(Superpower superpower) {
        final String UPDATE_SUPERPOWER = "UPDATE superpower SET superpowerName = ? WHERE id = ?";
        jdbc.update(UPDATE_SUPERPOWER,
                superpower.getSuperpowerName());
    }

    @Override
    @Transactional
    public void deleteSuperpowerById(int superpowerId) {
        final String DELETE_HERO_ORGANIZATION = "DELETE ho.* FROM hero_organization ho "
                + "JOIN hero h ON ho.heroId = h.heroId WHERE h.superpowerId = ?";
        jdbc.update(DELETE_HERO_ORGANIZATION, superpowerId);
        
        final String DELETE_SIGHTING = "DELETE s.* FROM sighting s "
                + "JOIN hero h ON s.heroId = h.heroId WHERE h.superpowerId = ?";
        jdbc.update(DELETE_SIGHTING, superpowerId);
        
        final String DELETE_HERO = "DELETE FROM hero WHERE superpowerId = ?";
        jdbc.update(DELETE_HERO, superpowerId);
        
        final String DELETE_SUPERPOWER = "DELETE FROM superpower WHERE superpowerId = ?";
        jdbc.update(DELETE_SUPERPOWER, superpowerId);
    }

    public static final class SuperpowerMapper implements RowMapper<Superpower> {

        @Override
        public Superpower mapRow(ResultSet rs, int index) throws SQLException {
            Superpower superpower = new Superpower();
            superpower.setSuperpowerId(rs.getInt("superpowerId"));
            superpower.setSuperpowerName(rs.getString("superpowerName"));
            
            return superpower;
        }
    }
}
