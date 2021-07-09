package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.HeroDao;
import com.sg.superherosightings.dao.LocationDao;
import com.sg.superherosightings.dao.OrganizationDao;
import com.sg.superherosightings.dao.SightingDao;
import com.sg.superherosightings.dao.SuperpowerDao;
import com.sg.superherosightings.entities.Location;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LocationController {

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

    @GetMapping("locations")
    public String displayLocations(Model model) {
        List<Location> locations = locationDao.getAllLocations();
        model.addAttribute("locations", locations);
        return "locations";
    }
    
    @PostMapping("addLocation")
    public String addLocation(String locationName, String locationDescription, String locationAddress, String latitude, String longitude) {
        Location location = new Location();
        location.setLocationName(locationName);
        location.setLocationDescription(locationDescription);
        location.setLocationAddress(locationAddress);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        locationDao.addLocation(location);
        
        return "redirect:/locations";
    }
    
    @GetMapping("deleteLocation")
    public String deleteLocation(Integer locationId) {
        locationDao.deleteLocationById(locationId);
        return "redirect:/locations";
    }
    
    @GetMapping("editLocation")
    public String editLocation(Integer locationId, Model model) {
        Location location = locationDao.getLocationById(locationId);
        model.addAttribute("location", location);
        return "editLocation";
    }
    
    @PostMapping("editLocation")
    public String performEditLocation(Location location) {
        locationDao.updateLocation(location);
        return "redirect:/locations";
    }
}
