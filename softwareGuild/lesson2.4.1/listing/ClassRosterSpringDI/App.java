package com.sg.classrosterspringdi;

import com.sg.classrosterspringdi.controller.ClassRosterController;
import com.sg.classrosterspringdi.dao.ClassRosterAuditDao;
import com.sg.classrosterspringdi.dao.ClassRosterAuditDaoFileImpl;
import com.sg.classrosterspringdi.dao.ClassRosterDao;
import com.sg.classrosterspringdi.dao.ClassRosterDaoFileImpl;
import com.sg.classrosterspringdi.service.ClassRosterServiceLayer;
import com.sg.classrosterspringdi.service.ClassRosterServiceLayerImpl;
import com.sg.classrosterspringdi.ui.ClassRosterView;
import com.sg.classrosterspringdi.ui.UserIO;
import com.sg.classrosterspringdi.ui.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        // Instantiate the UserIO implementation
        // UserIO myIo = new UserIOConsoleImpl();
        
        // Instantiate the View and wire the UserIO implementation into it
        // ClassRosterView myView = new ClassRosterView(myIo);
        
        // Instantiate the DAO
        // ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        
        // Instantiate the Audit DAO
        // ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        
        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
        // ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        
        // Instantiate the Controller and wire the Service Layer into it
        // ClassRosterController controller = new ClassRosterController(myService, myView);
        
        // Kick off the Controller
        // controller.run();
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassRosterController controller = ctx.getBean("controller", ClassRosterController.class);
        controller.run();
    }
}