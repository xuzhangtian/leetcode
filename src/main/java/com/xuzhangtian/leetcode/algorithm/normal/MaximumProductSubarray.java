package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * @Author: xzt
 * @Date: 2024-04-04
 * <p>
 * 152. 乘积最大子数组
 * 中等
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
 * 子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 **/
public class MaximumProductSubarray {
    /**
     * 2, -4, -6, -2,   4,    2,   0, 3, 5
     * 2,  1,  48, 12,  48,   96,  1
     * 2, -8, -6, -96, -192, -384, 1
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int localMax = nums[0], localMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = localMax;
                localMax = localMin;
                localMin = tmp;
            }
            localMax = Math.max(nums[i], localMax * nums[i]);
            localMin = Math.min(nums[i], localMin * nums[i]);
            max = Math.max(max, localMax);
        }
        return max;
    }
}
