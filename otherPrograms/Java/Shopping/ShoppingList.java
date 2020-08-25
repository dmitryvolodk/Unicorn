public class ShoppingList {
    // Declare and initialize variables
    private final int SIZE = 7;
    private Item[] itemList = new Item[SIZE];
    private int numOfItems;
    private int[] priorityList = new int[SIZE];
    private double purchaseMoney = 59.0;
    private int purchaseItemCount = 0;
    private double totalPriceOfAllItems = 0.0;
    
    private String shoppingListName = "Violette's Shopping List";
    
    // Constructor for shopping list object
    public ShoppingList(String shoppingListName){
        this.shoppingListName = shoppingListName;
    }
    
    // Method to add item objects to the shopping list object
    public void addIt(Item it){
        itemList[numOfItems] = it;
        numOfItems++;
    }
    
    // Method to calculate the total price of all items on the shopping list
    public double getTotalPriceOfAllItems(Item[] itemList){
         for(int l = 0; l < SIZE; l++){
        totalPriceOfAllItems = totalPriceOfAllItems + itemList[l].getItemPrice();
        }
        return totalPriceOfAllItems;
    }
    
    // Method to get the number of items.
    public int getNumOfItems(){
        return numOfItems;
    }
    
    // Method to get the items on the list.
    public Item[] getIts(){
        return itemList;
    }
    
    // The method to get the name of the shopping list.
    public String getShoppingListName() {
        return shoppingListName;
    }
    
    // Copy the priorities from the objects to the arrays for sorting purpose.
    public int[] copyPrioritiesToArray(Item[] itemList){
        for(int l = 0; l < numOfItems; l++){
            priorityList[l] = itemList[l].getItemPriority();
        }
        return priorityList;
    }
    
    // Method to sort the objects of items by the priority.
    public void bubbleSortPrioritiesPrices(int[] priorityList){
        boolean needNextPass = true;
        for (int k = 1; k < priorityList.length && needNextPass; k++) {
        // Array may be sorted and next pass not needed
        needNextPass = false;
        for (int i = 0; i < priorityList.length - k; i++) {
        if (priorityList[i] > priorityList[i + 1]) {
        // Swap priorityList[i] with priorityList[i + 1]
        int tempPriority = priorityList[i];
        Item tempItem = itemList[i];
        
        priorityList[i] = priorityList[i + 1];
        itemList[i] = itemList[i + 1];
        
        priorityList[i + 1] = tempPriority;
        itemList[i + 1] = tempItem;

        needNextPass = true; // Next pass still needed
        }
        }
        }
        }    
    
    // Method to make purchase
    public void purchase(Item[] itemList){
        while(purchaseMoney >= itemList[purchaseItemCount].getItemPrice()){
        purchaseMoney = purchaseMoney - itemList[purchaseItemCount].getItemPrice();
        purchaseItemCount++;
        }
    }
    
    // Method to get the number of purchased items.
        public int getNumOfPurchasedItems(){
        return purchaseItemCount;
    }
        
        // Method to get the remaining purchased money.
        public double getRemainingPurchaseMoney(){
        return purchaseMoney;
    }
        
        // Method to display the purchase summary on the screen.
        public void printPurchaseSummary(Item[] itemList){
            System.out.println("Items purchased:");
            for(int e = 0; e < purchaseItemCount; e++){
                System.out.println(itemList[e].getItemName() + " for $" + itemList[e].getItemPrice());
            }
            System.out.println("Items not purchased:");
            for(int e = purchaseItemCount; e < itemList.length; e++){
                System.out.println(itemList[e].getItemName() + " for $" + itemList[e].getItemPrice());
            }
        }

    
}
