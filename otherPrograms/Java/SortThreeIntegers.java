import java.util.Scanner;

public class SortThreeIntegers {
    public static void main(String[] args){
        
        int temp = 0;
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter 3 intergers: ");
        int int1 = input.nextInt();
        int int2 = input.nextInt();
        int int3 = input.nextInt();
        
        if (int1 > int2){
            temp = int2;
            int2 = int1;
            int1 = temp;
        }
        if(int2 > int3){
            temp = int3;
            int3 = int2;
            int2 = temp;
        }
        if (int1 > int2){
            temp = int2;
            int2 = int1;
            int1 = temp;
        }
        
        System.out.println("Intergers: " + int1 + int2 + int3);
        
    }
        
}
