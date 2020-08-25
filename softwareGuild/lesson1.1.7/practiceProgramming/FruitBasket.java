package com.sg.fruitbasket;

public class FruitBasket {
    public static void main(String[] args){
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", 
            "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", 
            "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", 
            "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", 
            "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", 
            "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", 
            "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", 
            "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", 
            "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
        
        int orangesAmt = 0;
        int applesAmt = 0;
        
        for(int i = 0; i < fruit.length; i++){
            if(fruit[i].equals("Orange")){
                orangesAmt++;
            } else if (fruit[i].equals("Apple")){
                applesAmt++;
            } else {
                System.out.println("Unknown fruit...");
            }
        }
        
        String[] oranges = new String[orangesAmt];
        String[] apples = new String[applesAmt];
        
        int j = 0;
        int k = 0;
        
        for(int i  = 0; i < fruit.length; i++){
            if(fruit[i].equals("Apple")){
                apples[j] = fruit[i];
                j++;
            } else if(fruit[i].equals("Orange")){
                oranges[k] = fruit[i];
                k++;
            } else {
                System.out.println("Unknown fruit...");
            }
        }
        
        System.out.println("Total# of Fruit in Basket: " + (j + k));
        System.out.println("Number of Applese: " + j);
        System.out.println("Number of Oranges: " + k);
    }
}
