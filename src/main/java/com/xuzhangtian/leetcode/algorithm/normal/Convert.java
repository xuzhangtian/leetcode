package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * Created xzt.
 * Date : 2018/8/23
 * Time : 下午3:13
 */

/**
 * 6. Z字形变换
 * <p>
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 * <p>
 * 实现一个将字符串进行指定行数变换的函数:
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "PAYPALISHIRING", numRows = 3
 * 输出: "PAHNAPLSIIGYIR"
 * 示例 2:
 * <p>
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 * 解释:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class Convert {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int row = (s.length() / (numRows * 2 - 2)) * (numRows - 1)
                + (s.length() % (numRows * 2 - 2)) / numRows
                + (s.length() % (numRows * 2 - 2)) % numRows;
        int column = numRows;
        int count = 0;
        char[][] chars = new char[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ((i + column - 1) % (column - 1) == 0) {
                    if (count < s.length() && s.charAt(count) != '\0') {
                        chars[i][j] = s.charAt(count);
                        count++;
                    }
                } else {
                    if (column - (i + column - 1) % (column - 1) - 1 == j) {
                        if (count < s.length() && s.charAt(count) != '\0') {
                            chars[i][j] = s.charAt(count);
                            count++;
                        }
                    }
                }
            }
        }
        String result = "";
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (chars[j][i] != '\0')
                    result = result + chars[j][i];
            }
        }
        return result;
    }
}
