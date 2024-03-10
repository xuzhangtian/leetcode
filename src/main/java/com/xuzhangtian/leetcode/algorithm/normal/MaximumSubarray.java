package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * 最大子数组和
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组
 * 是数组中的一个连续部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4] [-2,-1,-4,0,-1,1,2,-3,1] [-2,1,-2,4,3,5,6,1,5]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(dpMaxSubArray(new int[]{-1}));
    }

    /**
     * max(pre(k)-pre(i))
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length < 1)
            return 0;
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < preSum.length - 1; i++) {
            for (int j = i + 1; j < preSum.length; j++) {
                max = Math.max(max, preSum[j] - preSum[i]);
            }
        }
        return max;
    }

    public static int dpMaxSubArray(int[] nums) {
        int[] dpArr = new int[nums.length + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dpArr[i + 1] = Math.max(dpArr[i], 0) + nums[i];
            max = Math.max(max, dpArr[i + 1]);
        }
        return max;
    }
}
