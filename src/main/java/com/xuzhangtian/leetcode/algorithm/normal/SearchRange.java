package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * Created xzt.
 * Date : 2020/6/20
 * Time : 12:32 下午
 */

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class SearchRange {

    public static void main(String[] args) {
//        int[] r = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
//        for (int i : r) {
//            System.out.print(i + " ");
//        }

        int[] r1 = searchRange(new int[]{2, 2}, 2);
        for (int i : r1) {
            System.out.print(i + " ");
        }
    }


    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int resultBegin = -1, resultEnd = -1;
        int begin1 = 0, end1 = nums.length - 1, begin2 = 0, end2 = nums.length - 1;
        int mid1, mid2;
        while (begin1 <= end1 || begin2 <= end2) {
            mid1 = begin1 + (end1 - begin1) / 2;
            mid2 = begin2 + (end2 - begin2) / 2;
            if (nums[mid1] == target) {
                if ((mid1 < resultBegin) || (resultBegin == -1))
                    resultBegin = mid1;
                end1 = mid1 - 1;
            } else if (nums[mid1] > target) {
                end1 = mid1 - 1;
            } else {
                begin1 = mid1 + 1;
            }
            if (nums[mid2] == target) {
                if (mid2 > resultEnd)
                    resultEnd = mid2;
                begin2 = mid2 + 1;
            } else if (nums[mid2] > target) {
                end2 = mid2 - 1;
            } else {
                begin2 = mid2 + 1;
            }

        }
        return new int[]{resultBegin, resultEnd};
    }
}
