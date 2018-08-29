package com.xuzhangtian.leetcode.algorithm.easy;

/**
 * Created xzt.
 * Date : 2018/8/29
 * Time : 下午12:15
 */

/**
 * 9. 回文数
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class IsPalindrome {

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int y = 0;
        int i = x;
        while (i > 0) {
            y = y * 10 + i % 10;
            i = i / 10;
        }
        return x == y;
    }

}
