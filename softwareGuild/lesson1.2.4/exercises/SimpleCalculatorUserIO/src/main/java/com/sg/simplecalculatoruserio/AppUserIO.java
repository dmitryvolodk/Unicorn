package com.sg.simplecalculatoruserio;

public class AppUserIO {

    public static void main(String[] args) {
        SimpleCalculatorUserIO myCalculator = new SimpleCalculatorUserIO();
        UserIOInterface myUserIO = new UserIO();

        float number1 = 0,
                number2 = 0;
        String number1String = "",
                number2String = "";
        String operation = "n";
        String prompt = "Choose \'exit\' to exit or an operation to perform (\'+\' or \'-\' or \'*\' or  \'/\'):";
        String promptNum1 = "Enter num1:";
        String promptNum2 = "Enter num2:";
        String messageBye = "Good bye!";
        
        do {
            operation = myUserIO.readString(prompt);

            if (operation.equals("exit")) {
                break;
            }
                number1String = myUserIO.readString(promptNum1);
                number2String = myUserIO.readString(promptNum2);
                
                number1 = Float.parseFloat(number1String);
                number2 = Float.parseFloat(number2String);

                System.out.println("The result is " + myCalculator.calculate(number1, number2, operation));
            
        } while (!(operation.equals("exit")));

        myUserIO.print(messageBye);
    }
}
