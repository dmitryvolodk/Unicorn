package com.sg.vendingmachinespringdi.service;

import com.sg.vendingmachinespringdi.dao.VendingMachineAuditDao;
import com.sg.vendingmachinespringdi.dao.VendingMachinePersistenceException;

public class VendingMachineAuditDaoStubImpl implements VendingMachineAuditDao{

    @Override
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException {
        // do nothing . . .
    }
    
}
