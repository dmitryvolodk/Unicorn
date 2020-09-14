/*
* Program name: Rock Paper Scissors
* Author: Dmitry Volodkevich
* Date created: 08/05/2020
* Date modified:
 */
package com.sg.rockpaperscissors;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random randomizer = new Random();

        boolean playAgain = false;  // variable for the user to stop the game or play again
        int roundNum = 0, // variable for how many rounds the user would like to have
                count = 0, // variable that counting the number of rounds
                tie = 0, // variable for how many ties are in the game
                userWins = 0, // variable for how many times user won
                computerWins = 0, // variable for how many time computer won
                choiceUser = 0, // variable for the user's choice to select
                choiceComp = 0;     // variable for the computer's choice to select

        do {
            // Prompt the user how many rounds to play
            System.out.println("How many rounds do you want to play?");
            roundNum = myScanner.nextInt();

            if (roundNum < 1 || roundNum > 10) {
                // Display and error if the number of rounds is outside of the range [1;10]
                System.out.println("The number is outside of the range.");
                continue;
            }

            for (int i = 1; i <= roundNum; i++) {
                // User chooses  Rock, Paper, or Scissors
                System.out.println("\nChoose: \n1 for Rock \n2 for Paper \n3 for Scissors");
                choiceUser = myScanner.nextInt();
                // Computer chooses Rock, Paper, or Scissors
                choiceComp = randomizer.nextInt(3) + 1;
                
                if(choiceUser < 1 || choiceUser >3){
                    System.out.println("Incorrect input.");
                    i--;
                    continue;
                }
                
                // If both players choose the same thing, the round is a tie
                if (choiceUser == choiceComp) {
                    tie++;
                    System.out.println("Tie!");
                    // Paper wraps Rock to win, Scissors cut Paper to win, Rock breaks Scissors to win
                    // Identify cases when the user wins
                } else if ((choiceUser == 2 && choiceComp == 1) || (choiceUser == 3 && choiceComp == 2) || (choiceUser == 1 && choiceComp == 3)) {
                    userWins++;
                    System.out.println("User win!");
                    // Identify cases when the computer wins
                } else {
                    computerWins++;
                    System.out.println("Computer win!");
                    // Display an error message, when an input is incorrect
                } 
            }

            // Display the results of the game just played
            System.out.println("\nTie = " + tie + "\nUser wins = " + userWins + "\nComputer wins = " + computerWins);
            // Declare the winner (user or computer)
            if (userWins >= computerWins) {
                System.out.println("The winner is User!");
            } else {
                System.out.println("The winner is Computer!");
            }
            // Ask the user if he/she wants to play the game again
            System.out.println("\nDo you want to play again? (true / false)");
            playAgain = myScanner.nextBoolean();
            // Reset the variables to be able to play the game again
            count = tie = userWins = computerWins = 0;
        } while (playAgain == true);

        System.out.println("Thanks for playing!");
    }
}
