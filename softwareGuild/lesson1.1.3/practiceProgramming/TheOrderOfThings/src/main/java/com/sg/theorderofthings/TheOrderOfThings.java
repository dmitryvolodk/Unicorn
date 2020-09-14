package com.sg.theorderofthings;

public class TheOrderOfThings {
    public static void main(String[] args){
        double number;
        String opinion, size, age, shape, color, origin, material, purpose;
        String noun;
        
        number = 5.0;
        opinion = "AWESOME";
        size = "teensy-weensy";
        age = "new";
        shape = "oblong";
        color = "BRIGHT yellow";
        origin = "AlphaCentaurin";
        material = "platinum";
        purpose = "good";
        
        noun = "dragons";
        
        // Using the + with string, doesn't add it concatenates! (sticks them together)
        System.out.println(age + " " + opinion + " " + size + " " + shape + " " + color
                + " " + origin + " " + material + " " + purpose + " " + number + " " + noun);
    }
}
