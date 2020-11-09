package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

public interface VendingMachineServiceLayer {

    List<Item> getAllItems() throws VendingMachinePersistenceException;
    
    Item getItem(String name) throws VendingMachinePersistenceException;
    
    Item updateItem(String name, BigDecimal money) throws VendingMachinePersistenceException,
            VendingMachineInsufficientFundsException,
            VendingMachineNoItemInventoryException;
}
