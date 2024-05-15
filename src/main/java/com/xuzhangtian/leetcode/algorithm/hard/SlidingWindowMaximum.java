package com.xuzhangtian.leetcode.algorithm.hard;

import java.util.LinkedList;

/**
 * @Author: xzt
 * @Date: 2023-09-28
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 **/
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{7, 2, 4}, 2));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        boolean begin = false;
        LinkedList<Integer> sortedWindow = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // check window is build
            if (i + 1 == k) {
                begin = true;
            }
            if (!sortedWindow.isEmpty() && sortedWindow.getFirst() == i - k) {
                sortedWindow.pollFirst();
            }
            buildSortedWindow(sortedWindow, nums, i);
            if (begin) {
                result[i - k + 1] = nums[sortedWindow.getFirst()];
            }
        }
        return result;
    }

    private static void buildSortedWindow(LinkedList<Integer> sortedWindow, int[] nums, int index) {
        while (!sortedWindow.isEmpty() && nums[sortedWindow.getLast()] < nums[index]) {
            sortedWindow.pollLast();
        }
        sortedWindow.offerLast(index);
    }

}
