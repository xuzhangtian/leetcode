package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created xzt.
 * Date : 2020/7/31
 * Time : 3:25 下午
 */

/**
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] a = new int[3][4];
        int value = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = value++;
            }
        }
        System.out.println(spiralOrder(a));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if (matrix.length == 0)
            return results;
        boolean isEnd = true;
        int[] params = new int[]{1, 0, 0};
        int total = matrix.length * matrix[0].length;
        while (isEnd) {
            stepAdd(results, params, matrix);
            params[0] = params[0] + 1;
            if (results.size() == total)
                isEnd = false;
        }
        return results;
    }

    public static void stepAdd(List<Integer> results, int[] params, int[][] matrix) {
        int count = params[0];
        int i = params[1];
        int j = params[2];
        int circleCount = count / 4;
        if (count == 1) {
            results.add(matrix[i][j]);
        }
        switch (count % 4) {
            // 从左往右
            case 1: {
                for (j = j + 1; j < matrix[0].length - circleCount; j++) {
                    results.add(matrix[i][j]);
                }
                j--;
                break;
            }
            // 从上往下
            case 2: {
                for (i = i + 1; i < matrix.length - circleCount; i++) {
                    results.add(matrix[i][j]);
                }
                i--;
                break;
            }
            // 从右往左
            case 3: {
                for (j = j - 1; j >= circleCount; j--) {
                    results.add(matrix[i][j]);
                }
                j++;
                break;
            }
            // 从下往上
            case 0: {
                for (i = i - 1; i >= circleCount; i--) {
                    results.add(matrix[i][j]);
                }
                i++;
                break;
            }
            default:
                break;
        }
        params[1] = i;
        params[2] = j;
    }
}
