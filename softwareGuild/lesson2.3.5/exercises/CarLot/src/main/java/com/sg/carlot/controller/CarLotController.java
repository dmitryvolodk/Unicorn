package com.sg.carlot.controller;

import com.sg.carlot.dao.CarLotDao;
import com.sg.carlot.dao.CarLotPersistenceException;
import com.sg.carlot.dao.CarLotDaoFileImpl;
import com.sg.carlot.dto.Car;
import com.sg.carlot.service.CarLotService;
import com.sg.carlot.service.NoSuchCarException;
import com.sg.carlot.service.OverpaidPriceException;
import com.sg.carlot.service.UnderpaidPriceException;
import com.sg.carlot.ui.CarLotView;
import java.math.BigDecimal;
import java.util.List;

public class CarLotController {

    CarLotView view;
    private CarLotService service;

    public CarLotController(CarLotService service, CarLotView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listCars();
                        break;
                    case 2:
                        createCar();
                        break;
                    case 3:
                        viewCar();
                        break;
                    case 4:
                        sellCar();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    case 6:
                        editCar();
                        break;
                    case 7:
                        listCarsByColor();
                        break;
                    case 8:
                        listCarsInBudget();
                        break;
                    case 9:
                        listCarsByMakeAndModel();
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (CarLotPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createCar() throws CarLotPersistenceException {
        view.displayCreateCarBanner();
        Car newCar = view.getNewCarInfo();
        service.createCar(newCar);
        view.displayCreateSuccessBanner();
    }

    private void listCars() throws CarLotPersistenceException {
        view.displayDisplayAllBanner();
        List<Car> carList = service.getAllCars();
        view.displayCarList(carList);
    }

    private void viewCar() throws CarLotPersistenceException {
        view.displayDisplayCarBanner();
        String VIN = view.getVINChoice();
        Car car = service.getACar(VIN);
        view.displayCar(car);
    }

    private void sellCar() throws CarLotPersistenceException {
        view.displaySellCarBanner();
        boolean hasErrors = false;
        do {
            String VIN = view.getVINChoice();
            BigDecimal cashPaid = view.getCashPaidChoice();
            try {
                service.sellCar(VIN, cashPaid);
                view.displaySellSuccessBanner();
                hasErrors = false;
            } catch (NoSuchCarException | OverpaidPriceException | UnderpaidPriceException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void editCar() throws CarLotPersistenceException {
        view.displayEditCarBanner();
        Car editedCar = view.getNewCarInfo();
        service.editCar(editedCar);
        view.displayEditSuccessBanner();
    }

    private void listCarsByColor() throws CarLotPersistenceException {
        view.displayDisplayCarsByColorBanner();
        String color = view.getColorChoice();
        List<Car> carList = service.getCarsByColor();
        view.displayCarListByColor(carList, color);
    }

    private void listCarsInBudget() throws CarLotPersistenceException {
        view.displayDisplayCarsInBudgetBanner();
        BigDecimal price = view.getMaxPriceChoice();
        List<Car> carList = service.getCarsInBudget();
        view.displayCarListInBudget(carList, price);
    }

    private void listCarsByMakeAndModel() throws CarLotPersistenceException {
        view.displayDisplayCarsByMakeAndModelBanner();
        String make = view.getMakeChoice();
        String model = view.getModelChoice();
        List<Car> carList = service.getCarByMakeAndModel();
        view.displayCarListByMakeAndModel(carList, make, model);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
