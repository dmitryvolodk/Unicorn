package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.HeroDao;
import com.sg.superherosightings.dao.LocationDao;
import com.sg.superherosightings.dao.OrganizationDao;
import com.sg.superherosightings.dao.SightingDao;
import com.sg.superherosightings.dao.SuperpowerDao;
import com.sg.superherosightings.entities.Hero;
import com.sg.superherosightings.entities.Location;
import com.sg.superherosightings.entities.Organization;
import com.sg.superherosightings.entities.Superpower;
import com.sg.superherosightings.storage.StorageService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HeroController {

    Set<ConstraintViolation<Hero>> violations = new HashSet<>();

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

    @Autowired
    StorageService storageService;

    @GetMapping("heroes")
    public String displayHeroes(Model model) {
        List<Hero> heroes = heroDao.getAllHeroes();
        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        List<Organization> organizations = organizationDao.getAllOrganizations();
        model.addAttribute("heroes", heroes);
        model.addAttribute("superpowers", superpowers);
        model.addAttribute("organizations", organizations);
        model.addAttribute("errors", violations);
        return "heroes";
    }

    @PostMapping("addHero")
    public String addHero(Hero hero, HttpServletRequest request) {
        String superpowerId = request.getParameter("superpowerId");
        String[] organizationIds = request.getParameterValues("organizationId");

        hero.setSuperpower(superpowerDao.getSuperpowerById(Integer.parseInt(superpowerId)));

        List<Organization> organizations = new ArrayList<>();

        try {
            for (String organizationId : organizationIds) {
                organizations.add(organizationDao.getOrganizationById(Integer.parseInt(organizationId)));
            }
        } catch (Exception e){
            // If no organization selected - NullPointerException happen.
            System.out.println("***NullPointerException***");
            organizations = null;
        }

        hero.setOrganizations(organizations);

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(hero);

        if (violations.isEmpty()) {
            heroDao.addHero(hero);
        }

        return "redirect:/heroes";
    }

    @GetMapping("heroDetail")
    public String heroDetail(Integer heroId, Model model) {
        Hero hero = heroDao.getHeroById(heroId);
        model.addAttribute("hero", hero);
        return "heroDetail";
    }

    @GetMapping("deleteHero")
    public String deleteHero(Integer heroId) {
        heroDao.deleteHero(heroId);
        return "redirect:/heroes";
    }

    @GetMapping("editHero")
    public String editHero(Integer heroId, Model model) {
        Hero hero = heroDao.getHeroById(heroId);
        List<Organization> organizations = organizationDao.getAllOrganizations();
        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        model.addAttribute("hero", hero);
        model.addAttribute("organizations", organizations);
        model.addAttribute("superpowers", superpowers);
        return "editHero";
    }

    @PostMapping("editHero")
    public String performEditHero(@Valid Hero hero, BindingResult result, HttpServletRequest request, Model model) {
        String superpowerId = request.getParameter("superpowerId");
        String[] organizationIds = request.getParameterValues("organizationId");

        hero.setSuperpower(superpowerDao.getSuperpowerById(Integer.parseInt(superpowerId)));

        List<Organization> organizations = new ArrayList<>();

        if (organizationIds != null) {
            for (String organizationId : organizationIds) {
                organizations.add(organizationDao.getOrganizationById(Integer.parseInt(organizationId)));
            }
        } else {
            FieldError error = new FieldError("hero", "organizations", "Must include one organization");
            result.addError(error);
        }

        hero.setOrganizations(organizations);

        if (result.hasErrors()) {
            model.addAttribute("superpowers", superpowerDao.getAllSuperpowers());
            model.addAttribute("organizations", organizationDao.getAllOrganizations());
            model.addAttribute("hero", hero);
            return "editHero";
        }

        heroDao.updateHero(hero);

        return "redirect:/heroes";
    }

    @GetMapping("heroOrganizations")
    public String displayOrganizationsForHero(Integer heroId, Model model) {
        Hero hero = heroDao.getHeroById(heroId);
        List<Organization> organizations = organizationDao.getOrganizationsForHero(hero);
        model.addAttribute("hero", hero);
        model.addAttribute("organizations", organizations);
        return "heroOrganizations";
    }

    @GetMapping("heroLocations")
    public String displayLocationsForHero(Integer heroId, Model model) {
        Hero hero = heroDao.getHeroById(heroId);
        String photoName = hero.getPhotoName();
        String photoPath = "http://localhost:8080/files/" + photoName;
        List<Location> locations = locationDao.getLocationsForHero(hero);
        model.addAttribute("hero", hero);
        model.addAttribute("locations", locations);
        model.addAttribute("photoPath", photoPath);
        return "heroLocations";
    }
}
