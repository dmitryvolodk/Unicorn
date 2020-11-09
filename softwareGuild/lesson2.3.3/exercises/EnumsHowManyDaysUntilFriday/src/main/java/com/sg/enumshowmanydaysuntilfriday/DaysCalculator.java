package com.sg.enumshowmanydaysuntilfriday;

public class DaysCalculator {
    private int daysNumber;

    public int calculateDays(WeekDay day){

        switch (day) {
            case SATURDAY:
                daysNumber++;
            case SUNDAY:
                daysNumber++;
            case MONDAY:
                daysNumber++;
            case TUESDAY:
                daysNumber++;
            case WEDNESDAY:
                daysNumber++;
            case THURSDAY:
                daysNumber++;
                break;
            default:
                throw new UnsupportedOperationException();
        }
        
        return daysNumber;
    }
}
