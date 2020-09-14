package com.sg.userio;

import java.util.Scanner;

public class UserIO implements UserIOInterface {
    Scanner myScanner = new Scanner(System.in);
    private int inputInt;
    private String inputString;
    private float inputFloat;
    private double inputDouble;
    
    @Override
    public void print(String message){
        System.out.println(message);
    }
    
    @Override
    public double readDouble(String prompt){
        System.out.println(prompt);
        inputDouble = myScanner.nextDouble();
        return inputDouble;
    }
    @Override
    public double readDouble(String prompt, double min, double max){
        do{
            System.out.println(prompt);
            inputDouble = myScanner.nextDouble();
        }while(inputDouble < min || inputDouble > max);
        return inputDouble;
    }
    
    @Override
    public float readFloat(String prompt){
        System.out.println(prompt);
        inputFloat = myScanner.nextFloat();
        return inputFloat;
    }
    @Override
    public float readFloat(String prompt, float min, float max){
        do{
            System.out.println(prompt);
            inputFloat = myScanner.nextFloat();
        }while(inputFloat < min || inputFloat > max);
        return inputFloat;
    }
    
    @Override
    public int readInt(String prompt){
        System.out.println(prompt);
        inputInt = myScanner.nextInt();
        return inputInt;
    }
    @Override
    public int readInt(String prompt, int min, int max){
        do{
            System.out.println(prompt);
            inputInt = myScanner.nextInt();
        }while(inputInt < min || inputInt > max);
        return inputInt;
    }
    
    @Override
    public long readLong(String prompt){
        return 0;
    }
    @Override
    public long readLong(String prompt, long min, long max){
        return 0;
    }
    
    @Override
    public String readString(String prompt){
        System.out.println(prompt);
        inputString = myScanner.nextLine();
        return inputString;
    }

    public int getInputInt() {
        return inputInt;
    }

    public void setInputInt(int inputInt) {
        this.inputInt = inputInt;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public float getInputFloat() {
        return inputFloat;
    }

    public void setInputFloat(float inputFloat) {
        this.inputFloat = inputFloat;
    }

    public double getInputDouble() {
        return inputDouble;
    }

    public void setInputDouble(double inputDouble) {
        this.inputDouble = inputDouble;
    }
}
