package com.sg.flooring;

import com.sg.flooring.controller.FlooringController;
import com.sg.flooring.dao.FlooringDao;
import com.sg.flooring.dao.FlooringDaoFileImpl;
import com.sg.flooring.service.FlooringServiceLayer;
import com.sg.flooring.service.FlooringServiceLayerImpl;
import com.sg.flooring.ui.FlooringView;
import com.sg.flooring.ui.UserIO;
import com.sg.flooring.ui.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        // UserIO myIo = new UserIOConsoleImpl();
        // FlooringView myView = new FlooringView(myIo);
        // FlooringDao myDao = new FlooringDaoFileImpl();
        // FlooringServiceLayer myService = new FlooringServiceLayerImpl(myDao);
        // FlooringController controller = new FlooringController(myService, myView);
        // controller.run();
        
        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringController controller = 
           ctx.getBean("controller", FlooringController.class);
        controller.run();
    }
}
