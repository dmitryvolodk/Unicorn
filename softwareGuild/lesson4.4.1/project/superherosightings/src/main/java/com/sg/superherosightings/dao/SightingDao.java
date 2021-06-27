package com.sg.superherosightings.dao;

import com.sg.superherosightings.entities.Sighting;
import java.time.LocalDate;
import java.util.List;

public interface SightingDao {
    Sighting getSightingById(int sightingId);
    List<Sighting> getAllSightings();
    // A user must be able to record a superhero/supervillain sighting for a particular location and date.
    Sighting addSighting(Sighting sighting);
    void updateSighting(Sighting sighting);
    void deleteSightingById(int sightingId);
    
    // The system must be able to report all sightings (hero and location) for a particular date.
    List<Sighting> getSightingsForDate(LocalDate date);
    
    // Get 10 most recent sightings
    List<Sighting> getTenMostRecentSightings();
}
