package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @Author: xzt
 * @Date: 2024-05-13
 * 994. 腐烂的橘子
 * 中等
 * 相关标签
 * 相关企业
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * <p>
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
 * 示例 3：
 * <p>
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 **/
public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = new int[][]{new int[]{2, 1, 1}, new int[]{1, 1, 0}, new int[]{0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        final Queue<Nums> numsList = new LinkedList();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    numsList.add(new Nums(i, j));
                }
            }
        }
        boolean whitLoop = false;
        while (!numsList.isEmpty()) {
            whitLoop = true;
            count++;
            int size = numsList.size();
            for (int i = 0; i < size; i++) {
                Nums nums = numsList.poll();
                offer(numsList, grid, nums.i, nums.j - 1);
                offer(numsList, grid, nums.i - 1, nums.j);
                offer(numsList, grid, nums.i, nums.j + 1);
                offer(numsList, grid, nums.i + 1, nums.j);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return whitLoop ? count - 1 : count;
    }

    private static void offer(Queue<Nums> numsList, int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        Nums nums = new Nums(i, j);
        if (grid[i][j] == 1 && !numsList.contains(nums)) {
            grid[i][j] = 2;
            numsList.offer(nums);
        }
    }

    public static class Nums {
        public int i;
        public int j;

        public Nums(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Nums nums = (Nums) o;
            return i == nums.i && j == nums.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
