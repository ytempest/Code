package com.ytempest.code.array;

import java.util.Arrays;

/**
 * @author heqidu
 * @since 2021/3/2
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
class LC_8 {
    public static void main(String[] args) {
        int[] nums1 = {1, 4, 0, 0, 7, 0, 0, 9, 0};
        int[] nums2 = {0, 0, 1, 4, 0};
        moveZeroes(nums1);
        moveZeroes(nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    /**
     * 双指针法，一个指针指向0，一个指针正常遍历
     */
    public static void moveZeroes(int[] nums) {
        // 只指向0的指针
        int zeroPoint = -1;
        for (int i = 0; i < nums.length; i++) {
            // 首次初始化0指针
            if (zeroPoint == -1 && nums[i] == 0) {
                zeroPoint = i;
            }

            // 当存在0的数字时，同时当前的数字不为0，那么交换位置，然后移动0指针
            if (zeroPoint != -1 && nums[i] != 0) {
                nums[zeroPoint] = nums[i];
                nums[i] = 0;
                zeroPoint++;
            }
        }
    }
}