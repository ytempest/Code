package com.ytempest.code.plan;

/**
 * @author heqidu
 * @since 2021/3/19
 * 爬楼梯，即斐波那契数列
 */
class LC_Plan_1 {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }


    public static int climbStairs(int n) {
        if (n <= 0) {
            return 1;
        }

        int[] array = new int[n + 1];
        array[0] = array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}
