package com.sg.besttimebuysellstockii;

public class App {
    public static void main(String[] args){
        ProfitStock profitStock = new ProfitStock();
        int profit = 0;
        int[] prices = {7,6,4,3,1};
        
        profit = profitStock.buySell(prices);
        
        System.out.print(profit);
    }
}
