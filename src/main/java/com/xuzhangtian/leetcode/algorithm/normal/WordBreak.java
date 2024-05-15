package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: xzt
 * @Date: 2024-04-03
 * <p>
 * 139. 单词拆分
 * 中等
 * <p>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 **/
public class WordBreak {
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> wordSet = new HashSet<>();
//        wordSet.addAll(wordDict);
//        return wordBreak(s, wordSet);
//    }
//
//    public static boolean wordBreak(String s, Set<String> wordSet) {
//        if (wordSet.contains(s)) {
//            return true;
//        }
//        for (int i = 1; i < s.length(); i++) {
//            if (wordBreak(s.substring(0, i), wordSet) && wordBreak(s.substring(i, s.length()), wordSet)) {
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     * dp[j] = dp[i] && check(s.sub(i,j))
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 1; j < dp.length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[j] = dp[i] && set.contains(s.substring(i,j));
                if (dp[j])
                    break;
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcodecode";
        List<String> list = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, list));
    }
}
