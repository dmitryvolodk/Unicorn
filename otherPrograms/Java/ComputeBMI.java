import java.util.Scanner;

public class ComputeBMI {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        double weight = 0,
                height = 0,
                BMI = 0;
        
        System.out.print("Enter weight in pounds & height in inches: ");
        weight = input.nextDouble();
        height = input.nextDouble();
        
        weight = weight * 0.45359237;
        height = height * 0.0254;
        
        BMI = weight /(height * height);
        
        System.out.println("BMI is " + BMI);
    }
}
