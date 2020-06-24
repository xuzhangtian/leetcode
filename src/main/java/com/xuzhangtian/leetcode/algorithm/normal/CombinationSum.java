package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created xzt.
 * Date : 2020/6/24
 * Time : 3:27 下午
 */

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 */
public class CombinationSum {

    public static void main(String[] args) {
        List<List<Integer>> rs = combinationSum(new int[]{2, 3, 5}, 7);
        rs.forEach(System.out::println);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            dfs(results, new ArrayList<>(), candidates, target, 0, i);
        }
        return results;
    }

    public static void dfs(List<List<Integer>> results, List<Integer> nums, int[] candidates, int target, int sum, int i) {
        if (sum + candidates[i] == target) {
            List<Integer> integers = new ArrayList<>(nums);
            integers.add(candidates[i]);
            results.add(integers);
        } else if (sum + candidates[i] < target) {
            List<Integer> integers = new ArrayList<>(nums);
            integers.add(candidates[i]);
            dfs(results, integers, candidates, target, sum + candidates[i], i);
            for (int j = i + 1; j < candidates.length; j++) {
                List<Integer> integerList = new ArrayList<>(nums);
                integerList.add(candidates[i]);
                dfs(results, integerList, candidates, target, sum + candidates[i], j);
            }
        }
    }
}
