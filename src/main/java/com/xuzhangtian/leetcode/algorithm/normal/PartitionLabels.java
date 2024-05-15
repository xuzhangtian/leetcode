package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.*;

/**
 * @Author: xzt
 * @Date: 2024-04-02
 * <p>
 * 763. 划分字母区间
 * 中等
 * 提示
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * <p>
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * <p>
 * 返回一个表示每个字符串片段的长度的列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 * 示例 2：
 * <p>
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 **/
public class PartitionLabels {
    public static void main(String[] args) {
        List<Integer> result = partitionLabels("caedbdedda");
        System.out.println(result);
    }

    public static List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], i);
        }
        Set<Character> label = new HashSet<>();
        int max = -1;
        List<Integer> result = new ArrayList<>();
        int count = -1;
        for (int i = 0; i < chars.length; i++) {
            if (!label.contains(chars[i])) {
                label.add(chars[i]);
                max = Math.max(max, map.get(chars[i]));
            }
            if (max == i) {
                label.clear();
                if (count >= 0) {
                    result.add(compute(max, result, count));
                } else {
                    result.add(max + 1);
                }
                count++;
            }
        }
        return result;
    }

    private static Integer compute(int max, List<Integer> result, int count) {
        int v = max + 1;
        for (int i = 0; i <= count; i++) {
            v = v - result.get(i);
        }
        return v;
    }
}
