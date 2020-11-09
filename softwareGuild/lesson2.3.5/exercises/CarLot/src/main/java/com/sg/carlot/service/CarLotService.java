package com.sg.carlot.service;

import com.sg.carlot.dao.CarLotPersistenceException;
import com.sg.carlot.dto.Car;
import com.sg.carlot.dto.CarKey;
import java.math.BigDecimal;
import java.util.List;

public interface CarLotService {
    void createCar(Car car) throws CarLotPersistenceException;
    void editCar(Car car) throws CarLotPersistenceException;
    public Car getACar(String VIN)  throws CarLotPersistenceException;    
    public List<Car> getAllCars() throws CarLotPersistenceException;
    public List<Car> getCarsByColor() throws CarLotPersistenceException;
    public List<Car> getCarsInBudget() throws CarLotPersistenceException ;
    public List<Car> getCarByMakeAndModel() throws CarLotPersistenceException ;

    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount)
        throws NoSuchCarException;

    public CarKey sellCar(String VIN, BigDecimal cashPaid)
        throws CarLotPersistenceException,
        NoSuchCarException,
        OverpaidPriceException,
        UnderpaidPriceException;
}
