package com.sg.validsudoku;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean isValid = true;

        for (int i = 0; i < board.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int num = Character.getNumericValue(board[i][j]);
                    if (num < 1 || num > 9) {
                        return false;
                    }
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }
            for (int value : map.values()) {
                if (value >= 2) {
                    return false;
                }
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.') {
                    int num = Character.getNumericValue(board[i][j]);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }
            for (int value : map.values()) {
                if (value >= 2) {
                    return false;
                }
            }
        }

        for (int l = 0; l < board.length; l += 3) {
            for (int g = 0; g < board[0].length; g += 3) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int i = l; i < (board.length / 3) + l; i++) {
                    for (int j = g; j < (board[i].length / 3) + g; j++) {
                        if (board[i][j] != '.') {
                            int num = Character.getNumericValue(board[i][j]);
                            map.put(num, map.getOrDefault(num, 0) + 1);
                        }
                    }
                }
                for (int value : map.values()) {
                    if (value >= 2) {
                        return false;
                    }
                }
            }
        }

        return isValid;
    }
}
