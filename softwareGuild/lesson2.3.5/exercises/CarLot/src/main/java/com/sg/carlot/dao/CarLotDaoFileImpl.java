package com.sg.carlot.dao;

import com.sg.carlot.dto.Car;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CarLotDaoFileImpl implements CarLotDao{
    
    public static final String LOT_FILE = "lot.txt";
    public static final String DELIMITER = "::";
    
    private Map<String, Car> cars = new HashMap<>();

    @Override
    public Car addCar(String VIN, Car car) throws CarLotPersistenceException {
        Car newCar = cars.put(VIN, car);
        writeLot();
        return newCar;
    }

    @Override
    public List<Car> getCars() throws CarLotPersistenceException {
        loadLot();
        return new ArrayList<Car>(cars.values());
    }

    @Override
    public Car getCar(String VIN) throws CarLotPersistenceException {
        loadLot();
        return cars.get(VIN);
    }

    @Override
    public Car removeCar(String VIN) throws CarLotPersistenceException {
       Car removedCar = cars.remove(VIN);
       writeLot();
       return removedCar;
    }
    
    @Override
    public Car editCar(String VIN, Car car) throws CarLotPersistenceException {
        loadLot();
        Car editedCar = cars.put(VIN, car);
        writeLot();
        return editedCar;
    }
    
    private void loadLot() throws CarLotPersistenceException{
        Scanner scanner;
        
        try{
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(LOT_FILE)));
        }catch(FileNotFoundException e){
            throw new CarLotPersistenceException(
                    "-_- Could not load lot data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER
        // In our case we use  :: as our delimiter. If
        // currentLine looks like this:
        // 13456789::Honda::Civic::Grey::20643::120369::true
        // then currentTokens will be a string array that looks like this:
        //
        //_______________________________________________
        // |         |     |     |    |     |      |    | 
        // |123456789|Honda|Civic|Grey|20643|120369|true|
        // |         |     |     |    |     |      |    |
        // ----------------------------------------------
        //     [0]     [1]   [2]   [3]  [4]    [5]   [6]
        String[] currentTokens;
        // Go through LOT_FILE line by line, decoding each line into a 
        // Car object.
        // Process while we have more lines in the file
        while(scanner.hasNextLine()){
            // get the next line in the file
            currentLine = scanner.nextLine();
            // breake up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // Create a new Car object and put it into the map of cars
            // We are going to use the VIN
            // which is currentTokens[0] as the map key for our car object.
            // We also have to pass the VIN into the Car constructor
            Car currentCar = new Car(currentTokens[0]);
            // Set the remaining values on currentCar manually
            currentCar.setMake(currentTokens[1]);
            currentCar.setModel(currentTokens[2]);
            currentCar.setColor(currentTokens[3]);
            currentCar.setPrice(new BigDecimal(currentTokens[4]));
            currentCar.setOdometerMiles(Long.parseLong(currentTokens[5]));
            currentCar.getKey().setLaserCut(Boolean.parseBoolean(currentTokens[6]));
            
            // Put currentCar into the map using VIN as the key
            cars.put(currentCar.getVIN(), currentCar);
        }
        // close scanner
        scanner.close();
    }
    
    /**
     * Writes all cars in the lot out to a LOT_FILE. See loadLot
     * for file format.
     * 
     * @throws CarLotPersistenceException if an error occurs writing to the file
     */
    private void writeLot() throws CarLotPersistenceException{
        // We are not handling the IOException - but
        // we are translating it to an application specific exception and
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us. It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;
        
        try{
            out = new PrintWriter(new FileWriter(LOT_FILE));
        } catch (IOException e) {
            throw new CarLotPersistenceException("Could not save car data.", e);
        }
        
        // Write out the Car objects to the lot file.
        // We could just grab the car map,
        // get the Collection of Cars and iterate over them but we've
        // already created a method that gets a List of Cars so
        // we'll reuse it.
        List<Car> carList = this.getCars();
        for (Car currentCar : carList){
            // write the Car object to the file
            out.println(currentCar.getVIN() + DELIMITER 
                    + currentCar.getMake() + DELIMITER 
                    + currentCar.getModel() + DELIMITER 
                    + currentCar.getColor() + DELIMITER 
                    + currentCar.getPrice().toString() + DELIMITER 
                    + currentCar.getOdometerMiles() + DELIMITER 
                    + currentCar.getKey().isLaserCut());
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}