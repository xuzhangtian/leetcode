package com.xuzhangtian.leetcode.algorithm.hard;

/**
 * @Author: xzt
 * @Date: 2023-09-28
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 **/
public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    public static int trap(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int left = 0;
        int leftHigh = height[0];
        int right = height.length - 1;
        int rightHigh = height[height.length - 1];
        int result = 0;
        while (left != (right - 1)) {
            if (leftHigh < rightHigh) {
                left++;
                if (leftHigh >= height[left]) {
                    result = result + leftHigh - height[left];
                } else {
                    leftHigh = height[left];
                }
            } else {
                right--;
                if (rightHigh >= height[right]) {
                    result = result + rightHigh - height[right];
                } else {
                    rightHigh = height[right];
                }
            }
        }
        return result;
    }
}
