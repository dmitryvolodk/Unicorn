package com.sg.spacerustlers;

public class SpaceRustlers {
    public static void main(String[] args){
        int spaceships = 10;
        int aliens = 25;
        int cows = 100;
        
        // If amount of aliens greater than spaceships than there are enough aliens to drive them
        if(aliens > spaceships){
            System.out.println("Vrroom, vroom! Let's get going!");
        } else {
            System.out.println("There aren't enough green guys to drive these ships!");
        }
        
        if(cows == spaceships){
            // If the amount of cows is equal to spaceships than it is just enough room to take the cows
            System.out.println("Wow, way to plan agead! JUST enough room for all these walking hamburgers!");
            System.out.println("Oh no!, The herds got restless and took over! Looks like _we're_ hamburger now!!");
            // If you remove else from "else if" then if even "cows == spaceships" the system will also make a second check for "cows > spaceships"
        } else if (cows > spaceships){
            // If the amount of cows is greater than spaceships than it is not enough space to take the cows
            System.out.println("Dangit! I don't how we're going to fit all these cows in there");
            System.out.println("Oh no!, The herds got restless and took over! Looks like _we're_ hamburger now!!");
        } else {
            // In this case spaceships amount is greater than cows. Would be great to get more cows.
            System.out.println("Too many ships! Not enough cows.");
            System.out.println("Hurrah, we've got the grub! Hamburger party on Alpha Centauri!");
        }
    }
}
