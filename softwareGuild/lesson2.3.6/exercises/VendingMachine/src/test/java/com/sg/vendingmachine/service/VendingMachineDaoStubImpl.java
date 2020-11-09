package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineDaoStubImpl implements VendingMachineDao {

    public Item onlyItem;
    public Item secondItem;

    // Snickers Bar::5::1.89
    public VendingMachineDaoStubImpl() {
        onlyItem = new Item("Snickers Bar");
        onlyItem.setItemsNumber(5);
        onlyItem.setCost(new BigDecimal("1.89"));
        secondItem = new Item("Mars Bar");
        secondItem.setItemsNumber(0);
        secondItem.setCost(new BigDecimal("2.01"));
    }

    public VendingMachineDaoStubImpl(Item testItem) {
        this.onlyItem = testItem;
    }

    @Override
    public Item updateItem(String name, Item item) throws VendingMachinePersistenceException {
        if (name.equals(onlyItem.getName())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        List<Item> itemList = new ArrayList<>();
        itemList.add(onlyItem);
        itemList.add(secondItem);
        return itemList;
    }

    @Override
    public Item getItem(String name) throws VendingMachinePersistenceException {
        if (name.equals(onlyItem.getName())) {
            return onlyItem;
        } else if (name.equals(secondItem.getName())) {
            return secondItem;
        } else {
            return null;
        }
    }
}
