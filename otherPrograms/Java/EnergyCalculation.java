import java.util.Scanner;

public class EnergyCalculation {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        double M = 0,
        finalTemperature = 0,
        initialTemperature = 0,
                Q = 0;
        
        System.out.print("Enter the amount of water in kilograms: ");
        M = input.nextDouble();
        
        System.out.print("Enter the initial temperature: ");
        initialTemperature = input.nextDouble();

        System.out.print("Enter the final temperature: ");
        finalTemperature = input.nextDouble();
        
        Q = M * (finalTemperature - initialTemperature) * 4184;
        
        System.out.println("The energy needed is " + Q);
    }
}
