package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * Created xzt.
 * Date : 2020/6/16
 * Time : 3:27 下午
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 */
public class FourSum {

    public static void main(String[] args) {
        int[] nums = {0, 4, -5, 2, -2, 4, 2, -1, 4};
        System.out.println(fourSum(nums, 4));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<String> check = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int first = 0;
        while (first + 3 < nums.length) {
            for (int i = first + 1; i < nums.length - 2; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[left] + nums[right] + nums[first] < target) {
                        left++;
                    } else if (nums[i] + nums[left] + nums[right] + nums[first] == target) {
                        String comb = nums[first] + "" + nums[i] + "" + nums[left] + "" + nums[right];
                        if (!check.contains(comb)) {
                            check.add(comb);
                            result.add(Arrays.asList(nums[first], nums[i], nums[left], nums[right]));
                        }
                        left++;
                        right--;
                    } else {
                        right--;
                    }
                }
            }
            first++;
        }
        return result;
    }

}
