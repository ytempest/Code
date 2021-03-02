package com.ytempest.code.array;

import java.util.Arrays;

/**
 * @author heqidu
 * @since 2021/3/2
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 */
class LC_7 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 4})));

        System.out.println(Arrays.toString(plusOnePro(new int[]{9, 9})));
        System.out.println(Arrays.toString(plusOnePro(new int[]{1, 4})));
    }

    public static int[] plusOne(int[] digits) {
        int newLen = digits.length;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] < 9) {
                break;
            } else if (i == digits.length - 1) {
                newLen = digits.length + 1;
            }
        }
        int[] newDigits = new int[newLen];
        for (int i = digits.length - 1, k = newDigits.length - 1; i >= 0 && k >= 0; i--, k--) {
            newDigits[k] = digits[i];
        }
        int up = 1;
        for (int i = newDigits.length - 1; i >= 0; i--) {
            int result = newDigits[i] + up;
            up = result / 10;
            newDigits[i] = result % 10;
        }
        return newDigits;
    }

    public static int[] plusOnePro(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
