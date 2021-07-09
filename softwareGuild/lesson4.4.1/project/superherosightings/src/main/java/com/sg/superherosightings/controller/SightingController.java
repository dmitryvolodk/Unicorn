package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.HeroDao;
import com.sg.superherosightings.dao.LocationDao;
import com.sg.superherosightings.dao.OrganizationDao;
import com.sg.superherosightings.dao.SightingDao;
import com.sg.superherosightings.dao.SuperpowerDao;
import com.sg.superherosightings.entities.Hero;
import com.sg.superherosightings.entities.Location;
import com.sg.superherosightings.entities.Sighting;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SightingController {
    
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
    
    @GetMapping("sightings")
    public String displayCourses(Model model) {
        List<Sighting> sightings = sightingDao.getAllSightings();
        List<Hero> heroes = heroDao.getAllHeroes();
        List<Location> locations = locationDao.getAllLocations();
        model.addAttribute("sightings", sightings);
        model.addAttribute("heroes", heroes);
        model.addAttribute("locations", locations);
        return "sightings";
    }
    
    @PostMapping("addSighting")
    public String addSighting(Sighting sighting, HttpServletRequest request) {
        String locationId = request.getParameter("locationId");
        String heroId = request.getParameter("heroId");
        
        sighting.setLocation(locationDao.getLocationById(Integer.parseInt(locationId)));
        
        sighting.setHero(heroDao.getHeroById(Integer.parseInt(heroId)));
        
        sightingDao.addSighting(sighting);
        
        return "redirect:/sightings";
    }
    
    @GetMapping("deleteSighting")
    public String deleteSighting(Integer sightingId) {
        sightingDao.deleteSightingById(sightingId);
        return "redirect:/sightings";
    }
    
    @GetMapping("editSighting")
    public String editSighting(Integer sightingId, Model model) {
        Sighting sighting = sightingDao.getSightingById(sightingId);
        List<Location> locations = locationDao.getAllLocations();
        List<Hero> heroes = heroDao.getAllHeroes();
        model.addAttribute("sighting", sighting);
        model.addAttribute("locations", locations);
        model.addAttribute("heroes", heroes);
        return "editSighting";
    }
    
    @PostMapping("editSighting")
    public String performEditSighting(Sighting sighting, HttpServletRequest request) {
        String locationId = request.getParameter("locationId");
        String heroId = request.getParameter("heroId");
        
        sighting.setLocation(locationDao.getLocationById(Integer.parseInt(locationId)));
        sighting.setHero(heroDao.getHeroById(Integer.parseInt(heroId)));
        
        sightingDao.updateSighting(sighting);
        
        return "redirect:/sightings";
    }
}
