package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created xzt.
 * Date : 2020/7/30
 * Time : 4:56 下午
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0)
            return null;
        List<Integer> numList = new ArrayList<>();
        for (int i : nums) {
            numList.add(i);
        }
        for (int i = 0; i < numList.size(); i++) {
            List<Integer> node = new ArrayList<>();
            node.add(numList.get(i));
            List<Integer> subNums = new ArrayList<>(numList);
            subNums.remove(i);
            recursiveAdd(results, node, subNums);
        }
        return results;
    }

    public void recursiveAdd(List<List<Integer>> results, List<Integer> node, List<Integer> nums) {
        if (nums.size() == 0) {
            results.add(node);
        } else {
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> newNode = new ArrayList<>(node);
                newNode.add(nums.get(i));
                List<Integer> subNums = new ArrayList<>(nums);
                subNums.remove(i);
                recursiveAdd(results, newNode, subNums);
            }
        }
    }

}
