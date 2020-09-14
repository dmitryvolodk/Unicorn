package com.sg.simplecalculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        SimpleCalculator myCalculator = new SimpleCalculator();

        float number1 = 0,
                number2 = 0;
        String number1String = "",
                number2String = "";
        String operation = "n";

        do {
            System.out.println("Choose \'exit\' to exit or an operation to perform (\'+\' or \'-\' or \'*\' or  \'/\'):");
            operation = myScanner.nextLine();

            if (operation.equals("exit")) {
                break;
            }
                System.out.println("Enter num1:");
                number1String = myScanner.nextLine();
                System.out.println("Enter num2:");
                number2String = myScanner.nextLine();
                number1 = Float.parseFloat(number1String);
                number2 = Float.parseFloat(number2String);

                System.out.println("The result is " + myCalculator.calculate(number1, number2, operation));
            
        } while (!(operation.equals("exit")));

        System.out.println("Good bye!");
    }
}
