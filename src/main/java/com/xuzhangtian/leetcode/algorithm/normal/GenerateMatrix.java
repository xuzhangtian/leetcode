package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * Created xzt.
 * Date : 2020/8/3
 * Time : 11:05 上午
 */

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class GenerateMatrix {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int count = 1;
        int circleCount = 1;
        int i = 0;
        int j = 0;
        while (count <= n * n) {
            if (count == 1) {
                result[0][0] = 1;
                count++;
            }
            switch (circleCount % 4) {
                // 从左往右
                case 1: {
                    for (j = j + 1; j < result[0].length - circleCount / 4; j++) {
                        result[i][j] = count;
                        count++;
                    }
                    j--;
                    break;
                }
                // 从上往下
                case 2: {
                    for (i = i + 1; i < result.length - circleCount / 4; i++) {
                        result[i][j] = count;
                        count++;
                    }
                    i--;
                    break;
                }
                // 从右往左
                case 3: {
                    for (j = j - 1; j >= circleCount / 4; j--) {
                        result[i][j] = count;
                        count++;
                    }
                    j++;
                    break;
                }
                // 从下往上
                case 0: {
                    for (i = i - 1; i >= circleCount / 4; i--) {
                        result[i][j] = count;
                        count++;
                    }
                    i++;
                    break;
                }
                default:
                    break;
            }
            circleCount++;
        }
        return result;
    }
}
