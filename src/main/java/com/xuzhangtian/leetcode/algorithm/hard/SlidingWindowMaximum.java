package com.xuzhangtian.leetcode.algorithm.hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
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
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] res = maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
        System.out.println(res);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (queue.isEmpty()) {
                queue.offer(nums[i]);
            } else {
                if (queue.peekFirst() < nums[i]) {
                    while (!queue.isEmpty()) {
                        queue.poll();
                    }
                    queue.offer(nums[i]);
                } else {
                    while (queue.peekLast() < nums[i]) {
                        queue.pollLast();
                    }
                    queue.offer(nums[i]);
                }
            }
            if (right - left + 1 == k) {
                res[left] = queue.peek();
                if (nums[left] == queue.peek()) {
                    queue.poll();
                }
                left++;
            }
            right++;
        }
        return res;
    }
}
