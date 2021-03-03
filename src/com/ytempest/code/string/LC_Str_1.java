package com.ytempest.code.string;

import java.util.Arrays;

/**
 * @author heqidu
 * @since 2021/3/4
 */
class LC_Str_1 {
    public static void main(String[] args) {
        char[] str = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(Arrays.toString(str));
        reverseString(str);
        System.out.println(Arrays.toString(str));
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
