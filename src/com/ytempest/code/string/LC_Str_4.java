package com.ytempest.code.string;

/**
 * @author heqidu
 * @since 2021/3/9
 * <p>
 * 有效的字母异位词
 */
class LC_Str_4 {
    public static void main(String[] args) {
        System.out.println(isAnagram("loveleetcode", "odec"));
        System.out.println(isAnagram("loveleetcode", "code"));
        System.out.println(isAnagram("loveleetcode", "codea"));
    }

    public static boolean isAnagram(String s, String t) {
        int[] hit = new int[26];
        for (char c : s.toCharArray()) {
            hit[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            hit[c - 'a']--;
        }
        for (int i : hit) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
