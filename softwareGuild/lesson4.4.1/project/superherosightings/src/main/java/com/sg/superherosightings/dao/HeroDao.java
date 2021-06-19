package com.sg.superherosightings.dao;

import com.sg.superherosightings.entities.Hero;
import com.sg.superherosightings.entities.Location;
import com.sg.superherosightings.entities.Organization;
import java.util.List;

public interface HeroDao {
    Hero getHeroById(int heroId);
    List<Hero> getAllHeroes();
    Hero addHero(Hero hero);
    void updateHero(Hero hero);
    void deleteHero(int heroId);
    
    // The system must be able to report all of the superheroes sighted at a particular location.
    List<Hero> getHeroesAtLocation(Location location);
    
    // The system must be able to report all of the members of a particular organization.
    List<Hero> getHeroesForOrganization(Organization organization);
}


