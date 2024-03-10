package com.xuzhangtian.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(nums);
    }
    public static void moveZeroes(int[] nums) {
        if (nums.length == 0)
            return;
        List<Integer> notZero = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                notZero.add(num);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < notZero.size()) {
                nums[i] = notZero.get(i);
            } else {
                nums[i] = 0;
            }
        }
    }
}
