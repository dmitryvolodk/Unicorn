package com.sg.classrosterservicelayer;

import com.sg.classrosterservicelayer.controller.ClassRosterController;
import com.sg.classrosterservicelayer.dao.ClassRosterAuditDao;
import com.sg.classrosterservicelayer.dao.ClassRosterAuditDaoFileImpl;
import com.sg.classrosterservicelayer.dao.ClassRosterDao;
import com.sg.classrosterservicelayer.dao.ClassRosterDaoFileImpl;
import com.sg.classrosterservicelayer.service.ClassRosterServiceLayer;
import com.sg.classrosterservicelayer.service.ClassRosterServiceLayerImpl;
import com.sg.classrosterservicelayer.ui.ClassRosterView;
import com.sg.classrosterservicelayer.ui.UserIO;
import com.sg.classrosterservicelayer.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        // Instantiate the UserIO implementation
        UserIO myIo = new UserIOConsoleImpl();
        // Instantiate the View and wire the UserIO implementation into it
        ClassRosterView myView = new ClassRosterView(myIo);
        // Instantiate the DAO
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        // Instantiate the Audit DAO
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        //Instantiate the Controller and wire the Service Layer into it
        ClassRosterController controller = new ClassRosterController(myService, myView);
        // Kick off the Controller
        controller.run();
    }
}
