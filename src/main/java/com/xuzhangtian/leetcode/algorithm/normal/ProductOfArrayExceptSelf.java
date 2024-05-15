package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * @Author: xzt
 * @Date: 2024-03-11
 * <p>
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 **/
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] result = productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(result);
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] leftNums = new int[nums.length];
        int[] rightNums = new int[nums.length];
        leftNums[0] = 1;
        rightNums[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftNums[i] = leftNums[i - 1] * nums[i - 1];
            rightNums[nums.length - i - 1] = rightNums[nums.length - i] * nums[nums.length - i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftNums[i] * rightNums[i];
        }
        return result;
    }
}
