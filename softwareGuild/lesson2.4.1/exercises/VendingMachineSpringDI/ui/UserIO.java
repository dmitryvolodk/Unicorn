package com.sg.vendingmachinespringdi.ui;

import java.math.BigDecimal;

public interface UserIO {

    void print(String message);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);
    
    boolean readBoolean(String prompt);

    BigDecimal readBigDecimal(String prompt);

    BigDecimal readBigDecimal(String prompt, String min, String max);
    
    String readString(String prompt);
}