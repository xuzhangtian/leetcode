package com.xuzhangtian.leetcode.algorithm.normal;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(nums);
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length <= 1)
            return;
        int mk = k % nums.length;
        if (mk == 0)
            return;
        int[] afterKNums = new int[mk];
        for (int i = 0; i < afterKNums.length; i++) {
            afterKNums[i] = nums[nums.length - mk + i];
        }
        for (int i = nums.length - mk - 1; i >= 0; i--) {
            nums[i + mk] = nums[i];
        }
        for (int i = 0; i < afterKNums.length; i++) {
            nums[i] = afterKNums[i];
        }
    }
}
