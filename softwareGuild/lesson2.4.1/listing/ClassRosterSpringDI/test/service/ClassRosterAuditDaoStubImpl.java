package com.sg.classrosterspringdi.service;

import com.sg.classrosterspringdi.dao.ClassRosterAuditDao;
import com.sg.classrosterspringdi.dao.ClassRosterPersistenceException;

public class ClassRosterAuditDaoStubImpl implements ClassRosterAuditDao {
    
    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        //do nothig ...
    }
}