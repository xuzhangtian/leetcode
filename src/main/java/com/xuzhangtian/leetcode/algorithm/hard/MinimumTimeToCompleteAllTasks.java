package com.xuzhangtian.leetcode.algorithm.hard;

import java.util.*;

/**
 * @Author: xzt
 * @Date: 2024-05-15
 * 2589. 完成所有任务的最少时间
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 你有一台电脑，它可以 同时 运行无数个任务。给你一个二维整数数组 tasks ，其中 tasks[i] = [starti, endi, durationi] 表示第 i 个任务需要在 闭区间 时间段 [starti, endi] 内运行 durationi 个整数时间点（但不需要连续）。
 * <p>
 * 当电脑需要运行任务时，你可以打开电脑，如果空闲时，你可以将电脑关闭。
 * <p>
 * 请你返回完成所有任务的情况下，电脑最少需要运行多少秒。
 **/
public class MinimumTimeToCompleteAllTasks {

    public static void main(String[] args) {
        System.out.println(findMinimumTime(new int[][]{{14, 20, 5}, {2, 18, 7}, {6, 14, 1}, {3, 16, 3}}));
    }

    public static int findMinimumTime(int[][] tasks) {
        Map<String, Set<String>> map = new HashMap<>();
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
        for (int[] task : tasks) {
            int day = 1;
            int start = task[0];
            int end = task[1];
            int duration = task[2];
            while (duration > end - start + 1) {
                addTimeBetween(map, "day" + day, start, end, (end - start + 1));
                duration = duration - (end - start + 1);
                day++;
            }
            addTimeBetween(map, "day" + day, start, end, duration);
        }
        return map.values().stream().mapToInt(Set::size).sum();
    }

    public static void addTimeBetween(Map<String, Set<String>> map, String key, int start, int end, int length) {
        map.putIfAbsent(key, new HashSet<>());
        for (int i = start; i <= end; i++) {
            if (map.get(key).contains(i + "-" + i)) {
                length--;
            }
        }
        while (length > 0) {
            if (!map.get(key).contains(end + "-" + end)) {
                map.get(key).add(end + "-" + end);
                length--;
            }
            end--;
        }
    }
}
