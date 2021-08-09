package com.sg.besttimebuysellstockii;

public class ProfitStock {
    public int buySell(int[] prices){
        int profit = 0;
        
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                int increment = prices[i] - prices[i-1];
                profit = profit + increment;
            }
        }
        
        return profit;
    }
}
