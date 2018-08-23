package com.xuzhangtian.leetcode.algorithm.hard;

/**
 * Created xzt.
 * Date : 2018/8/23
 * Time : 下午3:08
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * 4. 两个排序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * <p>
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * <p>
 * 你可以假设 nums1 和 nums2 不同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 中位数是 (2 + 3)/2 = 2.5
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            integers.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            integers.add(nums2[i]);
        }
        integers = integers.stream().sorted().collect(Collectors.toList());

        if (integers.size() % 2 == 0) {
            return (integers.get(integers.size() / 2 - 1).doubleValue() + integers.get(integers.size() / 2).doubleValue()) / 2;
        } else {
            return integers.get((integers.size() + 1) / 2 - 1).doubleValue();
        }
    }

}
