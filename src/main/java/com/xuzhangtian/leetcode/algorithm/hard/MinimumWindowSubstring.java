package com.xuzhangtian.leetcode.algorithm.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String result = minimumWindowSubstring.minWindow("a", "a");
        System.out.println(result);
    }

    public String minWindow(String s, String t) {
        String result = "";
        Window window = new Window(t);
        for (int i = 0; i < s.length(); i++) {
            window.add(s.charAt(i));
            if (window.isFullWindow()) {
                if (window.right - window.left + 1 < result.length()
                        || result.isEmpty()) {
                    result = s.substring(window.left, window.right + 1);
                }
                while (window.needLeftMove(s)) {
                    window.remove(s.charAt(window.left));
                    if (window.isFullWindow()) {
                        if (window.right - window.left + 1 < result.length()
                                || result.isEmpty()) {
                            result = s.substring(window.left, window.right + 1);
                        }
                    }
                }
            }
        }
        return result;
    }

    public class Window {
        int left = 0, right = -1;
        Map<Character, Tupe> map = new HashMap<>();

        Window(String s) {
            for (Character c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    map.get(c).sumIncrement();
                } else {
                    map.put(c, new Tupe());
                }
            }
        }

        public boolean needLeftMove(String s) {
            return left < s.length() && (isFullWindow() || !map.containsKey(s.charAt(left)));
        }

        public void add(Character c) {
            right++;
            if (map.containsKey(c)) {
                map.get(c).currentIncrement();
            } else {
                if (isEmptyWindow()) {
                    left++;
                }
            }
        }

        public void remove(Character c) {
            left++;
            if (map.containsKey(c)) {
                map.get(c).currentDecrement();
            }
        }

        public boolean isFullWindow() {
            for (Tupe t : map.values()) {
                if (!t.isFull()) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmptyWindow() {
            for (Tupe t : map.values()) {
                if (t.current != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public class Tupe {
        int current;
        int sum;

        Tupe() {
            current = 0;
            sum = 1;
        }

        public void sumIncrement() {
            sum++;
        }

        public void currentIncrement() {
            current++;
        }

        public boolean isFull() {
            return current >= sum;
        }

        public void currentDecrement() {
            current--;
        }
    }
}
