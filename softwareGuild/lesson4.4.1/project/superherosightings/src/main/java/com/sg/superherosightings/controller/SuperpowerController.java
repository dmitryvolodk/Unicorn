package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.HeroDao;
import com.sg.superherosightings.dao.LocationDao;
import com.sg.superherosightings.dao.OrganizationDao;
import com.sg.superherosightings.dao.SightingDao;
import com.sg.superherosightings.dao.SuperpowerDao;
import com.sg.superherosightings.entities.Superpower;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SuperpowerController {
    
    Set<ConstraintViolation<Superpower>> violations = new HashSet<>();
    
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
    
    @GetMapping("superpowers")
    public String displaySuperpowers(Model model) {
        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        model.addAttribute("superpowers", superpowers);
        model.addAttribute("errors", violations);
        return "superpowers";
    }
    
    @PostMapping("addSuperpower")
    public String addSuperpower(HttpServletRequest request) {
        String superpowerName = request.getParameter("superpowerName");
        
        Superpower superpower = new Superpower();
        superpower.setSuperpowerName(superpowerName);
        
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(superpower);
        if(violations.isEmpty()){
            superpowerDao.addSuperpower(superpower);
        }
        
        return "redirect:/superpowers";
    }
    
    @GetMapping("deleteSuperpower")
    public String deleteSuperpower(HttpServletRequest request) {
        int superpowerId = Integer.parseInt(request.getParameter("superpowerId"));
        superpowerDao.deleteSuperpowerById(superpowerId);
        
        return "redirect:/superpowers";
    }
    
    @GetMapping("editSuperpower")
    public String editSuperpower(HttpServletRequest request, Model model) {
        int superpowerId = Integer.parseInt(request.getParameter("superpowerId"));
        Superpower superpower = superpowerDao.getSuperpowerById(superpowerId);
        
        model.addAttribute("superpower", superpower);
        return "editSuperpower";
    }
    
    @PostMapping("editSuperpower")
    public String performEditSuperpower(HttpServletRequest request) {
        int superpowerId = Integer.parseInt(request.getParameter("superpowerId"));
        Superpower superpower = superpowerDao.getSuperpowerById(superpowerId);
        
        superpower.setSuperpowerName(request.getParameter("superpowerName"));
        
        superpowerDao.updateSuperpower(superpower);
        
        return "redirect:/superpowers";
    }
}
