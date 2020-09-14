package com.sg.simplecalculatoruserio;

public class SimpleCalculatorUserIO {
    public float calculate(float num1, float num2, String operation){
        float result = 0;
        switch(operation){
            case "+": result = num1 + num2;
                        break;
            case "-": result = num1 - num2;
                        break;
            case "*": result = num1 * num2;
                        break;
            case "/": result = num1 / num2;
                        break;
            default: System.out.println("Incorrect input. ");
        }
        return result;
    }
}
