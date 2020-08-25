import java.util.Scanner;
public class BMI {
    public static void main(String[] args){
        
        Scanner input =  new Scanner(System.in);
        
        System.out.print("Enter weight, feet, and inches: ");
        
        double kg = 0;
        double m = 0;
        double totalInches = 0;
        
        double weight = input.nextDouble();
        double feet = input.nextDouble();
        double inches = input.nextDouble();
        
        double convertedInches = feet * 12;
        
        totalInches = inches + convertedInches;
        kg  = 0.45359237 * weight;
        m = 0.0254 * totalInches;
        
        double BMI = kg /(m * m);
        
            System.out.println("BMI is " + BMI);
        
        if(BMI<18.5)
            System.out.println("Underweight");
        else if(BMI <25.0)
            System.out.println("Normal");
        else if(BMI<30.0)
            System.out.println("Overweight");
        else
            System.out.println("Obese");
            
    }
}
