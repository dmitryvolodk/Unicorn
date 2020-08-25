import java.util.Scanner;

public class TwoRectangles {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter x,y,width,height for rectangle #1: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double w1 = input.nextDouble();
        double h1 = input.nextDouble();
        System.out.print("Enter x,y,width,height for rectangle #2: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double w2 = input.nextDouble();
        double h2 = input.nextDouble();
        
        // r2 is inside r1
        if(((x2 - w2/2) >= (x1 - w1/2)) && ((x2 + w2/2) <= (x1 + w1/2)) && ((y2 - h2/2) >= (y1 - h1/2)) && ((y2 + h2/2) <= (y1 + h1/2)))
            System.out.println("r2 is inside r1");
        
        // (when right coners of r2 are in the 1st half of r1) - overlaps rectangle.
        if(((x2 - w2/2) < (x1 - w1/2)) && ((x2 + w2/2) > (x1 - w1/2))){
            if((((y2 - h2/2) < (y1 + h1/2)) && ((y2 - h2/2) > (y1 - h1/2))) || (((y2 + h2/2) < (y1 + h1/2)) && ((y2 + h2/2) > (y1 - h1/2)))){
                System.out.print("r2 overlaps r1");
            }
        }
        // (when left coners of r2 are in the 2nd half of r1) - overlaps rectangle.
        if(((x2 - w2/2) < (x1 + w1/2)) && ((x2 + w2/2) > (x1 + w1/2))){
            if((((y2 - h2/2) < (y1 + h1/2)) && ((y2 - h2/2) > (y1 - h1/2))) || (((y2 + h2/2) < (y1 + h1/2)) && ((y2 + h2/2) > (y1 - h1/2)))){
                System.out.print("r2 overlaps r1");
            }
        }
        // When r2 does not overlap r1
        if(((x2 + w2/2) < (x1 - w1/2)) || ((x2 - w2/2) > (x1 + w1/2)) || ((y2 + h2/2) < (y1 - h1/2)) || ((y2 - h2/2) > (y1 + h1/2))){
                System.out.print("r2 does not overlaps r1");
        }
    }
}
