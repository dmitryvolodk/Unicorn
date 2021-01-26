package com.sg.vendingmachinespringdi.dto;

import java.math.BigDecimal;

public class Change {

    private int quartersNumber;
    private int dimesNumber;
    private int nickelsNumber;
    private int penniesNumber;
    private int changeDue;

    public void calculateChange(BigDecimal money, BigDecimal cost) {
        BigDecimal changeBigDecimal = (money.subtract(cost)).multiply(new BigDecimal("100"));

        changeDue = changeBigDecimal.intValue();

        if (changeDue >= 25) {
            this.quartersNumber = calculateCoins(CoinsValues.QUARTERS);
        }

        if (changeDue >= 10) {
            this.dimesNumber = calculateCoins(CoinsValues.DIMES);
        }

        if (changeDue >= 5) {
            this.nickelsNumber = calculateCoins(CoinsValues.NICKELS);
        }

        this.penniesNumber = changeDue;
    }

    private int calculateCoins(CoinsValues coin) {
        switch (coin) {
            case QUARTERS:
                int quartersNumber = changeDue / 25;
                changeDue = changeDue % 25;
                return quartersNumber;
            case DIMES:
                int dimesNumber = changeDue / 10;
                changeDue = changeDue % 10;
                return dimesNumber;
            case NICKELS:
                int nickelsNumber = changeDue / 5;
                changeDue = changeDue % 5;
                return nickelsNumber;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public int getQuartersNumber() {
        return quartersNumber;
    }

    public int getDimesNumber() {
        return dimesNumber;
    }

    public int getNickelsNumber() {
        return nickelsNumber;
    }

    public int getPenniesNumber() {
        return penniesNumber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.quartersNumber;
        hash = 97 * hash + this.dimesNumber;
        hash = 97 * hash + this.nickelsNumber;
        hash = 97 * hash + this.penniesNumber;
        hash = 97 * hash + this.changeDue;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Change other = (Change) obj;
        if (this.quartersNumber != other.quartersNumber) {
            return false;
        }
        if (this.dimesNumber != other.dimesNumber) {
            return false;
        }
        if (this.nickelsNumber != other.nickelsNumber) {
            return false;
        }
        if (this.penniesNumber != other.penniesNumber) {
            return false;
        }
        if (this.changeDue != other.changeDue) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Change{" + "quartersNumber=" + quartersNumber + ", dimesNumber=" + dimesNumber + ", nickelsNumber=" + nickelsNumber + ", penniesNumber=" + penniesNumber + ", changeDue=" + changeDue + '}';
    }
}
