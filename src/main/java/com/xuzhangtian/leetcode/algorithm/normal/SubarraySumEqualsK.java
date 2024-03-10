package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 1, 2, 1}, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumIndexMap = new HashMap<>();
        preSumIndexMap.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
            if (preSumIndexMap.containsKey(sum - k)) {
                count = count + preSumIndexMap.get(sum - k);
            }
            preSumIndexMap.put(sum, preSumIndexMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
