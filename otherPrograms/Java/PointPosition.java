import java.util.Scanner;

public class PointPosition {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter p0(x,y), p1(x,y), p2(x,y): ");
        double x0 = input.nextDouble();
        double y0 = input.nextDouble();
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        
        double number = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        
        if(number > 0)
            System.out.println("p2 is on the left side of the line");
        else if(number == 0)
            System.out.println("p2 is on the same line");
        else
            System.out.println("p2 is on the right side of the line");
    }
}
