package com.sg.rotateimage;

public class App {
    public static void main(String[] args){
        RotateImage rotateImage = new RotateImage();
        
        int[][] matrix = {
            {5,1,9,11},
            {2,4,8,10},
            {13,3,6,7},
            {15,14,12,16}
        };
        
        rotateImage.rotate(matrix);
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + "|");
            }
            System.out.println();
        }
    }
}
