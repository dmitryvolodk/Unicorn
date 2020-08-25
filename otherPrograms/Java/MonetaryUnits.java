import java.util.Scanner;

public class MonetaryUnits {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        int pennies = 0,
                nikels = 0,
                dimes = 0,
                quarters = 0,
                dollars = 0,
                leftover = 0;
        
        System.out.print("Enter coins amount: ");
        leftover = input.nextInt();
        
        dollars = leftover / 100;
        leftover = leftover % 100;
        
        
        quarters = leftover / 25;
        leftover = leftover % 25;
        
        dimes = leftover / 10;
        leftover = leftover % 10;
        
        nikels = leftover / 5;
        pennies = leftover % 5;
        
        System.out.println("Dollars: " + dollars + "\nQuarters: " + quarters + "\nDimes: " + dimes 
                + "\nNikels: " + nikels +"\nPennies: " + pennies);
    }
    
}
