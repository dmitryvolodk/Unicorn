package com.sg.dvdlibraryspringdi;

import com.sg.dvdlibraryspringdi.controller.DVDLibraryController;
import com.sg.dvdlibraryspringdi.dao.DVDLibraryDao;
import com.sg.dvdlibraryspringdi.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibraryspringdi.ui.DVDLibraryView;
import com.sg.dvdlibraryspringdi.ui.UserIO;
import com.sg.dvdlibraryspringdi.ui.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        // UserIO myIo = new UserIOConsoleImpl();
        // DVDLibraryView myView = new DVDLibraryView(myIo);
        // DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        // DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        // controller.run();
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DVDLibraryController controller = ctx.getBean("controller", DVDLibraryController.class);
        controller.run();
    }
}
