package com.sg.flooring.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private LocalDate inputLocalDate;
    private String inputLocalDateString;

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
        boolean hasErrors = false;
        do {
            hasErrors = false;
            try {
                System.out.println(prompt);
                inputBigDecimalString = myScanner.nextLine();
                if (inputBigDecimalString.equals("")) {
                    inputBigDecimalA = null;
                } else {
                    inputBigDecimalA = new BigDecimal(inputBigDecimalString);
                    inputBigDecimalB = inputBigDecimalA.setScale(2, RoundingMode.HALF_UP);
                }
            } catch (Exception e) {
                hasErrors = true;
                System.out.println("Invalid entry. It should be with digits [0-9].");
            }
        } while (hasErrors);
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
        } while (inputBigDecimalA.compareTo(bigDecimalMin) < 0
                || inputBigDecimalA.compareTo(bigDecimalMax) > 0);
        inputBigDecimalB = inputBigDecimalA.setScale(2, RoundingMode.HALF_UP);
        return inputBigDecimalB;
    }

    @Override
    public LocalDate readLocalDate(String prompt) {
        try {
            System.out.println(prompt);
            inputLocalDateString = myScanner.nextLine();
            // Specify the pattern of the incoming date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            // Create a LocalDate object containing the date
            inputLocalDate = LocalDate.parse(inputLocalDateString, formatter);
        } catch (Exception e) {
            System.out.println("Invalid entry");
        }
        return inputLocalDate;
    }

    @Override
    public LocalDate readLocalDate(String prompt, String min, String max) {
        // Specify the pattern of the incoming date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        // Create a LocalDate objects containing the min and max dates
        LocalDate localDateMin = LocalDate.parse(min, formatter);
        LocalDate localDateMax = LocalDate.parse(max, formatter);
        do {
            try {
                System.out.println(prompt);
                inputLocalDateString = myScanner.nextLine();
                inputLocalDate = LocalDate.parse(inputLocalDateString, formatter);
            } catch (Exception e) {
                System.out.println("Invalid entry");
            }
        } while (inputLocalDate.compareTo(localDateMin) < 0 || inputLocalDate.compareTo(localDateMax) > 0);
        return inputLocalDate;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        inputString = myScanner.nextLine();
        return inputString;
    }
}
