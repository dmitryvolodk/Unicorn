package com.sg.fallingthroughswitchstatement;

public class FallingThroughSwitchStatement {
    public static void main(String[] args){
        int day = 4;
        String dayType = "";
        
        switch(day){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                dayType = "week day";
                break;
            case 6:
            case 7:
                dayType = "weekend day";
                break;
            default:
                dayType = "invalid day";
        }
        
        System.out.println(dayType);
    }
}
