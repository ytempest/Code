package com.ytempest.code.search;

/**
 * @author heqidu
 * @since 2021/3/19
 * <p>
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之
 * 前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * <p>
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 */
class LC_Search_1 {
    private static final int VERSION_NUM = 1000;
    private static final int BAD_VERSION = 70;

    public static void main(String[] args) {
        final int len = VERSION_NUM;
        System.out.println(firstBadVersion(len));
        System.out.println(firstBadVersionPro(len));
    }

    public static int firstBadVersion(int n) {
        return tryGetFirstBadVersion(1, n);
    }

    public static int tryGetFirstBadVersion(int start, int end) {
        if (start >= end) {
            return isBadVersion(start) ? start : -1;
        }

        int center = start + (end - start) / 2;
        if (isBadVersion(center)) {
            return tryGetFirstBadVersion(start, center);
        } else {
            return tryGetFirstBadVersion(center + 1, end);
        }
    }

    public static boolean isBadVersion(int version) {
        return version >= BAD_VERSION;
    }

    public static int firstBadVersionPro(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int center = start + (end - start) / 2;
            if (isBadVersion(center)) {
                end = center;
            } else {
                start = center + 1;
            }
        }
        return start;
    }


}
