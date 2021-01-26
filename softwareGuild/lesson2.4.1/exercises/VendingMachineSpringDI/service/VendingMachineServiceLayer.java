package com.sg.vendingmachinespringdi.service;

import com.sg.vendingmachinespringdi.dao.VendingMachinePersistenceException;
import com.sg.vendingmachinespringdi.dto.Item;
import java.math.BigDecimal;
import java.util.List;

public interface VendingMachineServiceLayer {

    List<Item> getAllItems() throws VendingMachinePersistenceException;
    
    Item getItem(String name) throws VendingMachinePersistenceException;
    
    Item updateItem(String name, BigDecimal money) throws VendingMachinePersistenceException,
            VendingMachineInsufficientFundsException,
            VendingMachineNoItemInventoryException;
}
