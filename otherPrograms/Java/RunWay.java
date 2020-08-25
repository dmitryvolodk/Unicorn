import java.util.Scanner;

public class RunWay {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        double speed = 0,
                acceleration = 0,
                runWay = 0;
        
        System.out.print("Enter speed and acceleration: ");
        speed = input.nextDouble();
        acceleration = input.nextDouble();
        
        runWay = speed * speed / (2 * acceleration);
        
        System.out.println("Runway is " + runWay);
    }
    
}
