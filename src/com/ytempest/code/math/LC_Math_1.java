package com.ytempest.code.math;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * @author heqidu
 * @since 2021/3/21
 * <p>
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 */
class LC_Math_1 {
    public static void main(String[] args) {
        List<String> list = fizzBuzz(15);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String str = "";
            if (i % 3 == 0) {
                str += "Fizz";
            }
            if (i % 5 == 0) {
                str += "Buzz";
            }
            if (str.length() == 0) {
                str = String.valueOf(i);
            }
            list.add(str);
        }
        return list;
    }


    public static List<String> fizzBuzzStrange(int n) {
        return new AbstractList<String>() {
            @Override
            public String get(int i) {
                i++;
                switch ((i % 3 == 0 ? 1 : 0) + (i % 5 == 0 ? 2 : 0)) {
                    case 0:
                        return String.valueOf(i);
                    case 1:
                        return "Fizz";
                    case 2:
                        return "Buzz";
                    case 3:
                        return "FizzBuzz";
                    default:
                        return "";
                }
            }

            @Override
            public int size() {
                return n;
            }
        };
    }
}
