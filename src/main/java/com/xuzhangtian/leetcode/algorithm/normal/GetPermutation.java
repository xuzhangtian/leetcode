package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * Created xzt.
 * Date : 2020/8/3
 * Time : 2:23 下午
 */

/**
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class GetPermutation {

    public static void main(String[] args) {
        System.out.println(getPermutation(2, 2));
    }

    public static String getPermutation(int n, int k) {
        if (n == 1)
            return "1";
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = i + 1;
        }
        return recursiveAdd(inputs, n, k, 0, "");
    }

    public static String recursiveAdd(int[] inputs, int n, int k, int index, String result) {
        int sum = factorial(n - 1);
        int a = k / sum;
        int b = k % sum;
        int c = b == 0 ? a - 1 : a;
        result = result + inputs[c];
        int[] newInputs = new int[inputs.length - 1];
        boolean needAddOne = false;
        for (int i = 0; i < inputs.length - 1; i++) {
            if (i == c) {
                needAddOne = true;
            }
            if (needAddOne) {
                newInputs[i] = inputs[i + 1];
            } else {
                newInputs[i] = inputs[i];
            }
        }
        // b = 0 说明在小组里排最后一位，直接从大到小 append 新数组
        if (b == 0) {
            StringBuilder resultBuilder = new StringBuilder(result);
            for (int i = newInputs.length - 1; i >= 0; i--) {
                resultBuilder.append(newInputs[i]);
            }
            return resultBuilder.toString();
        }
        return recursiveAdd(newInputs, n - 1, b, index + 1, result);
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
