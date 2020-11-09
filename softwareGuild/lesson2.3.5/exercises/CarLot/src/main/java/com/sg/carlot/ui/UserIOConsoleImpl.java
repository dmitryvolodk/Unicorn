package com.sg.carlot.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {

    Scanner myScanner = new Scanner(System.in);
    private int inputInt;
    private String inputIntFromString;
    private String inputString;
    private float inputFloat;
    private double inputDouble;
    private long inputLong;
    private String inputLongString;
    private boolean inputBoolean;
    private String inputBooleanString;
    private BigDecimal inputBigDecimalA;
    private BigDecimal inputBigDecimalB;
    private String inputBigDecimalString;

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        inputDouble = myScanner.nextDouble();
        return inputDouble;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        do {
            System.out.println(prompt);
            inputDouble = myScanner.nextDouble();
        } while (inputDouble < min || inputDouble > max);
        return inputDouble;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        inputFloat = myScanner.nextFloat();
        return inputFloat;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        do {
            System.out.println(prompt);
            inputFloat = myScanner.nextFloat();
        } while (inputFloat < min || inputFloat > max);
        return inputFloat;
    }

    @Override
    public int readInt(String prompt) {
        try {
            System.out.println(prompt);
            inputIntFromString = myScanner.nextLine();
            inputInt = Integer.parseInt(inputIntFromString);
        } catch (Exception e) {
            System.out.println("Invalid entry");
        }
        return inputInt;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        do {
            try {
                System.out.println(prompt);
                inputIntFromString = myScanner.nextLine();
                inputInt = Integer.parseInt(inputIntFromString);
            } catch (Exception e) {
                System.out.println("Invalid entry");
            }
        } while (inputInt < min || inputInt > max);
        return inputInt;
    }

    @Override
    public long readLong(String prompt) {
        try {
            System.out.println(prompt);
            inputLongString = myScanner.nextLine();
            inputLong = Long.parseLong(inputLongString);
        } catch (Exception e) {
            System.out.println("Invalid entry");
        }
        return inputLong;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        do {
            try {
                System.out.println(prompt);
                inputLongString = myScanner.nextLine();
                inputLong = Long.parseLong(inputLongString);
            } catch (Exception e) {
                System.out.println("Invalid entry");
            }
        } while (inputLong < min || inputLong > max);
        return inputLong;
    }
    
    @Override
    public boolean readBoolean(String prompt) {
        try {
            System.out.println(prompt);
            inputBooleanString = myScanner.nextLine();
            inputBoolean = Boolean.parseBoolean(inputBooleanString);
        } catch (Exception e) {
            System.out.println("Invalid entry");
        }
        return inputBoolean;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        try {
            System.out.println(prompt);
            inputBigDecimalString = myScanner.nextLine();
            inputBigDecimalA = new BigDecimal(inputBigDecimalString);
        } catch (Exception e) {
            System.out.println("Invalid entry");
        }
        inputBigDecimalB = inputBigDecimalA.setScale(2, RoundingMode.HALF_UP);
        return inputBigDecimalB;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt, String min, String max) {
        BigDecimal bigDecimalMin = new BigDecimal(min);
        BigDecimal bigDecimalMax = new BigDecimal(max);
        do {
            try {
                System.out.println(prompt);
                inputBigDecimalString = myScanner.nextLine();
                inputBigDecimalA = new BigDecimal(inputBigDecimalString);
            } catch (Exception e) {
                System.out.println("Invalid entry");
            }
        } while (inputBigDecimalA.compareTo(bigDecimalMin) < 0 || 
                inputBigDecimalA.compareTo(bigDecimalMax) > 0);
        inputBigDecimalB = inputBigDecimalA.setScale(2, RoundingMode.HALF_UP);
        return inputBigDecimalB;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        inputString = myScanner.nextLine();
        return inputString;
    }
}