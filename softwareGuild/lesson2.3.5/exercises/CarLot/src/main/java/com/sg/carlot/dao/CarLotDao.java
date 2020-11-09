package com.sg.carlot.dao;

import com.sg.carlot.dto.Car;
import java.util.List;

public interface CarLotDao {
    /**
     * Adds the given Car to the lot and associates it with the given
     * car VIN. If there is already a car associated with the given
     * car VIN it will return that car object, otherwise it will
     * return null.
     * 
     * @param VIN number with which car to be associated
     * @param car car to be added to the lot
     * @return the Car object previously associated with the given 
     * VIN number if it exists null otherwise
     * @throws com.sg.carlot.dao.CarLotPersistenceException
     */
    public Car addCar(String VIN, Car car) throws CarLotPersistenceException;
    
    /**
     * Return a String array containing the car VINs of all
     * cars in the lot.
     * 
     * @return String array containing the VINs of all the cars
     * in the roster
     * @throws com.sg.carlot.dao.CarLotPersistenceException
     */
    public List<Car> getCars() throws CarLotPersistenceException;
    
    /**
     * Returns the car object associated with the given VIN number.
     * Returns null if no such car exists
     * 
     * @param VIN VIN of the car to retrieve
     * @return the Car object associated with the given VIN number,
     * null if no such car exists
     * @throws com.sg.carlot.dao.CarLotPersistenceException
     */
    public Car getCar(String VIN) throws CarLotPersistenceException;
    
    /**
     * Removes from the lot the car associated with the given VIN.
     * Returns the car object that is being removed or null if
     * there is no car associated with the given VIN number
     * 
     * @param VIN VIN of car to be removed
     * @return Car object that was removed or null if no car
     * was associated with the given VIN
     * @throws com.sg.carlot.dao.CarLotPersistenceException
     */
    public Car removeCar(String VIN) throws CarLotPersistenceException;
    
    /**
     * Edits the given Car in the lot and associates it with the given
     * car VIN. If there is already a car associated with the given
     * car VIN it will return that car object, otherwise it will
     * return null.
     * 
     * @param VIN number with which car to be associated
     * @param car car to be edited in the lot
     * @return the Car object previously associated with the given 
     * VIN number if it exists null otherwise
     * @throws com.sg.carlot.dao.CarLotPersistenceException
     */
    public Car editCar(String VIN, Car car) throws CarLotPersistenceException;
}