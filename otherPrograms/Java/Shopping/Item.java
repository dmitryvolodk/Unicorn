import java.util.Scanner;

public class Item {
    Scanner input = new Scanner(System.in);
    // Declare variables
    private String itemName;
    private double itemPrice;
    private int itemPriority;
    
    // Constractor of Item class
    public Item(){
    }
    
    // Prompt and read the item name from the user
    public void promptForItemName(){
    System.out.print("Enter name: ");
    itemName = input.next();        
    }
    
    // Prompt and read the price and priority of the item from the user.
    public void promptForItemPriceAndPriority(){
    System.out.print("Enter price: ");
    itemPrice = input.nextDouble();
    // Set the total of all prices > $100.0
    while(itemPrice < 15.0){
        System.out.print("Reenter price >= $15.0: ");
        itemPrice = input.nextDouble();
    }
    System.out.print("Enter priority: ");
    itemPriority = input.nextInt();
    }
    
    // Get an item name
    public String getItemName(){
        return itemName;
    }
    
    // Get an item price
    public double getItemPrice(){
        return itemPrice;
    }
    
    //Get a priority for the item
    public int getItemPriority(){
        return itemPriority;
    }
}
