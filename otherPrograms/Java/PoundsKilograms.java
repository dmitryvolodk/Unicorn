import java.util.Scanner;

public class PoundsKilograms {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        double pounds, kilograms;
        final double PKUnit = 0.454;
        
        System.out.print("Enter a number in pounds: ");
        pounds  = input.nextDouble();
        
        kilograms = pounds * PKUnit;
        
        System.out.println(pounds + " pounds is " + kilograms + " kilograms");
    }
}
