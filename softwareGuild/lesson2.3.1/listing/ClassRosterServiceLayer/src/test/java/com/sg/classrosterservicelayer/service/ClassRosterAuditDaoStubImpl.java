package com.sg.classrosterservicelayer.service;

import com.sg.classrosterservicelayer.dao.ClassRosterAuditDao;
import com.sg.classrosterservicelayer.dao.ClassRosterPersistenceException;

public class ClassRosterAuditDaoStubImpl implements ClassRosterAuditDao {
    
    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        //do nothig ...
    }
}
