package com.sg.monsterousdaotesting.dao.implementations.buggy;

import com.sg.monsterousdaotesting.dao.MonsterDao;
import com.sg.monsterousdaotesting.model.Monster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BadMonsterDaoE implements MonsterDao {

    Map<Integer, Monster> monsters = new HashMap<>();
    
    @Override
    public Monster addMonster(int id, Monster m) {
        return monsters.put(id, m);
    }

    @Override
    public Monster getMonster(int id) {
       return monsters.remove(id);
    }

    @Override
    public List<Monster> getAllMonsters() {
        return new ArrayList<>(monsters.values());
    }

    @Override
    public void updateMonster(int id, Monster m) {
        if(monsters.containsKey(id)){
            monsters.replace(id, m);
        }
    }

    @Override
    public Monster removeMonster(int id) {
        Monster toRemove = monsters.get(id);
        monsters.remove(id);
        return toRemove;
    }
    
}
