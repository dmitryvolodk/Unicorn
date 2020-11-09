package com.sg.monsterousdaotesting.dao.implementations.buggy;

import com.sg.monsterousdaotesting.dao.MonsterDao;
import com.sg.monsterousdaotesting.model.Monster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BadMonsterDaoC implements MonsterDao {

    Map<Integer, Monster> monsters = new HashMap<>();
    
    @Override
    public Monster addMonster(int id, Monster m) {
        if(monsters.containsKey(id)){
            Monster oldMonster = monsters.get(id);
            monsters.put(id, m);
            return oldMonster;
        }
        return monsters.put(id, m);
    }

    @Override
    public Monster getMonster(int id) {
       return monsters.get(id);
    }

    @Override
    public List<Monster> getAllMonsters() {
        Set<Integer> keys = monsters.keySet();
        ArrayList<Monster> manyMonsters = new ArrayList<>();
        for (Integer k : keys) {
            manyMonsters.add(monsters.get(k));
        }
        return manyMonsters;
    }

    @Override
    public void updateMonster(int id, Monster m) {
        Monster oldMonster = monsters.replace(id, m);
    }

    @Override
    public Monster removeMonster(int id) {
        Monster m = monsters.get(id);
        monsters.remove(id);
        return m;
    }
    
}
