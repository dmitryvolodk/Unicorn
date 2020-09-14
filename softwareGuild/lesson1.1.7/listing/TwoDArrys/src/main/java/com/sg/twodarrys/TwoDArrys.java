package com.sg.twodarrys;

public class TwoDArrys {
    public static void main(String[] args){
                String[][] cityTeamNames = {
            {"Cleveland", "Browns", "Cavs", "Indians"},
            {"Columbus", "Bluejackets", "Buckeyes"},
            {"Pittsburgh", "Steelers", "Pirates"}
        };
        
        for(int i = 0; i < cityTeamNames.length; i++){
            for(int j = 0; j < cityTeamNames.length; j++){
                System.out.print(cityTeamNames[i][j] + " ");
            }
            System.out.println();
        }
    }
}
