package com.ytempest.code.plan;

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
class LC_Plan_3 {
    public static void main(String[] args) {
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(array));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int currentSum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 这里判断是选择一个新的数作为开始，还是继续加上这个数
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            max = Math.max(currentSum, max);
        }
        return max;
    }
}