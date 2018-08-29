package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.Objects;

/**
 * Created xzt.
 * Date : 2018/8/29
 * Time : 上午11:07
 */

/**
 * 8. 字符串转整数 (atoi)
 * <p>
 * 实现 atoi，将字符串转为整数。
 * <p>
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 * <p>
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 * <p>
 * 若函数不能执行有效的转换，返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */
public class MyAtoi {

    public int myAtoi(String str) {
        if (Objects.isNull(str) || "".equals(str))
            return 0;
        char[] chars = str.toCharArray();
        int i = 0;
        while (chars[i] == ' ') {
            i++;
            if (i >= chars.length)
                return 0;
        }
        int sign = 1;
        if (chars[i] == '+' || chars[i] == '-') {
            if (chars[i] == '-')
                sign = -1;
            i++;
        } else if (!Character.isDigit(chars[i])) {
            return 0;
        }
        int n = 0;
        while (i < chars.length && Character.isDigit(chars[i])) {
            int c = chars[i] - '0';
            if (sign > 0 && ((n > Integer.MAX_VALUE / 10) || (n == Integer.MAX_VALUE / 10 && c >= Integer.MAX_VALUE % 10))) {
                n = Integer.MAX_VALUE;
                break;
            }
            if (sign < 0 && ((n + Integer.MIN_VALUE / 10 > 0) || (n + Integer.MIN_VALUE / 10 == 0 && c + Integer.MIN_VALUE % 10 >= 0))) {
                n = Integer.MIN_VALUE;
                break;
            }
            n = n * 10 + c;
            i++;
        }
        if (n == Integer.MIN_VALUE) {
            return n;
        }
        return n * sign;
    }

}
