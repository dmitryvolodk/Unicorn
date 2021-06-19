package com.sg.superherosightings.dao;

import com.sg.superherosightings.entities.Superpower;
import java.util.List;

public interface SuperpowerDao {
    Superpower getSuperpowerById(int superpowerId);
    List<Superpower> getAllSuperpowers();
    Superpower addSuperpower(Superpower superpower);
    void updateSuperpower(Superpower superpower);
    void deleteSuperpowerById(int superpowerId);
}
