package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.HeroDao;
import com.sg.superherosightings.dao.LocationDao;
import com.sg.superherosightings.dao.OrganizationDao;
import com.sg.superherosightings.dao.SightingDao;
import com.sg.superherosightings.dao.SuperpowerDao;
import com.sg.superherosightings.entities.Organization;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrganizationController {
    
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
    
    @GetMapping("students")
    public String displayOrganizations(Model model) {
        List<Organization> organizations = organizationDao.getAllOrganizations();
        model.addAttribute("organizations", organizations);
        return "organizations";
    }
    
    @PostMapping("addOrganization")
    public String addOrganization(String organizationName, String organizationDescription, String organizationContactInfo) {
        Organization organization = new Organization();
        organization.setOrganizationName(organizationName);
        organization.setOrganizationDescription(organizationDescription);
        organization.setOrganizationContactInfo(organizationContactInfo);
        organizationDao.addOrganization(organization);
        
        return "redirect:/organizations";
    }
    
    @GetMapping("deleteOrganization")
    public String deleteOrganization(Integer organizationId) {
        organizationDao.deleteOrganizationById(organizationId);
        return "redirect:/organizations";
    }
    
    @GetMapping("editOrganization")
    public String editOrganization(Integer organizationId, Model model) {
        Organization organization = organizationDao.getOrganizationById(organizationId);
        model.addAttribute("organization", organization);
        return "editOrganization";
    }
    
    @PostMapping("editOrganization")
    public String performEditOrganization(Organization organization) {
        organizationDao.updateOrganization(organization);
        return "redirect:/organizations";
    }
}
