package com.sg.vendingmachinespringdi.service;

import com.sg.vendingmachinespringdi.dao.VendingMachineAuditDao;
import com.sg.vendingmachinespringdi.dao.VendingMachineDao;
import com.sg.vendingmachinespringdi.dao.VendingMachinePersistenceException;
import com.sg.vendingmachinespringdi.dto.Item;
import java.math.BigDecimal;
import java.util.List;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    VendingMachineDao dao;
    VendingMachineAuditDao auditDao;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        return dao.getAllItems();
    }

    @Override
    public Item getItem(String name) throws VendingMachinePersistenceException {
        return dao.getItem(name);
    }

    @Override
    public Item updateItem(String name, BigDecimal money) throws VendingMachinePersistenceException,
            VendingMachineInsufficientFundsException,
            VendingMachineNoItemInventoryException {

        // First check to see if there is no such item 
        // associated with the given item name
        // If there isn't an item, we're all done here - 
        // throw a VendingMachineNoItemInventoryException
        Item purchasedItem = dao.getItem(name);
        if (purchasedItem == null || purchasedItem.getItemsNumber() == 0) {
            throw new VendingMachineNoItemInventoryException("ERROR: Could not find item. Name "
                    + name
                    + " doesn't exist or out of stock.");
        }

        // Now validate if the user hase sufficient funds to purchase the item.
        // This method will throw an 
        // exception if the user's funds are insufficient.
        ValidateInsufficientFunds(purchasedItem, money);

        if (purchasedItem.getItemsNumber() > 0) {
            int newItemsNumber = purchasedItem.getItemsNumber() - 1;
            purchasedItem.setItemsNumber(newItemsNumber);
            Item updatedItem = dao.updateItem(name, purchasedItem);
            // Write to audit log
            auditDao.writeAuditEntry("Item " + name + " updated.");
            return updatedItem;
        }

        return purchasedItem;
    }

    private void ValidateInsufficientFunds(Item item, BigDecimal money) throws VendingMachineInsufficientFundsException {
        if (item.getCost().compareTo(money) > 0) {
            throw new VendingMachineInsufficientFundsException("ERROR: Insufficient funds.");
        }
    }

}
