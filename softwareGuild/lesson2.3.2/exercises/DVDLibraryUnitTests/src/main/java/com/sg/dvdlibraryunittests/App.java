package com.sg.dvdlibraryunittests;

import com.sg.dvdlibraryunittests.controller.DVDLibraryController;
import com.sg.dvdlibraryunittests.dao.DVDLibraryDao;
import com.sg.dvdlibraryunittests.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibraryunittests.ui.DVDLibraryView;
import com.sg.dvdlibraryunittests.ui.UserIO;
import com.sg.dvdlibraryunittests.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        controller.run();
    }
}
