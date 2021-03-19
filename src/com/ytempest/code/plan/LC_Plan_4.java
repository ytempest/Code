package com.ytempest.code.plan;

import java.util.Random;

/**
 * @author heqidu
 * @since 2021/3/19
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6
 */
class LC_Plan_4 {
    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob(array));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums[0];
        }

        // 不偷窃第 k 间房屋，偷窃总金额为前 k−1间房屋的最高总金额
        int first = nums[0];
        // 偷窃第 k 间房屋，那么就不能偷窃第 k−1 间房屋，偷窃总金额为前 k−2 间房屋的最高总金额与第 k 间房屋的金额之和。
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return Math.max(first, second);
    }
}