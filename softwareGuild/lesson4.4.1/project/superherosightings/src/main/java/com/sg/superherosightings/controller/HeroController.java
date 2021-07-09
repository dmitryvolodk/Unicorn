package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.HeroDao;
import com.sg.superherosightings.dao.LocationDao;
import com.sg.superherosightings.dao.OrganizationDao;
import com.sg.superherosightings.dao.SightingDao;
import com.sg.superherosightings.dao.SuperpowerDao;
import com.sg.superherosightings.entities.Hero;
import com.sg.superherosightings.entities.Organization;
import com.sg.superherosightings.entities.Superpower;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HeroController {

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

    @GetMapping("heroes")
    public String displayHeroes(Model model) {
        List<Hero> heroes = heroDao.getAllHeroes();
        List<Superpower> superpowers = superpowerDao.getAllSuperpowers();
        List<Organization> organizations = organizationDao.getAllOrganizations();
        model.addAttribute("heroes", heroes);
        model.addAttribute("superpowers", superpowers);
        model.addAttribute("organizations", organizations);
        return "heroes";
    }

    @PostMapping("addHero")
    public String addHero(Hero hero, HttpServletRequest request) {
        String superpowerId = request.getParameter("superpowerId");
        String[] organizationIds = request.getParameterValues("organizationId");

        hero.setSuperpower(superpowerDao.getSuperpowerById(Integer.parseInt(superpowerId)));

        List<Organization> organizations = new ArrayList<>();
        for (String organizationId : organizationIds) {
            organizations.add(organizationDao.getOrganizationById(Integer.parseInt(organizationId)));
        }
        hero.setOrganizations(organizations);
        heroDao.addHero(hero);

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
    public String performEditHero(Hero hero, HttpServletRequest request) {
        String superpowerId = request.getParameter("superpowerId");
        String[] organizationIds = request.getParameterValues("organizationId");

        hero.setSuperpower(superpowerDao.getSuperpowerById(Integer.parseInt(superpowerId)));

        List<Organization> organizations = new ArrayList<>();
        for (String organizationId : organizationIds) {
            organizations.add(organizationDao.getOrganizationById(Integer.parseInt(organizationId)));
        }
        hero.setOrganizations(organizations);
        heroDao.updateHero(hero);

        return "redirect:/heroes";
    }
}
