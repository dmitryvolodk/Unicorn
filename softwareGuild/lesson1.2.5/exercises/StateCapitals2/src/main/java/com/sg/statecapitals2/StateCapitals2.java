package com.sg.statecapitals2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;

public class StateCapitals2 {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        Integer minPop = 0;
        
        ArrayList<Capital> capitalList = new ArrayList<>();
        
        for(int i = 0; i < 50; i++){
            capitalList.add(new Capital());
        }
        
        capitalList.get(0).setNamePopulationSqMileage("Montgomery", 198525, 160);
        capitalList.get(1).setNamePopulationSqMileage("Juneau", 32113, 2717);
        capitalList.get(2).setNamePopulationSqMileage("Phoenix", 1680992, 518);
        capitalList.get(3).setNamePopulationSqMileage("Little Rock", 197312, 116);
        capitalList.get(4).setNamePopulationSqMileage("Sacramento", 513624, 98);
        capitalList.get(5).setNamePopulationSqMileage("Denver", 727211, 153);
        capitalList.get(6).setNamePopulationSqMileage("Hartford", 122105, 17);
        capitalList.get(7).setNamePopulationSqMileage("Dover", 38079, 22);
        capitalList.get(8).setNamePopulationSqMileage("Tallahassee", 194500, 96);
        capitalList.get(9).setNamePopulationSqMileage("Atlanta", 506811, 134);
        capitalList.get(10).setNamePopulationSqMileage("Honolulu", 345064, 68);
        capitalList.get(11).setNamePopulationSqMileage("Boise", 228959, 64);
        capitalList.get(12).setNamePopulationSqMileage("Springfield", 114230, 54);
        capitalList.get(13).setNamePopulationSqMileage("Indianapolis", 876384, 362);
        capitalList.get(14).setNamePopulationSqMileage("Des Moines", 214237, 76);
        capitalList.get(15).setNamePopulationSqMileage("Topeka", 125310, 56);
        capitalList.get(16).setNamePopulationSqMileage("Frankfort", 27679, 15);
        capitalList.get(17).setNamePopulationSqMileage("Baton Rouge", 220236, 77);
        capitalList.get(18).setNamePopulationSqMileage("Augusta", 18681, 55);
        capitalList.get(19).setNamePopulationSqMileage("Annapolis", 39174, 7);
        capitalList.get(20).setNamePopulationSqMileage("Boston", 692600, 90);
        capitalList.get(21).setNamePopulationSqMileage("Lansing", 118210, 35);
        capitalList.get(22).setNamePopulationSqMileage("Saint Paul", 308096, 53);
        capitalList.get(23).setNamePopulationSqMileage("Jackson", 160628, 105);
        capitalList.get(24).setNamePopulationSqMileage("Jefferson City", 42838, 27);
        capitalList.get(25).setNamePopulationSqMileage("Helena", 32315, 14);
        capitalList.get(26).setNamePopulationSqMileage("Lincoln", 289102, 75);
        capitalList.get(27).setNamePopulationSqMileage("Carson City", 55916, 143);
        capitalList.get(28).setNamePopulationSqMileage("Concord", 43627, 64);
        capitalList.get(29).setNamePopulationSqMileage("Trenton", 83203, 8);
        capitalList.get(30).setNamePopulationSqMileage("Santa Fe", 84683, 37);
        capitalList.get(31).setNamePopulationSqMileage("Albany", 96460, 21);
        capitalList.get(32).setNamePopulationSqMileage("Raleigh", 474069, 115);
        capitalList.get(33).setNamePopulationSqMileage("Bismarck", 73529, 27);
        capitalList.get(34).setNamePopulationSqMileage("Columbus", 898553, 210);
        capitalList.get(35).setNamePopulationSqMileage("Oklahoma City", 655057, 620);
        capitalList.get(36).setNamePopulationSqMileage("Salem", 174365, 46);
        capitalList.get(37).setNamePopulationSqMileage("Harrisburg", 49528, 8);
        capitalList.get(38).setNamePopulationSqMileage("Providence", 179883, 19);
        capitalList.get(39).setNamePopulationSqMileage("Columbia", 131674, 125);
        capitalList.get(40).setNamePopulationSqMileage("Pierre", 13646, 13);
        capitalList.get(41).setNamePopulationSqMileage("Nashville", 670820, 526);
        capitalList.get(42).setNamePopulationSqMileage("Austin", 978908, 305);
        capitalList.get(43).setNamePopulationSqMileage("Salt Lake City", 200567, 109);
        capitalList.get(44).setNamePopulationSqMileage("Montpelier", 7855, 10);
        capitalList.get(45).setNamePopulationSqMileage("Richmond", 230436, 60);
        capitalList.get(46).setNamePopulationSqMileage("Olympia", 46478, 17);
        capitalList.get(47).setNamePopulationSqMileage("Charleston", 46536, 32);
        capitalList.get(48).setNamePopulationSqMileage("Madison", 259680, 69);
        capitalList.get(49).setNamePopulationSqMileage("Cheyenne", 64235, 21);
        
