package com.sg.vendingmachinespringdi;

import com.sg.vendingmachinespringdi.controller.VendingMachineController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        // Instantiate the UserIO implementation
        // UserIO myIo = new UserIOConsoleImpl();
        // Instantiate the View and wire the UserIO implementation into it
        // VendingMachineView myView = new VendingMachineView(myIo);
        // Instantiate the DAO
        // VendingMachineDao myDao = new VendingMachineDaoFileImpl();
        // Instantiate the Audit DAO
        // VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
        // Change myChange = new Change();
        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
        // VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao, myAuditDao);
        // Instantiate the Controller and wire the Service Layer into it
        // VendingMachineController controller = new VendingMachineController(myService, myView, myChange);
        // Kick off the Controller
        // controller.run();
        
         ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller = ctx.getBean("controller", VendingMachineController.class);
        controller.run();
    }
}