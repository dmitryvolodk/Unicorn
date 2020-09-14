 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.numbersadder2;

/**
 *
 * @author dmitryvolodk
 */
import java.util.Scanner;

public class Adder2 {
    public static void main(String[] args){
        // Declare and initialize variables to store the interger operands
        int sum = 0;
        int operand1 = 0;
        int operand2 = 0;
        
        // Declare and initialize the Scanner object
        Scanner myScanner = new Scanner(System.in);
        
        // Declare and initialize the String variable for the operands
        String stringOperand1 = "";
        String stringOperand2 = "";

        // Prompt user for the input of operands
        System.out.println("Please enter the first number to add: ");
        
        // Read the user input and save the value into operand1
        stringOperand1 = myScanner.nextLine();
        
        // Prompt the user to enter the second operand
        System.out.println("Please enter the second number to add: ");
        
        // Read the users input and save the value into the second operand variable
        stringOperand2 = myScanner.nextLine();
        
        // Convert two string operands into the interger operands
        operand1 = Integer.parseInt(stringOperand1);
        operand2 = Integer.parseInt(stringOperand2);
        
        // Add to operands and assign the value to sum
        sum = operand1 + operand2;
        
        // Display the sum  value to the sonsol
        System.out.println("Sum is " + sum);
        
    }
    
}
