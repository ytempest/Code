package com.ytempest.code.array;

import java.util.Arrays;

/**
 * @author ytempest
 * @since 2021/3/3
 * <p>
 * 查询只出现一次的数字
 */
public class LC_5 {

    public static void main(String[] args) {
        int[] array = new int[]{4, 10, 3, 1, 3, 10, 1, 2, 2};
        System.out.println(Arrays.toString(array));
        System.out.println(singleNumber(array));
        System.out.println(singleNumberPro(array));
    }

    private static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            int cursor = i - 1;
            while (cursor >= 0 && target < nums[cursor]) {
                nums[cursor + 1] = nums[cursor];
                cursor--;
            }
            nums[cursor + 1] = target;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            } else {
                i++;
            }
        }
        return nums[nums.length - 1];
    }

    private static int singleNumberPro(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}
