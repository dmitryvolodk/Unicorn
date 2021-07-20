package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.HeroDao;
import com.sg.superherosightings.dao.LocationDao;
import com.sg.superherosightings.dao.OrganizationDao;
import com.sg.superherosightings.dao.SightingDao;
import com.sg.superherosightings.dao.SuperpowerDao;
import com.sg.superherosightings.entities.Hero;
import com.sg.superherosightings.entities.Location;
import com.sg.superherosightings.entities.Sighting;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class SightingController {

    Set<ConstraintViolation<Sighting>> violations = new HashSet<>();

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

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @GetMapping("sightings")
    public String displaySightings(Model model) {
        List<Sighting> sightings = sightingDao.getAllSightings();
        List<Hero> heroes = heroDao.getAllHeroes();
        List<Location> locations = locationDao.getAllLocations();
        model.addAttribute("sightings", sightings);
        model.addAttribute("heroes", heroes);
        model.addAttribute("locations", locations);
        model.addAttribute("errors", violations);
        return "sightings";
    }

    @PostMapping("addSighting")
    public String addSighting(String date, HttpServletRequest request) {
        Sighting sighting = new Sighting();
        String locationId = request.getParameter("locationId");
        String heroId = request.getParameter("heroId");

        LocalDate localDateSighting;

        if (date.equals("")) {
            localDateSighting = null;
        } else {
            localDateSighting = LocalDate.parse(date, formatter);
        }

        sighting.setLocation(locationDao.getLocationById(Integer.parseInt(locationId)));
        sighting.setHero(heroDao.getHeroById(Integer.parseInt(heroId)));
        sighting.setDate(localDateSighting);

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(sighting);
        if (violations.isEmpty()) {
            sightingDao.addSighting(sighting);
        }

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
    public String performEditSighting(Integer sightingId, String date, HttpServletRequest request) {
        Sighting sighting = new Sighting();
        String locationId = request.getParameter("locationId");
        String heroId = request.getParameter("heroId");

        LocalDate localDateSighting = LocalDate.parse(date, formatter);

        sighting.setSightingId(sightingId);
        sighting.setLocation(locationDao.getLocationById(Integer.parseInt(locationId)));
        sighting.setHero(heroDao.getHeroById(Integer.parseInt(heroId)));
        sighting.setDate(localDateSighting);

        sightingDao.updateSighting(sighting);

        return "redirect:/sightings";
    }

    @GetMapping("sightingsDate")
    public String displaySightingsForDate(String date, Model model) {

        LocalDate localDateSighting;

        if (date.equals("")) {
            localDateSighting = null;
        } else {
            localDateSighting = LocalDate.parse(date, formatter);
        }

        Sighting sighting = new Sighting();
        sighting.setDate(localDateSighting);

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(sighting);

        if (violations.isEmpty()) {
            List<Sighting> sightings = sightingDao.getSightingsForDate(localDateSighting);
            model.addAttribute("sightings", sightings);
        } else {
            return "redirect:/sightings";
        }

        return "sightingsDate";
    }

    @GetMapping("index")
    public String displayTenMostRecentSightings(Model model) {
        List<Sighting> tenSightings = sightingDao.getTenMostRecentSightings();

        model.addAttribute("tenSightings", tenSightings);
        return "index";
    }
}
