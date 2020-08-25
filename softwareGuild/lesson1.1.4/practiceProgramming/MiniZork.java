package com.sg.minizork;

import java.util.Scanner;

public class MiniZork {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.println("Go to the house, or open the mailbox? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.println("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.println("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) {
                System.out.println("You move your hands in the mailbox.");
                System.out.println("It becomes spooky... so spooky.");
                System.out.println("Run away or keep holding the hands in the mailbox? ");
                action = userInput.nextLine();

                if (action.equals("keep holding hands")) {
                    System.out.println("Looks like sticking hands into dark places is a bad idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming all the time - doesn't look nice.");
                    System.out.println("But you are alive. Probaly it was very wise choice.");
                }
            }
        } else if (action.equals("go to the house")) {
            System.out.println("You go to the house.");
            System.out.println("It's food here in the first room.");
            System.out.println("Eat a lots of food or go to the next room? ");
            action = userInput.nextLine();

            if (action.equals("eat a lots of food")) {
                System.out.println("You looks at amazing richness of the food!");
                System.out.println("But you don't know if the food is poisoned");
                System.out.println("Go away or keep eating? ");
                action = userInput.nextLine();

                if (action.equals("keep eating")) {
                    System.out.println("Turns out, overeating is not very good idea.");
                    System.out.println("However, you enjoyed eating and then left the house.");
                } else if (action.equals("go away")) {
                    System.out.println("You went away.");
                    System.out.println("It is possibly a borring day for you, but nothing bad happend.");
                }
            } else if (action.equals("go to the next room")) {
                System.out.println("You go to the next room");
                System.out.println("You see a small box of very expensive antic gold items.");
                System.out.println("Go away with the gold or go to the next room? ");
                action = userInput.nextLine();

                if (action.equals("go to the next room")) {
                    System.out.println("Went to the next room and see even more gold!!!");
                    System.out.println("I am rich for the rest of my life!!!");
                } else if (action.equals("go away with the gold")) {
                    System.out.println("I got away with a good amount of gold to have parties for the rest of the year.");
                    System.out.println("At least I din't loos anything and I am just having fun.");
                }
            }
        
        }
    }
}