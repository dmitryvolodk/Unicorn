// Display 5 welcome messages
import java.util.Scanner;

public class Welcome {
    public static void main(String[] args){
      
       
        char letter;
        
        Scanner input = new Scanner (System.in);
        
        System.out.print("Please enter your first name: ");
        
        String firstName = input.next();
        
        int j = 0;
        int l = firstName.length();
        
        while(j < l ){
        letter = firstName.charAt(j);
        while (!(letter >= 'A' && letter <= 'Z') && !(letter >= 'a' && letter <= 'z')){
             System.out.println("Your first name \"" + firstName + "\" is wrong");
             System.out.print("Reenter any characters between A & Z or a & z: ");
             firstName = input.next(); 
             while (firstName.length() != l){
                 System.out.print("Reenter with the original name length of " + l + " characters: ");
                 firstName = input.next(); 
             }
             letter = firstName.charAt(j);
             j = -1;
        }
        j++;
        }
        
        System.out.println();
        
        System.out.println("You entered the first name \"" + firstName + "\"");
        
    }
    
}
