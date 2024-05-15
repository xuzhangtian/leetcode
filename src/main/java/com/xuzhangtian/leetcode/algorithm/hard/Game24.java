package com.xuzhangtian.leetcode.algorithm.hard;

/**
 * @Author: xzt
 * @Date: 2023-12-21
 * <p>
 * 给定一个长度为4的整数数组 cards 。你有 4 张卡片，每张卡片上都包含一个范围在 [1,9] 的数字。您应该使用运算符 ['+', '-', '*', '/'] 和括号 '(' 和 ')' 将这些卡片上的数字排列成数学表达式，以获得值24。
 * <p>
 * 你须遵守以下规则:
 * <p>
 * 除法运算符 '/' 表示实数除法，而不是整数除法。
 * 例如， 4 /(1 - 2 / 3)= 4 /(1 / 3)= 12 。
 * 每个运算都在两个数字之间。特别是，不能使用 “-” 作为一元运算符。
 * 例如，如果 cards =[1,1,1,1] ，则表达式 “-1 -1 -1 -1” 是 不允许 的。
 * 你不能把数字串在一起
 * 例如，如果 cards =[1,2,1,2] ，则表达式 “12 + 12” 无效。
 * 如果可以得到这样的表达式，其计算结果为 24 ，则返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: cards = [4, 1, 8, 7]
 * 输出: true
 * 解释: (8-4) * (7-1) = 24
 * 示例 2:
 * <p>
 * 输入: cards = [1, 2, 1, 2]
 * 输出: false
 **/
public class Game24 {

    public boolean judgePoint24(int[] cards) {
        double[] dCards = new double[cards.length];
        for (int i = 0; i < cards.length; i++) {
            dCards[i] = cards[i];
        }
        return judgePoint24(dCards);
    }

    public boolean judgePoint24(double[] cards) {
        if (cards.length == 2) {
            double n1 = cards[0];
            double n2 = cards[1];
            if (isEqualTo24(n1 + n2)) {
                return true;
            }
            if (isEqualTo24(n1 - n2)) {
                return true;
            }
            if (isEqualTo24(n2 - n2)) {
                return true;
            }
            if (isEqualTo24(n1 * n2)) {
                return true;
            }
            if (n2 != 0 && isEqualTo24(n1 / n2)) {
                return true;
            }
            if (n1 != 0 && isEqualTo24(n2 / n1)) {
                return true;
            }
            return false;
        } else {
            boolean res = false;
            for (int i = 0; i < cards.length - 1; i++) {
                double[] reNums = getReNums(cards, i);
                double n1 = cards[i];
                for (int j = i + 1; j < cards.length; j++) {
                    double n2 = cards[j];
                    if (judgePoint24(genNewNums(getReNums(reNums, j - 1), n1 + n2))) {
                        res = true;
                    }
                    if (judgePoint24(genNewNums(getReNums(reNums, j - 1), n1 - n2))) {
                        res = true;
                    }
                    if (judgePoint24(genNewNums(getReNums(reNums, j - 1), n2 - n1))) {
                        res = true;
                    }
                    if (judgePoint24(genNewNums(getReNums(reNums, j - 1), n1 * n2))) {
                        res = true;
                    }
                    if (n2 != 0 && judgePoint24(genNewNums(getReNums(reNums, j - 1), n1 / n2))) {
                        res = true;
                    }
                    if (n1 != 0 && judgePoint24(genNewNums(getReNums(reNums, j - 1), n2 / n1))) {
                        res = true;
                    }
                }
            }
            return res;
        }
    }

    public boolean isEqualTo24(double num) {
        return Math.abs(24 - num) < 1e-6;
    }

    public double[] genNewNums(double[] nums, double j) {
        double[] newNums = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }
        newNums[newNums.length - 1] = j;
        return newNums;
    }

    public double[] getReNums(double[] cards, int index) {
        if (cards.length <= 1) {
            return new double[0];
        }
        double[] result = new double[cards.length - 1];
        int j = 0;
        for (int i = 0; i < cards.length; i++) {
            if (index != i) {
                result[j] = cards[i];
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        double EPISLON = 1e-6;

        double a = 3;
        double b = 8;
        double c = 3;
        double d = 8;
        double e = b / a;
        double f = c - e;
        double g = d / f;
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(Math.abs(24 - g) < EPISLON);
//        Game24 game24 = new Game24();
//        System.out.println(game24.judgePoint24(new int[]{1, 2, 1, 2}));
    }


    //    public boolean judgePoint24(int[] cards, double n1, double n2) {
//        if (cards.length == 0) {
//            if (n1 + n2 == 24) {
//                return true;
//            }
//            if (n1 - n2 == 24) {
//                return true;
//            }
//            if (n2 - n1 == 24) {
//                return true;
//            }
//            if (n1 * n2 == 24) {
//                return true;
//            }
//            if (n1 / n2 == 24) {
//                return true;
//            }
//            if (n1 != 0 && n2 / n1 == 24) {
//                return true;
//            }
//        } else {
//            boolean result = false;
//            for (int i = 0; i < cards.length; i++) {
//                if (judgePoint24(getReNums(cards, i), n1 + n2, cards[i])) {
//                    result = true;
//                }
//                if (judgePoint24(getReNums(cards, i), n1 - n2, cards[i])) {
//                    result = true;
//                }
//                if (judgePoint24(getReNums(cards, i), n2 - n1, cards[i])) {
//                    result = true;
//                }
//                if (judgePoint24(getReNums(cards, i), n1 * n2, cards[i])) {
//                    result = true;
//                }
//                if (judgePoint24(getReNums(cards, i), n1 / n2, cards[i])) {
//                    result = true;
//                }
//                if (judgePoint24(getReNums(cards, i), n2 / n1, cards[i])) {
//                    result = true;
//                }
//            }
//            return result;
//        }
//        return false;
//    }


//    public boolean judgePoint24(int[] cards) {
//        boolean result = false;
//        for (int i = 0; i < cards.length - 1; i++) {
//            for (int j = i + 1; j < cards.length; j++) {
//                int[] reNums = getReNums(cards, i);
//                if (judgePoint24(getReNums(reNums, j - 1), cards[i], cards[j])) {
//                    result = true;
//                }
//            }
//        }
//        return result;
//    }
}
