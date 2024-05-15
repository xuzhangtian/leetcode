package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * @Author: xzt
 * @Date: 2024-03-11
 **/
public class SearchA2DMatrixII {

    public static void main(String[] args) {
        int[][] matrix = {
                {5}, {6}
        };
        System.out.println(searchMatrix(matrix, 6));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // [0][length-1]
        int i = 0, j = matrix[0].length - 1;

        while (i <= matrix.length - 1 && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
