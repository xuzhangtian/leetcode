package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * Created xzt.
 * Date : 2020/6/19
 * Time : 1:48 下午
 */
public class Divide {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0)
            return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative = (dividend ^ divisor) < 0;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                a = a - (b << i);
                result = result + (1 << i);
            }
        }
        return negative ? -result : result;
    }

}
