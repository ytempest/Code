package com.ytempest.code.daily;

import java.util.Arrays;

/**
 * @author heqidu
 * @since 2021/3/21
 * <p>
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
class LC_Daily_1 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        print(matrix);
        setZeroes(matrix);
        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int[] array = matrix[i];
            for (int k = 0; k < array.length; k++) {
                if (matrix[i][k] == 0) {
                    row[i] = col[k] = true;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
