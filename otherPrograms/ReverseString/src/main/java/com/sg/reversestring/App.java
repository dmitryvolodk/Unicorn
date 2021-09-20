package com.sg.reversestring;

public class App {
    public static void main(String[] args){
        ReverseString reverseString = new ReverseString();
        
        char[] s = {'h','e','l','l','o'};
        
        reverseString.reverseString(s);
        
        for(int i = 0; i < s.length; i++){
            System.out.print(s[i]);
        }
    }
}
