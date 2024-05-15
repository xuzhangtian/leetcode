package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * @Author: xzt
 * @Date: 2023-08-17
 **/

/**
 * 475. 供暖器
 * <p>
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * <p>
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * <p>
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * <p>
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 * <p>
 * 示例 1:
 * <p>
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 * <p>
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * 示例 3：
 * <p>
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 */
public class FindRadius {

//    public int findRadius(int[] houses, int[] heaters) {
//        int maxHou = houses[houses.length - 1], minHou = houses[0];
//        int maxHea = heaters[heaters.length - 1], minHea = heaters[0];
////        for (int i = 0; i < Math.max(houses.length, heaters.length); i++) {
////            if (i < houses.length) {
////                if (houses[i] > maxHou) {
////                    maxHou = houses[i];
////                }
////                if (heaters[i] < minHou) {
////                    minHou = houses[i];
////                }
////            }
////            if (i < heaters.length) {
////                if (heaters[i] > maxHea) {
////                    maxHea = heaters[i];
////                }
////                if (heaters[i] < minHea) {
////                    minHea = heaters[i];
////                }
////            }
////        }
//
//        if (heaters.length == 1) {
//            int radius1 = Math.abs(heaters[0] - minHou);
//            int radius2 = Math.abs(heaters[0] - maxHou);
//            return Math.max(radius1, radius2);
//        } else {
//            int maxRadius = 0;
//            if (minHou < minHea) {
//                maxRadius = minHea - maxHou;
//            }
//            if (maxHou > maxHea) {
//                maxRadius = Math.max(maxRadius, maxHou - maxHea);
//            }
//            for (int i = 0; i < heaters.length - 1; i++) {
//                int distance = heaters[i + 1] - heaters[i];
//                if (distance % 2 == 1) {
//                    maxRadius = Math.max(maxRadius, (distance - 1) / 2);
//                } else {
//                    maxRadius = Math.max(maxRadius, distance / 2);
//                }
//            }
//            return maxRadius;
//        }
//    }

    public int findRadius(int[] houses, int[] heaters) {
        int maxHou = houses[houses.length - 1], minHou = houses[0];
        int maxHea = heaters[heaters.length - 1], minHea = heaters[0];

        if (heaters.length == 1) {
            int radius1 = Math.abs(heaters[0] - minHou);
            int radius2 = Math.abs(heaters[0] - maxHou);
            return Math.max(radius1, radius2);
        } else {
            int maxRadius = 0;
            if (minHou < minHea) {
                maxRadius = minHea - maxHou;
            }
            if (maxHou > maxHea) {
                maxRadius = Math.max(maxRadius, maxHou - maxHea);
            }
            for (int i = 0; i < heaters.length - 1; i++) {
                int distance = heaters[i + 1] - heaters[i];
                if (distance % 2 == 1) {
                    maxRadius = Math.max(maxRadius, (distance - 1) / 2);
                } else {
                    maxRadius = Math.max(maxRadius, distance / 2);
                }
            }
            return maxRadius;
        }
    }
}
