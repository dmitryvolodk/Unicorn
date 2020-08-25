package com.sg.forbyfor;

public class ForByFor {
public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            System.out.print("|");

            if(i == 0 || i == 2){
            
                for(int j = 0; j < 3; j++){
                    if(j == 0 || j == 2){
                        for (int k = 0; k < 3; k++) {
                            System.out.print("*");
                        }
                        System.out.print("|");
                    } else {
                        System.out.print("|");
                        for (int k = 0; k < 3; k++) {
                            System.out.print("$");
                        }
                        System.out.print("|");
                    }
                }    
                System.out.println("");
            
            } else {
                
                for(int j = 0; j < 3; j++){
                    if(j == 0 || j == 2){
                        for (int k = 0; k < 3; k++) {
                            System.out.print("@");
                        }
                        System.out.print("|");
                    } else {
                        System.out.print("|");
                        for (int k = 0; k < 3; k++) {
                            System.out.print("#");
                        }
                        System.out.print("|");
                    }
                }    
                System.out.println("");
                
            }
            
        }
    }
}
