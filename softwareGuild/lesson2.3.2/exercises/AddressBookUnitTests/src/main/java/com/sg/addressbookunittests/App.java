package com.sg.addressbookunittests;

import com.sg.addressbookunittests.controller.AddressBookController;
import com.sg.addressbookunittests.dao.AddressBookDao;
import com.sg.addressbookunittests.dao.AddressBookDaoFileImpl;
import com.sg.addressbookunittests.ui.AddressBookView;
import com.sg.addressbookunittests.ui.UserIO;
import com.sg.addressbookunittests.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        AddressBookView myView = new AddressBookView(myIo);
        AddressBookDao myDao = new AddressBookDaoFileImpl();
        AddressBookController controller
                = new AddressBookController(myDao, myView);
        controller.run();
    }
}
