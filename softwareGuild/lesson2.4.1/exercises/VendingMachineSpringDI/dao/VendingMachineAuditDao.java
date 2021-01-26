package com.sg.vendingmachinespringdi.dao;

public interface VendingMachineAuditDao {

    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException;
}
