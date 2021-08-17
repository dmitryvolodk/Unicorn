package com.sg.singlenumberary;

public class App {
    public static void main(String[] args){
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {4,1,2,1,2};
        
        int num = singleNumber.singleNum(nums);
        
        System.out.println(num);
    }
}
