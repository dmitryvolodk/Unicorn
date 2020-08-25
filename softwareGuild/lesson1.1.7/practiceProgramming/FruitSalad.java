package com.sg.fruitsalad;

public class FruitSalad {
    public static void main(String[] args){
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", 
            "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", 
            "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  
            "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", 
            "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", 
            "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
        
        String[] fruitSalad;
        fruitSalad = new String[12];
        
        int j = 0,
            applesForSalad = 0,
            orangesForSalad = 0,
            berriesForSalad = 0,
            otherFruitsForSalad = 0;
        
        for(int i = 0; i < fruit.length; i++){
            if(fruit[i].contains(" Apple") && applesForSalad < 3){
                fruitSalad[j] = fruit[i];
                j++;
                applesForSalad++;
            } else if(fruit[i].contains("Orange") && orangesForSalad < 2){
                fruitSalad[j] = fruit[i];
                j++;
                orangesForSalad++;
            } else if(fruit[i].contains("berry") && (applesForSalad + orangesForSalad + berriesForSalad) < 12){
                fruitSalad[j] = fruit[i];
                j++;
                berriesForSalad++;
            } 
        }
        
        for(int i = 0; i < fruit.length; i++){
            if(!(fruit[i].contains("berry") && fruit[i].contains(" Apple") && fruit[i].contains("Orange") && fruit[i].contains("Tomato")) && (otherFruitsForSalad + applesForSalad + orangesForSalad + berriesForSalad) < 12){
                fruitSalad[j] = fruit[i];
                j++;
                otherFruitsForSalad++;
            }
        }
        
        System.out.println("Total fruits in the salad: " + fruitSalad.length + "\n");
        System.out.println("Our salad includes: ");
        
        for(j = 0; j < fruitSalad.length; j++){
            System.out.println(fruitSalad[j]);
        }
    }
}
