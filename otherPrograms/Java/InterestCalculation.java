import java.util.Scanner;

public class InterestCalculation {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double iRate = 0,
                balance = 0,
                interest = 0;
        
        System.out.print("Enter balance and interest rate (e.g., 3 for 3%): ");
        iRate = input.nextDouble();
        balance = input.nextDouble();
        
        interest = balance * (iRate / 1200);
        
        System.out.println("The interest is " + interest);
    }
    
}
