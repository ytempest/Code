package com.ytempest.code.array;

import java.util.Arrays;

/**
 * @author heqidu
 * @since 2021/3/2
 * <p>
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
class LC_11 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        print(matrix);
        rotate(matrix);
        print(matrix);
    }

    public static void print(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

    public static void rotate(int[][] matrix) {
        // 对角线翻转
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 0; col < row + 1; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }

        // 水平翻转
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length / 2; col++) {
                int tmp = matrix[row][col];
                int lastCol = matrix[row].length - 1 - col;
                matrix[row][col] = matrix[row][lastCol];
                matrix[row][lastCol] = tmp;
            }
        }
    }
}