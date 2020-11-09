package com.sg.carlot.service;

import com.sg.carlot.dao.CarLotDao;
import com.sg.carlot.dao.CarLotPersistenceException;
import com.sg.carlot.dto.Car;
import com.sg.carlot.dto.CarKey;
import java.math.BigDecimal;
import java.util.List;

public class CarLotServiceImpl implements CarLotService {

    CarLotDao dao;

    public CarLotServiceImpl(CarLotDao dao) {
        this.dao = dao;
    }

    @Override
    public void createCar(Car car) throws CarLotPersistenceException {
        dao.addCar(car.getVIN(), car);
    }
    
    @Override
    public void editCar(Car car) throws CarLotPersistenceException {
        dao.editCar(car.getVIN(), car);
    }

    @Override
    public Car getACar(String VIN) throws CarLotPersistenceException {
        return dao.getCar(VIN);
    }

    @Override
    public List<Car> getAllCars() throws CarLotPersistenceException {
        return dao.getCars();
    }

    @Override
    public List<Car> getCarsByColor() throws CarLotPersistenceException {
        return dao.getCars();
    }

    @Override
    public List<Car> getCarsInBudget() throws CarLotPersistenceException {
        return dao.getCars();
    }

    @Override
    public List<Car> getCarByMakeAndModel() throws CarLotPersistenceException {
        return dao.getCars();
    }

    @Override
    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount) throws NoSuchCarException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CarKey sellCar(String VIN, BigDecimal cashPaid) throws CarLotPersistenceException, NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {

        Car soldCar = dao.getCar(VIN);

        if (soldCar == null) {
            throw new NoSuchCarException("ERROR: Could not find car. VIN "
                    + VIN
                    + " doesn't exist");
        }
        
        validateOverpaidPrice(soldCar, cashPaid);
        validateUnderpaidPrice(soldCar, cashPaid);
        Car removedCar = dao.removeCar(VIN);
        return removedCar.getKey();
    }

    private void validateOverpaidPrice(Car car, BigDecimal cashPaid) throws OverpaidPriceException {
        if (car.getPrice().compareTo(cashPaid) < 0) {
            throw new OverpaidPriceException("ERROR: Price is overpaid.");
        }
    }
    
    private void validateUnderpaidPrice(Car car, BigDecimal cashPaid) throws UnderpaidPriceException {
        if (car.getPrice().compareTo(cashPaid) > 0) {
            throw new UnderpaidPriceException("ERROR: Price is underpaid.");
        }
    }
}
