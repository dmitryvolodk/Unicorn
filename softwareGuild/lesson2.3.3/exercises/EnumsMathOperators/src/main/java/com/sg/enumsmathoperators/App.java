package com.sg.enumsmathoperators;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner myScanner = new Scanner(System.in);
        
        int additionResult = 0, substructionResult = 0,
                multiplicationResult = 0, divisionResult = 0;
        MathOperator operator;
        int operand1 = 0,
                operand2 = 0;

        System.out.println("Operand1 and operand2: ");
        
        operand1 = myScanner.nextInt();
        operand2 = myScanner.nextInt();
        
        operator = MathOperator.valueOf("PLUS");
        additionResult = calculator.calculateNumbers(operator, operand1, operand2);
        
        operator = MathOperator.valueOf("MINUS");
        substructionResult = calculator.calculateNumbers(operator, operand1, operand2);
        
        operator = MathOperator.valueOf("MULTIPLY");
        multiplicationResult = calculator.calculateNumbers(operator, operand1, operand2);
        
        operator = MathOperator.valueOf("DIVIDE");
        divisionResult = calculator.calculateNumbers(operator, operand1, operand2);
        
        System.out.println("Addition result: " + additionResult 
                + "\nSubstruction result: " + substructionResult
                + "\nMultiplication result: " + multiplicationResult
                + "\nDivision result: " + divisionResult);
    }
}
