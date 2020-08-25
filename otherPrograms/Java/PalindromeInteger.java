import java.util.Scanner;

public class PalindromeInteger {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter 3 digits number to see if it's palindrom: ");
        int palindrom = input.nextInt();
        
        int number1 = palindrom / 100;
        System.out.println("Debagging: number1 is " + number1);
        int number2 = palindrom / 10 - number1 * 10;
        System.out.println("Debagging: number2 is " + number2);
        int number3 = palindrom - (palindrom / 10) * 10;
        System.out.println("Debagging: number3 is " + number3);
        
        if(number1 == number3){
        System.out.println("It's palindrom!");
        }else{
        System.out.println("It's not palindrom.");
        }
    }
}
