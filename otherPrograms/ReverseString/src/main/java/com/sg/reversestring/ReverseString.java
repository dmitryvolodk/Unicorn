package com.sg.reversestring;

public class ReverseString {
    public void reverseString(char[] s){
        char temp = 'p';
        int n = s.length;
        for(int i = 0; i < n/2; i++){
            temp = s[i];
            s[i] = s[n-i-1];
            s[n-i-1] = temp;
        }
    }
}
