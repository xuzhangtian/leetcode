package com.xuzhangtian.leetcode.algorithm.hard;

/**
 * @Author: xzt
 * @Date: 2023-11-23
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2：
 * <p>
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
 * 示例 4：
 * <p>
 * 输入：prices = [1]
 * 输出：0
 **/
public class BestTimeToBuyAndSellStockIII {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2, 1, 4, 5, 2, 9, 7}));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // 最大交易次数
        int times = 2;
        int[][] dp = new int[prices.length][times * 2];
        for (int i = 0; i < times * 2; i++) {
            if ((i + 1) % 2 == 1) {
                dp[0][i] = -prices[0];
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < times * 2; j++) {
                if ((j + 1) % 2 == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }
        return dp[prices.length - 1][times * 2 - 1];
    }


}
