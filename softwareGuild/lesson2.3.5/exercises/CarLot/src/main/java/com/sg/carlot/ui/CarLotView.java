package com.sg.carlot.ui;

import com.sg.carlot.dto.Car;
import java.math.BigDecimal;
import java.util.List;

public class CarLotView {

    UserIO io;
    
    public CarLotView(UserIO io){
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Car VINs");
        io.print("2. Create New Car");
        io.print("3. View a Car");
        io.print("4. Sell a Car");
        io.print("5. Exit");
        io.print("6. Edit a Car");
        io.print("7. List Cars by Color");
        io.print("8. List Cars in Budget");
        io.print("9. List Cars by Make and Model");

        return io.readInt("Please select from the above choices.", 1, 9);
    }
    
    public Car getNewCarInfo(){
        String VIN = io.readString("Please enter VIN");
        String make = io.readString("Please enter Make");
        String model = io.readString("Please enter Model");
        String color = io.readString("Please enter Color");
        BigDecimal price = io.readBigDecimal("Please enter Price");
        Long odometerMiles = io.readLong("Please enter OdometerMiles");
        boolean laserCut = io.readBoolean("Please enter true "
                + "if Car Key - laser cut, otherwise - false.");
        Car currentCar = new Car(VIN);
        currentCar.setMake(make);
        currentCar.setModel(model);
        currentCar.setColor(color);
        currentCar.setPrice(price);
        currentCar.setOdometerMiles(odometerMiles);
        currentCar.getKey().setLaserCut(laserCut);
        return currentCar;
    }
    
    public void displayCreateCarBanner(){
        io.print("=== Create Car ===");
    }
    
    public void displayCreateSuccessBanner(){
        io.readString("Car successfully created. Please hit enter to continue");
    }
    
    public void displayCarList(List<Car> carList){
        for (Car currentCar : carList){
            io.print(currentCar.getVIN() + ": " + currentCar.getMake() + " " 
                    + currentCar.getModel() + " " + currentCar.getColor());
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner(){
        io.print("=== Display All Cars ===");
    }
    
    public void displayDisplayCarBanner(){
        io.print("=== Display Car ===");
    }
    
    public String getVINChoice(){
        return io.readString("Please enter the VIN.");
    }
    
    public void displayCar(Car car){
        if(car != null){
            io.print(car.getVIN());
            io.print(car.getMake() + " " + car.getModel() + " " 
                    + car.getColor());
            io.print(car.getPrice().toString());
            io.print(String.valueOf(car.getOdometerMiles()));
            io.print(String.valueOf(car.getKey().isLaserCut()));
            io.print("");
        } else {
            io.print("No such car.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displaySellCarBanner(){
        io.print("=== Sell Car ===");
    }
    
    public BigDecimal getCashPaidChoice(){
        return io.readBigDecimal("Please enter the price.");
    }
    
    public void displaySellSuccessBanner(){
        io.readString("Car successfully sold. Please hit enter to continue.");
    }
    
    public void displayEditCarBanner() {
        io.print("=== Edit Car ===");
    }

    public void displayEditSuccessBanner() {
        io.readString("Car(s) successfully edited.  Please hit enter to continue");
    }
    
    public void displayDisplayCarsByColorBanner(){
        io.print("=== Display Cars by Color ===");
    }
    
    public String getColorChoice(){
        return io.readString("Please enter the color.");
    }
    
    public void displayCarListByColor(List<Car> carList, String color){
        for (Car currentCar : carList){
            if(currentCar.getColor().equalsIgnoreCase(color)){
            io.print(currentCar.getVIN() + ": " + currentCar.getMake() + " " 
                    + currentCar.getModel() + " " + currentCar.getColor());
            }
        io.readString("Please hit enter to continue.");
        }
    }
        
    public void displayDisplayCarsInBudgetBanner(){
        io.print("=== Display Cars in Budget ===");
    }
    
    public BigDecimal getMaxPriceChoice(){
        return io.readBigDecimal("Please enter the price.");
    }
    
    public void displayCarListInBudget(List<Car> carList, BigDecimal price){
        for (Car currentCar : carList){
            if(currentCar.getPrice().compareTo(price) <= 0){
            io.print(currentCar.getVIN() + ": " + currentCar.getMake() + " " 
                    + currentCar.getModel() + " " + currentCar.getColor());
            }
        io.readString("Please hit enter to continue.");
        }
    }
    
    public void displayDisplayCarsByMakeAndModelBanner(){
        io.print("=== Display Cars by Make And Model ===");
    }
    
    public String getMakeChoice(){
        return io.readString("Please enter the make.");
    }
    
    public String getModelChoice(){
        return io.readString("Please enter the model.");
    }
    
    public void displayCarListByMakeAndModel(List<Car> carList, String make, String model){
        for (Car currentCar : carList){
            if(currentCar.getMake().equalsIgnoreCase(make) && currentCar.getModel().equalsIgnoreCase(model)){
            io.print(currentCar.getVIN() + ": " + currentCar.getMake() + " " 
                    + currentCar.getModel() + " " + currentCar.getColor());
            }
        io.readString("Please hit enter to continue.");
        }
    }
    
    public void displayExitBanner(){
        io.print("Good Bye!!!");
    }
    
    public void displayUnknownCommandBanner(){
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg){
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
