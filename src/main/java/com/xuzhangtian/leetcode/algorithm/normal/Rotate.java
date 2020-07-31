package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created xzt.
 * Date : 2020/7/31
 * Time : 10:00 上午
 */

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Rotate {

    public static void main(String[] args) {
        int[][] a = new int[3][3];
        int value = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = value++;
            }
        }
        rotate(a);
        System.out.println(a);
    }

    public static void rotate(int[][] matrix) {
        List<Integer> values = new ArrayList<>();
        for (int[] lines : matrix) {
            for (int row : lines) {
                values.add(row);
            }
        }
        int index = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = values.get(index);
                index++;
            }
        }
    }
}
