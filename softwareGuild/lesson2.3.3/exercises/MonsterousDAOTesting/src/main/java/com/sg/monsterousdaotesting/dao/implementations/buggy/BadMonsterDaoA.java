package com.sg.monsterousdaotesting.dao.implementations.buggy;

import com.sg.monsterousdaotesting.dao.MonsterDao;
import com.sg.monsterousdaotesting.model.Monster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BadMonsterDaoA implements MonsterDao {

    Map<Integer, Monster> monsters = new HashMap<>();
    int id;
    
    @Override
    public Monster addMonster(int id, Monster m) {
        return monsters.put(id, m);
    }

    @Override
    public Monster getMonster(int id) {
       Monster m = monsters.get(id);
       return m;
    }

    @Override
    public List<Monster> getAllMonsters() {
        List<Monster> monsterList = new ArrayList<>();
        monsterList.addAll(monsters.values());
        return monsterList;
    }

    @Override
    public void updateMonster(int id, Monster m) {
        monsters.replace(id, m);
    }

    @Override
    public Monster removeMonster(int id) {
        Monster m = monsters.remove(id);
        return m;
    }
    
}
