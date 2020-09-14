package com.sg.addressbook.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    Scanner myScanner = new Scanner(System.in);
    private int inputInt;
    private String inputString;
    private float inputFloat;
    private double inputDouble;
    private long inputLong;
    
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
        System.out.println(prompt);
        inputLong = myScanner.nextLong();
        return inputLong;
    }
    @Override
    public long readLong(String prompt, long min, long max){
        do{
            System.out.println(prompt);
            inputLong = myScanner.nextLong();
        }while(inputLong < min || inputLong > max);
        return inputLong;
    }
    
    @Override
    public String readString(String prompt){
        System.out.println(prompt);
        inputString = myScanner.nextLine();
        return inputString;
    }
}