        HashMap<String, Capital> capitals = new HashMap<>();
        capitals.put("Alabama", capitalList.get(0));
        capitals.put("Alaska", capitalList.get(1));
        capitals.put("Arizona", capitalList.get(2));
        capitals.put("Arkansas", capitalList.get(3));
        capitals.put("California", capitalList.get(4));
        capitals.put("Colorado", capitalList.get(5));
        capitals.put("Connecticut", capitalList.get(6));
        capitals.put("Delaware", capitalList.get(7));
        capitals.put("Florida", capitalList.get(8));
        capitals.put("Georgia", capitalList.get(9));
        capitals.put("Hawaii", capitalList.get(10));
        capitals.put("Idaho", capitalList.get(11));
        capitals.put("Illinois", capitalList.get(12));
        capitals.put("Indiana", capitalList.get(13));
        capitals.put("Iowa", capitalList.get(14));
        capitals.put("Kansas", capitalList.get(15));
        capitals.put("Kentucky", capitalList.get(16));
        capitals.put("Louisiana", capitalList.get(17));
        capitals.put("Main", capitalList.get(18));
        capitals.put("Maryland", capitalList.get(19));
        capitals.put("Massachusetts", capitalList.get(20));
        capitals.put("Michigan", capitalList.get(21));
        capitals.put("Minnesota", capitalList.get(22));
        capitals.put("Mississippi", capitalList.get(23));
        capitals.put("Missouri", capitalList.get(24));
        capitals.put("Montana", capitalList.get(25));
        capitals.put("Nebraska", capitalList.get(26));
        capitals.put("Nevada", capitalList.get(27));
        capitals.put("New Hampshire", capitalList.get(28));
        capitals.put("New Jersey", capitalList.get(29));
        capitals.put("New Mexico", capitalList.get(30));
        capitals.put("New York", capitalList.get(31));
        capitals.put("North Carolina", capitalList.get(32));
        capitals.put("North Dakota", capitalList.get(33));
        capitals.put("Ohio", capitalList.get(34));
        capitals.put("Oklahoma", capitalList.get(35));
        capitals.put("Oregon", capitalList.get(36));
        capitals.put("Pennsylvania", capitalList.get(37));
        capitals.put("Rhode Island", capitalList.get(38));
        capitals.put("South Carolina", capitalList.get(39));
        capitals.put("South Dakota", capitalList.get(40));
        capitals.put("Tennessee", capitalList.get(41));
        capitals.put("Texas", capitalList.get(42));
        capitals.put("Utah", capitalList.get(43));
        capitals.put("Vermont", capitalList.get(44));
        capitals.put("Virginia", capitalList.get(45));
        capitals.put("Washington", capitalList.get(46));
        capitals.put("West Virginia", capitalList.get(47));
        capitals.put("Wisconsin", capitalList.get(48));
        capitals.put("Wyoming", capitalList.get(49));
        
        Set<String> states = capitals.keySet();
        
        System.out.println("STATE/CAPITAL PAIRS: \n=======================");
        for(String keys : states){
            System.out.println(keys + " - " + capitals.get(keys).getName() + " | Pop: " + capitals.get(keys).getPopulation() + " | Area: " + capitals.get(keys).getSqMileage() + " sq mi");
        }
        
        System.out.println("\nPlease enter the lower limit for capital city population: ");
        minPop = myScanner.nextInt();
        
        System.out.println("\nLISTING CAPITALS WITH POPULATIONS GREATER THAN " + minPop + ":\n");
        for(String keys : states){
            if(capitals.get(keys).getPopulation() >= minPop){
            System.out.println(keys + " - " + capitals.get(keys).getName() + " | Pop: " + capitals.get(keys).getPopulation() + " | Area: " + capitals.get(keys).getSqMileage() + " sq mi");
            }
        }
    }
}
