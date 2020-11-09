package com.sg.carlot;

import com.sg.carlot.controller.CarLotController;
import com.sg.carlot.dao.CarLotDao;
import com.sg.carlot.dao.CarLotDaoFileImpl;
import com.sg.carlot.service.CarLotService;
import com.sg.carlot.service.CarLotServiceImpl;
import com.sg.carlot.ui.CarLotView;
import com.sg.carlot.ui.UserIO;
import com.sg.carlot.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        CarLotView myView = new CarLotView(myIo);
        CarLotDao myDao = new CarLotDaoFileImpl();
        CarLotService myService = new CarLotServiceImpl(myDao);
        CarLotController controller = new CarLotController(myService, myView);
        controller.run();
    }
}
