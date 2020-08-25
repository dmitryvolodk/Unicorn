import java.util.Scanner;

public class PointOnLineSegment {
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
        
        if(number == 0){
            if((x0 < x1) && (y0 < y1)){
                if((x2 > x0) && (x2 < x1))
                    System.out.println("(" + x2 + ", " + y2 + ")" + " is on the line segment from " + "(" + x0 + ", " + y0 + ")" + " to " + "(" + x1 + ", " + y1 + ")");
                else
                    System.out.println("(" + x2 + ", " + y2 + ")" + " is not on the line segment from " + "(" + x0 + ", " + y0 + ")" + " to " + "(" + x1 + ", " + y1 + ")");
            }else if((x1 < x0) && (y1 < y0)){
                if((x2 > x1) && (x2 < x0))
                    System.out.println("(" + x2 + ", " + y2 + ")" + " is on the line segment from " + "(" + x0 + ", " + y0 + ")" + " to " + "(" + x1 + ", " + y1 + ")");
                else
                    System.out.println("(" + x2 + ", " + y2 + ")" + " is not on the line segment from " + "(" + x0 + ", " + y0 + ")" + " to " + "(" + x1 + ", " + y1 + ")");
            }else if((x1 < x0) && (y0 < y1)){
                if((x2 > x1) && (x2 < x0))
                    System.out.println("(" + x2 + ", " + y2 + ")" + " is on the line segment from " + "(" + x0 + ", " + y0 + ")" + " to " + "(" + x1 + ", " + y1 + ")");
                else
                    System.out.println("(" + x2 + ", " + y2 + ")" + " is not on the line segment from " + "(" + x0 + ", " + y0 + ")" + " to " + "(" + x1 + ", " + y1 + ")");
            }else if((x0 < x1) && (y1 < y0)){
                if((x2 > x0) && (x2 < x1))
            System.out.println("(" + x2 + ", " + y2 + ")" + " is on the line segment from " + "(" + x0 + ", " + y0 + ")" + " to " + "(" + x1 + ", " + y1 + ")");
                else
                    System.out.println("(" + x2 + ", " + y2 + ")" + " is not on the line segment from " + "(" + x0 + ", " + y0 + ")" + " to " + "(" + x1 + ", " + y1 + ")");
            }
        }else
            System.out.println("(" + x2 + ", " + y2 + ")" + " is not on the line segment from " + "(" + x0 + ", " + y0 + ")" + " to " + "(" + x1 + ", " + y1 + ")");
    }
}