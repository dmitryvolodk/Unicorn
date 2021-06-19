package com.sg.superherosightings.dao;

import com.sg.superherosightings.entities.Hero;
import com.sg.superherosightings.entities.Location;
import java.util.List;

public interface LocationDao {
    Location getLocationById(int locationId);
    List<Location> getAllLocations();
    Location addLocation(Location location);
    void updateLocation(Location location);
    void deleteLocationById(int locationId);
    
    // The system must be able to report all of the locations where a particular superhero has been seen.
    List<Location> getLocationsForHero(Hero hero);
}
