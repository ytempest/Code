package com.ytempest.code.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heqidu
 * @since 2021/3/2
 * <p>
 * 判断一个9x9的数独是否有效
 */
class LC_9 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };


        boolean validSudoku = isValidSudoku(board);
        System.out.println(validSudoku);
    }


    public static boolean isValidSudoku(char[][] board) {
        Map<Character, Integer> map = new HashMap<>();
        int version = 1;
        for (int i = 0; i < 9; i++) {
            version++;
            for (int col = 0; col < 9; col++) {
                char target = board[i][col];
                if (isHit(map, target, version)) {
                    return false;
                }
            }

            version++;
            for (int row = 0; row < 9; row++) {
                char target = board[row][i];
                if (isHit(map, target, version)) {
                    return false;
                }
            }

            version++;
            int rowStart = i / 3 * 3;
            int colStart = (i % 3) * 3;
            for (int row = rowStart; row < rowStart + 3; row++) {
                for (int col = colStart; col < colStart + 3; col++) {
                    char target = board[row][col];
                    if (isHit(map, target, version)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isHit(Map<Character, Integer> map, char target, int version) {
        if (target == '.') return false;
        if (map.getOrDefault(target, -1) == version) {
            return true;
        } else {
            map.put(target, version);
        }
        return false;
    }
}