package com.sg.userio;

public interface UserIOInterface {
    public void print(String message);
    
    public double readDouble(String prompt);
    public double readDouble(String prompt, double min, double max);
    
    public float readFloat(String prompt);
    public float readFloat(String prompt, float min, float max);
    
    public int readInt(String prompt);
    public int readInt(String prompt, int min, int max);
    
    public long readLong(String prompt);
    public long readLong(String prompt, long min, long max);
    
    public String readString(String prompt);
}
