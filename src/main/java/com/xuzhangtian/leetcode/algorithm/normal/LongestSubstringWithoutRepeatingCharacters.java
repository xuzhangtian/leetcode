package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 子串
 * 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        Queue<Character> queue = new ArrayDeque<>();
        int max = 0;
        int current = 0;
        for (char c : arr) {
            if (queue.contains(c)) {
                max = Math.max(current, max);
                while (queue.contains(c)) {
                    queue.poll();
                    current--;
                }
            }
            queue.offer(c);
            current++;
        }
        return Math.max(max, current);
    }
}
