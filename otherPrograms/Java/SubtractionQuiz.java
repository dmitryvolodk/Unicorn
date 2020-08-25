import java.util.Scanner;

public class SubtractionQuiz {
    public static void main(String[] args){
        int number1 = 0;
        int number2 = 0;
        int temp = 0;
        int studentGuess = 0;
        
        Scanner myScanner = new Scanner(System.in);
        
        number1 = (int)(Math.random() * 100);
        number2 = (int)(Math.random() * 100);
        
        System.out.print("What is " + number1 + " + " + number2 + ": ");
        studentGuess = myScanner.nextInt();
        
        if(studentGuess == number1 + number2)
            System.out.println("Correct!");
        else{
            System.out.println("Incorrect!");
            System.out.println(number1 + " + " + number2 + " should be " + (number1 + number2));
        }
    }
}
