import java.util.Scanner;

public class SumIntegerDigits {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        int number, digit1, digit2, digit3, sum;
        
        System.out.print("Enter a number between 0 and 1000:");
        
        number = input.nextInt();
        
        digit1 = number % 10;
        digit2 = (number / 10) % 10;
        digit3 = (number / 100) % 10;
        
        sum = digit1 + digit2 + digit3;
        
        System.out.println("The sum of the digits is " + sum);
    }
}
