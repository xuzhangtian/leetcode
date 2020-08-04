package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * Created xzt.
 * Date : 2020/7/31
 * Time : 5:17 下午
 */

import java.util.*;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Merge {

    public void main(String[] args) {
        int[] a1 = new int[]{1, 3};
        int[] a2 = new int[]{2, 6};
        int[] a3 = new int[]{8, 10};
        int[] a4 = new int[]{15, 18};
        int[][] results = new int[][]{a1, a2, a3, a4};
        System.out.println(Arrays.deepToString(merge(results)));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[0][0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] interval : intervals) {
            if (Objects.isNull(map.get(interval[0])) || map.get(interval[0]) < interval[1]) {
                map.put(interval[0], interval[1]);
            }
        }
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);
        List<Range> ranges = new ArrayList<>();
        for (int key : keys) {
            ranges.add(new Range(key, map.get(key)));
        }
        List<Range> merged = new ArrayList<>();
        Range temp = ranges.get(0);
        for (Range range : ranges) {
            temp = mergeAndAdd(merged, temp, range);
        }
        merged.add(temp);
        int[][] results = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            results[i][0] = merged.get(i).left;
            results[i][1] = merged.get(i).right;
        }
        return results;
    }

    static class Range {
        private final Integer left;
        private final Integer right;

        public Range(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }
    }

    private Range mergeAndAdd(List<Range> ranges, Range one, Range two) {
        if (one.right < two.left) {
            ranges.add(one);
            return two;
        } else if (one.right < two.right) {
            return new Range(one.left, two.right);
        } else {
            return one;
        }
    }
    
}
