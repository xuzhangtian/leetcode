package com.xuzhangtian.leetcode.algorithm.easy;

/**
 * Created xzt.
 * Date : 2018/8/23
 * Time : 下午3:16
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        String minStr = "";
        String result = "";
        if (strs == null || strs.length == 0)
            return result;
        for (int i = 0; i < strs.length; i++) {
            map.put(strs[i], Arrays.stream(strs[i].split("")).collect(Collectors.toList()));
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
                minStr = strs[i];
            }
        }
        for (int i = 0; i < minLength; i++) {
            final String[] v = {map.get(minStr).get(i)};
            int j = i;
            map.values().forEach(l -> {
                if (!l.get(j).equals(v[0]))
                    v[0] = "";
            });
            if ("".equals(v[0]))
                break;
            result = result + v[0];
        }
        return result;
    }

}
