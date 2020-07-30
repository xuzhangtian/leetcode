package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * Created xzt.
 * Date : 2020/7/30
 * Time : 5:45 下午
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 */
public class PermuteUnique {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> result = permuteUnique(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0)
            return null;
        List<Integer> numList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i : nums) {
            numList.add(i);
        }
        for (int i = 0; i < numList.size(); i++) {
            if (i > 1 && numList.get(i).equals(numList.get(i - 1))) {
                continue;
            }
            List<Integer> node = new ArrayList<>();
            node.add(numList.get(i));
            List<Integer> subNums = new ArrayList<>(numList);
            subNums.remove(i);
            recursiveAdd(results, node, subNums);
        }
        return results;
    }

    public static void recursiveAdd(List<List<Integer>> results, List<Integer> node, List<Integer> nums) {
        if (nums.size() == 0) {
            results.add(node);
        } else {
            for (int i = 0; i < nums.size(); i++) {
                if (i > 1 && nums.get(i).equals(nums.get(i - 1))) {
                    continue;
                }
                List<Integer> newNode = new ArrayList<>(node);
                newNode.add(nums.get(i));
                List<Integer> subNums = new ArrayList<>(nums);
                subNums.remove(i);
                recursiveAdd(results, newNode, subNums);
            }
        }
    }
}
