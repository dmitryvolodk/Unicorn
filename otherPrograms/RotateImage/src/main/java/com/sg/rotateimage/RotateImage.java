package com.sg.rotateimage;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int temp = 0;
        int n = matrix.length;
        
        for(int i = 0; i < n/2; i++){
            for(int j = i; j < n-i-1; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
}
