import java.util.Scanner;

public class WindChillTemperature {
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter temperature in Fahrenheit: ");
    double temperature = input.nextDouble();
    
    System.out.print("Enter wind speed: ");
    double speed = input.nextDouble();
    
    if(temperature < -58 || temperature > 41)
    System.out.println("The temperature is invalid.");
    if(speed < 2)
    System.out.println("The speed is invalid.");
    if(temperature >= -58 && temperature <= 41 && speed >= 2){
        double temperatureWC = 35.74 + 0.6215 * temperature - 35.75 * Math.pow(speed, 0.16) + 0.4275 * temperature * Math.pow(speed, 0.16);
    System.out.println("The wind-chill temperature is " + temperatureWC);
    }
    }
}
