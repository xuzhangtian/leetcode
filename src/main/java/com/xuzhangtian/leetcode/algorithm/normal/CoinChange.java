package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xzt
 * @Date: 2023-11-28
 * <p>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 **/
public class CoinChange {
    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int a = coinChange.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(a);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        List<Integer> dpValueList = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            int dpValue = coinChange(coins, amount - coins[i]);
            if (dpValue != -1) {
                dpValue = dpValue + 1;
            }
            dpValueList.add(dpValue);
        }
        int min = dpValueList.stream()
                .filter(i -> i > 0)
                .mapToInt(i -> i)
                .min()
                .orElse(-1);
        map.put(amount, min);
        return min;
    }

}
