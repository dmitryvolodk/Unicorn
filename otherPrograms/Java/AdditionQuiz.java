
import java.util.Scanner;

public class AdditionQuiz {
    public static void main(String[] args){
        int num1, num2, num3, answer;
        
        Scanner input = new Scanner(System.in);
        
        num1 = (int)(System.currentTimeMillis() % 10);
        num2 = (int)(System.currentTimeMillis() / 10 % 10);
        num3 = (int)(System.currentTimeMillis() / 100 % 10);
        
        System.out.println("How much is " + num1 + " + " + num2 + " + " + num3);
        
        answer = input.nextInt();
        
        System.out.println("Answer: " + num1 + " + " + num2 + " + " + num3 + " is " + (num1 + num2 + num3 == answer));
        
      
    }
}
