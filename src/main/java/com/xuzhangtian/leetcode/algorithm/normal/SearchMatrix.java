package com.xuzhangtian.leetcode.algorithm.normal;

import com.xuzhangtian.leetcode.algorithm.utils.MatrixUtils;

/**
 * Created xzt.
 * Date : 2020/8/5
 * Time : 5:15 下午
 */
/*
74. 搜索二维矩阵
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true
示例 2:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
输出: false
 */
public class SearchMatrix {

    public static void main(String[] args) {
        System.out.println(searchMatrix(MatrixUtils.getSimpleIntMatrix(), 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix[0].length;
        int n = matrix.length;
        int left = 1;
        int right = m * n;
        while (left <= right) {
            int index = (left + right) / 2;
            if (matrix[(index - 1) / m][(index + m - 1) % m] == target) {
                return true;
            } else if (matrix[(index - 1) / m][(index + m - 1) % m] < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return false;
    }

}
