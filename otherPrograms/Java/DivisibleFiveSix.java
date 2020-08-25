import java.util.Scanner;
    
public class DivisibleFiveSix {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        final int number5 = 5;
        final int number6 = 6;
        
        System.out.print("Enter integer: ");
        int number = input.nextInt();
        
        System.out.println("Is " + number + " divisible by 5 and 6? " + ((number % number5 == 0) && (number % number6 == 0)));
        System.out.println("Is " + number + " divisible by 5 or 6? " + ((number % number5 == 0) || (number % number6 == 0)));
        System.out.println("Is " + number + " divisible by 5 or 6, but not both? " + ((number % number5 == 0) ^ (number % number6 == 0)));
    }
}
