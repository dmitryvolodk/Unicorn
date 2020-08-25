import java.util.Scanner;

public class HeadsTails {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        int randomNumber = (int)(Math.random() * 2);
        
        System.out.print("Guess if it's head or tail (click 0 or 1): ");
        int guess = input.nextInt();
        
        if(randomNumber == guess)
        System.out.print("Correct answer!");
        else
        System.out.print("Incorrect answer.");
        
        
    }
}
