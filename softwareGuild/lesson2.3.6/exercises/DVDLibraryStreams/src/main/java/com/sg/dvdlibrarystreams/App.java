package com.sg.dvdlibrarystreams;

import com.sg.dvdlibrarystreams.controller.DVDLibraryController;
import com.sg.dvdlibrarystreams.dao.DVDLibraryDao;
import com.sg.dvdlibrarystreams.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibrarystreams.ui.DVDLibraryView;
import com.sg.dvdlibrarystreams.ui.UserIO;
import com.sg.dvdlibrarystreams.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        controller.run();
    }
}
