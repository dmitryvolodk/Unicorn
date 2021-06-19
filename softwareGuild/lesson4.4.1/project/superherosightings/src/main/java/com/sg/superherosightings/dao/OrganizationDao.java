package com.sg.superherosightings.dao;

import com.sg.superherosightings.entities.Hero;
import com.sg.superherosightings.entities.Organization;
import java.util.List;

public interface OrganizationDao {
    Organization getOrganizationById(int organizationId);
    List<Organization> getAllOrganizations();
    Organization addOrganization(Organization organization);
    void updateOrganization(Organization organization);
    void deleteOrganizationById(int organizationId);
    
    // The system must be able to report all of the organizations a particular superhero/villain belongs to.
    List<Organization> getOrganizationsForHero(Hero hero);
}
