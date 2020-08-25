package com.sg.barelycontrolledchaos;

import java.util.Random;

public class BarelyControlledChaos {
    public static void main(String[] args){
        String color = generateColor();
        String animal = generateAnimal();
        String colorAgain = generateColor();
        int weight = generateNumber(5, 200);
        int distance = generateNumber(10, 20);
        int number = generateNumber(10000, 20000);
        int time = generateNumber(2, 6);
        
        System.out.println("Once, when I was very small...");
        
        System.out.println("I was chased by a " + color + "," 
                + weight + " lb " + " miniature " + animal
                + " for over " + distance + " miles!!");
        
        System.out.println("I had to hide in a field of over " 
                + number + " " + colorAgain + " poppies for nearly " 
                + time + " hours until it left me alone");
        
        System.out.println("\nIt was QUITE the experience, " 
                + "let me tell you!");
    }
    
    public static String generateColor(){
        Random colorRandomizer = new Random();
        int colorsNumber = colorRandomizer.nextInt(5);
        String colors = "";
        
        switch(colorsNumber){
            case 0: colors = "red";
                    break;
            case 1: colors = "orange";
                    break;
            case 2: colors = "yellow";
                    break;
            case 3: colors = "green";
                    break;
            case 4: colors = "blue";
        }
        return colors;
    }
    
    public static String generateAnimal(){
        Random animalRandomizer = new Random();
        int animalsNumber = animalRandomizer.nextInt(5);
        String animals = "";
        
        switch(animalsNumber){
            case 0: animals = "dogs";
                    break;
            case 1: animals = "cats";
                    break;
            case 2: animals = "horses";
                    break;
            case 3: animals = "lions";
                    break;
            case 4: animals = "pandas";
        }
        return animals;
    }
    
    public static int generateNumber(int min, int max){
        Random numberRandomizer = new Random();
        return numberRandomizer.nextInt(max - min + 1) + min;
    }
}
