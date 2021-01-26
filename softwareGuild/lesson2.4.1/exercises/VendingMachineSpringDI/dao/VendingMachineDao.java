package com.sg.vendingmachinespringdi.dao;

import com.sg.vendingmachinespringdi.dto.Item;
import java.util.List;

public interface VendingMachineDao {

    /**
     * Adds the given Item to the machine and associates it with the given
     * item name. If there is already an item associated with the given
     * item name it will return that item object, otherwise it will return
     * null.
     *
     * @param name name with which item is to be associated
     * @param item item to be added to the machine
     * @return the Item object previously associated with the given item
     * name if it exists, null otherwise
     * @throws com.sg.vendingmachine.dao.VendingMachinePersistenceException
     */
    Item updateItem(String name, Item item) throws VendingMachinePersistenceException ;

    /**
     * Returns a String map containing the names of all items in the machine.
     *
     * @return String map containing the names of all the items in the machine
     * @throws com.sg.vendingmachine.dao.VendingMachinePersistenceException
     */
    List<Item> getAllItems() throws VendingMachinePersistenceException;

    /**
     * Returns the item object associated with the given item name. Returns null
     * if no such item exists
     *
     * @param name name of the item to retrieve
     * @return the Item object associated with the given item name, null if no
     * such item exists
     * @throws com.sg.vendingmachine.dao.VendingMachinePersistenceException
     */
    Item getItem(String name) throws VendingMachinePersistenceException;
}
