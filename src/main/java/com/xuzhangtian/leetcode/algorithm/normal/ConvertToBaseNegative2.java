package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * @Author: xzt
 * @Date: 2024-04-28
 * <p>
 * 1017. 负二进制转换
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
 * <p>
 * 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出："110"
 * 解释：(-2)2 + (-2)1 = 2
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出："111"
 * 解释：(-2)2 + (-2)1 + (-2)0 = 3
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出："100"
 * 解释：(-2)2 = 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 109
 **/
public class ConvertToBaseNegative2 {
    public static void main(String[] args) {
        System.out.println(baseNeg2(4));
    }

    public static String baseNeg2(int n) {
        if (n == 0) return "0";
        Step step = Step.init(n);
        String result = "";
        while (!step.isFinish()) {
            step = step.nextStep();
            result = step.extraNum + result;
        }
        return result;
    }

    static class Step {
        public int num;
        public int extraNum;


        public Step(int num, int extraNum) {
            this.num = num;
            this.extraNum = extraNum;
        }

        static Step init(int num) {
            return new Step(num, 0);
        }

        public Step nextStep() {
            if (num % -2 == 0) {
                return new Step(num / (-2), 0);
            }
            if (num % -2 == 1) {
                return new Step(num / (-2), 1);
            }
            return new Step((num / (-2)) + 1, 1);
        }

        public boolean isFinish() {
            return num == 0;
        }
    }


}
