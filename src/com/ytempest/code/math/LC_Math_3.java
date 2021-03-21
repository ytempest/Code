package com.ytempest.code.math;

/**
 * @author heqidu
 * @since 2021/3/21
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 */
class LC_Math_3 {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(2147483647));
        System.out.println(isPowerOfThree(9));

        System.out.println(isPowerOfThreeStrange(2147483647));
        System.out.println(isPowerOfThreeStrange(9));
    }

    public static boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    public static boolean isPowerOfThreeStrange(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
