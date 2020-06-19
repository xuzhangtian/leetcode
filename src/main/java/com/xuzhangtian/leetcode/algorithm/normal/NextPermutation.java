package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.Arrays;

/**
 * Created xzt.
 * Date : 2020/6/19
 * Time : 2:29 下午
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
//        int[] nums = {3, 2, 1};
//        int[] nums = {1, 1, 5};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }

    public static void nextPermutation(int[] nums) {
        boolean exchange = false;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                Arrays.sort(nums, i, nums.length);
                exchange = true;
                for (int j = i; j < nums.length; j++) {
                    if (nums[i - 1] < nums[j]) {
                        int tmp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = tmp;
                        return;
                    }
                }
            }
        }
        if (!exchange) {
            Arrays.sort(nums);
        }
    }

}
