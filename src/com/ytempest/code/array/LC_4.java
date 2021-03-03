package com.ytempest.code.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ytempest
 * @since 2021/3/3
 * <p>
 * 查询存在重复的元素
 */
public class LC_4 {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 3, 1}));

        System.out.println(containsDuplicatePro(new int[]{3, 1}));
        System.out.println(containsDuplicatePro(new int[]{1, 3, 1}));
    }

    private static boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) return false;
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
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsDuplicatePro(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) != null) {
                return true;
            } else {
                map.put(num, num);
            }
        }
        return false;
    }
}
