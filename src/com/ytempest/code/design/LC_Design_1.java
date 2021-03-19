package com.ytempest.code.design;

import java.util.Arrays;
import java.util.Random;

public class LC_Design_1 {

    public static void main(String[] args) {

        Solution obj = new Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(obj.reset()));
        System.out.println(Arrays.toString(obj.shuffle()));
    }

    static class Solution {

        private final int[] array;
        private final Random mRandom = new Random();

        public Solution(int[] nums) {
            this.array = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return array;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int[] result = array.clone();
            for (int i = 0; i < result.length; i++) {
                int changeIdx = i + mRandom.nextInt(result.length - i);
                int tmp = result[i];
                result[i] = result[changeIdx];
                result[changeIdx] = tmp;
            }
            return result;
        }
    }
}

