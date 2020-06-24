package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created xzt.
 * Date : 2020/6/24
 * Time : 4:11 下午
 */

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        List<List<Integer>> results = combinationSum2(new int[]{1, 1}, 1);
        results.forEach(System.out::println);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            if (i > 0) {
                while (candidates[i] == candidates[i - 1]) {
                    i++;
                    if (i == candidates.length) {
                        break;
                    }
                }
            }
            if (i < candidates.length)
                dfs(results, new ArrayList<>(), candidates, target, 0, i);
        }
        return results;
    }

    public static void dfs(List<List<Integer>> results, List<Integer> nums, int[] candidates, int target, int sum, int i) {
        if (sum + candidates[i] == target) {
            List<Integer> integers = new ArrayList<>(nums);
            integers.add(candidates[i]);
            results.add(integers);
            return;
        }
        if (sum + candidates[i] < target) {
            for (int j = i + 1; j < candidates.length; j++) {
                if (j > i + 1) {
                    while (candidates[j] == candidates[j - 1]) {
                        j++;
                        if (j == candidates.length) {
                            return;
                        }
                    }
                }
                List<Integer> integers = new ArrayList<>(nums);
                integers.add(candidates[i]);
                dfs(results, integers, candidates, target, sum + candidates[i], j);
            }
        }
    }
}
