import java.util.Scanner;

public class HexagonArea {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        double side = 0,
                area = 0;
        
        System.out.print("Enter side length: ");
        side = input.nextDouble();
        
        area = ((3.0 * Math.pow(3.0, 1/2.0)) / 2.0) * side * side;
        
        System.out.println("The area of hexagon is " + area);
    }
}
