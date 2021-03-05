package com.ytempest.code.string;

/**
 * @author heqidu
 * @since 2021/3/4
 * <p>
 * 查找字符串中第一个不重复的字符
 */
class LC_Str_3 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("ee"));
        System.out.println(firstUniqChar("itwqbtcdprfsuprkrjkausiterybzncbmdvkgljxuekizvaivszowqtmrttiihervpncztuoljftlxybpgwnjb"));
    }

    public static int firstUniqChar(String s) {
        if (s.length() <= 0) return -1;
        Integer[] marks = new Integer[26];
        for (int i = 0; i < s.length(); i++) {
            int no = s.charAt(i) - 'a';
            Integer val = marks[no];
            if (val == null) {
                marks[no] = i;
            } else if (val != -1) {
                marks[no] = -1;
            }
        }
        int resultIdx = s.length();
        for (Integer idx : marks) {
            if (idx != null && idx != -1) {
                resultIdx = Math.min(resultIdx, idx);
            }
        }
        return resultIdx == s.length() ? -1 : resultIdx;
    }
}
