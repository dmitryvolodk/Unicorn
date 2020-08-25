import java.util.Scanner;

public class CelsiusFahrenheit {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        double fahrenheit = 0;
        double celsius = 0;
        
        System.out.println("Enter a degree in Celsius: ");
        celsius = input.nextDouble();
        
        fahrenheit = (9.0/5) * celsius + 32;
        System.out.println(celsius + " Celsius is " + fahrenheit + " Fahrenheit");
    }
}
