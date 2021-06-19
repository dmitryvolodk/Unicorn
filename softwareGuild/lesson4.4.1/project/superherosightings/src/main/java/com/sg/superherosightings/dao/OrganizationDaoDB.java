package com.sg.superherosightings.dao;

import com.sg.superherosightings.entities.Hero;
import com.sg.superherosightings.entities.Organization;
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
public class OrganizationDaoDB implements OrganizationDao{

    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public Organization getOrganizationById(int organizationId) {
        try {
            final String SELECT_ORGANIZATION_BY_ID = "SELECT * FROM organization WHERE organizationId = ?";
            return jdbc.queryForObject(SELECT_ORGANIZATION_BY_ID, new OrganizationMapper(), organizationId);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Organization> getAllOrganizations() {
       final String SELECT_ALL_ORGANIZATIONS = "SELECT * FROM organization";
        return jdbc.query(SELECT_ALL_ORGANIZATIONS, new OrganizationMapper());
    }

    @Override
    @Transactional
    public Organization addOrganization(Organization organization) {
        final String INSERT_ORGANIZATION = "INSERT INTO organization(organizationName, organizationDescription, organizationContactInfo) "
                + "VALUES(?,?,?)";
        jdbc.update(INSERT_ORGANIZATION,
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationContactInfo());
        
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        organization.setOrganizationId(newId);
        return organization;
    }

    @Override
    public void updateOrganization(Organization organization) {
        final String UPDATE_ORGANIZATION = "UPDATE organization SET organizationName = ?, organizationDescription = ?, organizationContactInfo = ? "
                + "WHERE organizationId = ?";
        jdbc.update(UPDATE_ORGANIZATION,
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationContactInfo(),
                organization.getOrganizationId());
    }

    @Override
    @Transactional
    public void deleteOrganizationById(int organizationId) {
        final String DELETE_HERO_ORGANIZATION = "DELETE FROM hero_organization WHERE organizationId = ?";
        jdbc.update(DELETE_HERO_ORGANIZATION, organizationId);
        
        final String DELETE_ORGANIZATION = "DELETE FROM organization WHERE organizationId = ?";
        jdbc.update(DELETE_ORGANIZATION, organizationId);
    }

    @Override
    public List<Organization> getOrganizationsForHero(Hero hero) {
        final String SELECT_ORGANIZATIONS_FOR_HERO = "SELECT o.* FROM organization o "
                + "JOIN hero_organization ho ON o.organizationId = ho.organizationId WHERE ho.heroId = ?";
        List<Organization> organizations = jdbc.query(SELECT_ORGANIZATIONS_FOR_HERO, 
                new OrganizationMapper(), hero.getHeroId());
        return organizations;
    }
    
    public static final class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int index) throws SQLException {
            Organization organization = new Organization();
            organization.setOrganizationId(rs.getInt("organizationId"));
            organization.setOrganizationName(rs.getString("organizationName"));
            organization.setOrganizationDescription(rs.getString("organizationDescription"));
            organization.setOrganizationContactInfo(rs.getString("organizationContactInfo"));

            return organization;
        }

    }
}
