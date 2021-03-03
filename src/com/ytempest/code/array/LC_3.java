package com.ytempest.code.array;

import java.util.Arrays;

/**
 * @author heqidu
 * @since 2021/3/2
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 */
class LC_3 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        int[] first = nums.clone();
        rotate(first, 3);
        System.out.println(Arrays.toString(first));

        int[] second = nums.clone();
        rotatePro(second, 3);
        System.out.println(Arrays.toString(second));

        int[] third = nums.clone();
        rotateVip(third, 10);
        System.out.println(Arrays.toString(third));


    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = Math.abs(k % len);
        int divider = Math.abs(len - k);
        for (int i = 0; i < divider / 2; i++) {
            int changeIdx = divider - i - 1;
            int tmp = nums[i];
            nums[i] = nums[changeIdx];
            nums[changeIdx] = tmp;
        }

        for (int i = 0; i < k / 2; i++) {
            int first = divider + i;
            int last = len - 1 - i;
            int tmp = nums[first];
            nums[first] = nums[last];
            nums[last] = tmp;
        }

        for (int i = 0; i < len / 2; i++) {
            int changeIdx = len - i - 1;
            int tmp = nums[i];
            nums[i] = nums[changeIdx];
            nums[changeIdx] = tmp;
        }
    }

    public static void rotatePro(int[] nums, int k) {
        k %= nums.length;
        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums, i, nums.length - 1 - i);
        }

        for (int i = 0; i < k / 2; i++) {
            swap(nums, i, k - 1 - i);
        }

        for (int i = 0; i < (nums.length - k) / 2; i++) {
            swap(nums, i + k, nums.length - 1 - i);
        }
    }

    public static void swap(int[] nums, int left, int right) {
        nums[left] = nums[left] ^ nums[right];
        nums[right] = nums[left] ^ nums[right];
        nums[left] = nums[left] ^ nums[right];
    }

    public static void rotateVip(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] = nums[start] ^ nums[end];
            nums[end] = nums[start] ^ nums[end];
            nums[start] = nums[start] ^ nums[end];
            start++;
            end--;
        }
    }
}