package com.sg.twoelementssum;

public class App {

    public static void main(String[] args) {
        TwoElementsSum twoElementsSum = new TwoElementsSum();
        int[] examplArray = {-3,4,3,90};
        int target = 0;

        int[] result = twoElementsSum.twoSum(examplArray, target);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }
}
