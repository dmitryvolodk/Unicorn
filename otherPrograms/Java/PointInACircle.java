import java.util.Scanner;

public class PointInACircle {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        final double radius = 10;
        
        System.out.print("Please enter point via space(x,y): ");
        double x = input.nextDouble();
        double y = input.nextDouble();
        
        double distance = Math.pow(x * x + y * y, 0.5);
        
        if(distance <= radius)
        System.out.println("Point (" + x + ", " + y + ") is in the circle");
        else
        System.out.println("Point (" + x + ", " + y + ") is not in the circle");
                
    }
    
}
