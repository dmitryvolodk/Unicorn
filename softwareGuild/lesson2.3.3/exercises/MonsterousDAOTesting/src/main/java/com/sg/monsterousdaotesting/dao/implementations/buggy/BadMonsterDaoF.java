package com.sg.monsterousdaotesting.dao.implementations.buggy;

import com.sg.monsterousdaotesting.dao.MonsterDao;
import com.sg.monsterousdaotesting.model.Monster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BadMonsterDaoF implements MonsterDao {

    Map<Integer, Monster> monsters = new HashMap<>();

    @Override
    public Monster addMonster(int id, Monster m) {
        Monster otherM = monsters.get(id);
        monsters.put(id, m);
        return otherM;
    }

    @Override
    public Monster getMonster(int id) {
        Monster storedMonster = null;
        
        if (monsters.containsKey(id)) {
            storedMonster = monsters.put(id, storedMonster);
        }

        return storedMonster;
    }

    @Override
    public List<Monster> getAllMonsters() {
        List<Monster> monsterList = new ArrayList<>();
        for (int id : monsters.keySet()) {
            monsterList.add(monsters.get(id));
        }
        return monsterList;
    }

    @Override
    public void updateMonster(int id, Monster m) {
        Monster monster = monsters.get(id);
        if (monster != null) {
            monsters.put(id, m);
        }
    }

    @Override
    public Monster removeMonster(int id) {
        Monster removedMonster = monsters.remove(id);
        return removedMonster;
    }

}
