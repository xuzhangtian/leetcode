package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xzt
 * @Date: 2023-11-24
 **/
public class PalindromePartitioning {

    private List<List<String>> partitions = new ArrayList<>();

    public List<List<String>> partition(String s) {
        partition(new ArrayList<>(), s);
        return partitions;
    }

    public void partition(List<String> list, String s) {
        if (isPalindrome(s)) {
            final List<String> needCollect = copyList(list, s);
            partitions.add(needCollect);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            String s0 = s.substring(0, i + 1);
            if (isPalindrome(s0)) {
                partition(copyList(list, s0), s.substring(i + 1));
            }
        }
    }

    private List<String> copyList(List<String> list, String s) {
        List<String> newList = new ArrayList<>();
        list.forEach(s0 -> newList.add(s0));
        newList.add(s);
        return newList;
    }

    private boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
