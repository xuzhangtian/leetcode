package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * Created xzt.
 * Date : 2018/8/30
 * Time : 上午10:30
 */

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int left = 0, right = 0;
        if (s == null || s.length() < 1)
            return "";
        for (int i = 0; i < s.length(); i++) {
            int odd = computeMaxLength(s, i, i);
            int even = computeMaxLength(s, i, i + 1);
            int maxLength = Math.max(odd, even);
            if (maxLength > (right - left + 1)) {
                left = i - (maxLength - 1) / 2;
                right = i + maxLength / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    public int computeMaxLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
