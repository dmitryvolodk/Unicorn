public class TestShoppingList {
    public static void main(String[] args){
        
        // Instanciate the shopping list object.
        ShoppingList shoppingList = new ShoppingList("Shopping List");
        
        // Instanciate the objects of items.
        Item[] items = new Item[7];
       for(int a = 0; a < items.length; a++){
        items[a] = new Item() ;
       }
       
       // Adding item objects to the shopping list object.
       for(int b = 0; b < items.length; b++){
        shoppingList.addIt(items[b]);
       }
       
       // Prompt the user for the item names (check for duplicates), priorities, prices.
       for(int c = 0; c < items.length; c++){
        items[c].promptForItemName();
        if(c != 0){
        for(int a = 0; a < shoppingList.getNumOfItems(); a++ ){
            while(((items[c].getItemName()).equals(items[a].getItemName())) && (c != a)){
                System.out.println("Duplicate entry, reenter.");
                items[c].promptForItemName();
            }
        }
        }
        items[c].promptForItemPriceAndPriority();
       }
       
        System.out.println();
       
       // Display the number of items on the shopping list.
        System.out.println("Number of items (objects) on shoppingList: " + shoppingList.getNumOfItems());
        
        // Initialize and array of item objects.
        Item[] its = shoppingList.getIts();
        // Initialize an array of priorities.
       int[] priorities = shoppingList.copyPrioritiesToArray(items);
       
        System.out.println();
       
       // The list of items before sorting by the priority.
        for(int j = 0; j < shoppingList.getNumOfItems(); j++){
            System.out.println("Box" + (j + 1) + " has " + its[j].getItemName() + " $" + its[j].getItemPrice() + " has priority " + its[j].getItemPriority());
        }
        
        System.out.println();
        
        // Get the total price of all items on the shopping list.
        System.out.println("Total price of all items: $" + shoppingList.getTotalPriceOfAllItems(items));
        
        System.out.println();
        
        // Sorting the shopping list of item objects by the priority.
        shoppingList.bubbleSortPrioritiesPrices(priorities);
        
        System.out.println();
        
        // Display shopping list
        System.out.println("\n" + shoppingList.getShoppingListName());
        for(int d = 0; d < shoppingList.getNumOfItems(); d++){
            System.out.println("Box" + (d + 1) + " (after sorting object) has " + its[d].getItemName() + " $" + its[d].getItemPrice() + " has priority " + its[d].getItemPriority());
        }
        
        System.out.println();
        
        // Purchasing of items.
        System.out.println("Now, we are purchasing items by the priority as many as possible for $59.0:");
        shoppingList.purchase(its);
        
        // Display the purchas summary.
        System.out.println("Number of purchased items: " + shoppingList.getNumOfPurchasedItems() + "\nRemaining purchase money: " + shoppingList.getRemainingPurchaseMoney());
        shoppingList.printPurchaseSummary(its);
    }
}
