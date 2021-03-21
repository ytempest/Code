package com.ytempest.code.math;

/**
 * @author heqidu
 * @since 2021/3/21
 * <p>
 * 统计所有小于非负整数 n 的质数的数量。
 */
class LC_Math_2 {
    public static void main(String[] args) {
        System.out.println(countPrimes(2));
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrimes(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
