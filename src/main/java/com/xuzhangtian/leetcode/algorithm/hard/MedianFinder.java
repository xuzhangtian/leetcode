package com.xuzhangtian.leetcode.algorithm.hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Author: xzt
 * @Date: 2023-12-06
 * <p>
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * <p>
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 * <p>
 * MedianFinder() 初始化 MedianFinder 对象。
 * <p>
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * <p>
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * 输出
 * [null, null, null, 1.5, null, 2.0]
 * <p>
 * 解释
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 **/
class MedianFinder {

    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();

    public void addNum(int num) {
        if (needAddToLeft(num)) {
            leftAdd(num);
        } else {
            rightAdd(num);
        }
    }

    private void rightAdd(int num) {
        right.offer(num);
        if (right.size() > left.size()) {
            leftAdd(right.poll());
        }
    }

    private void leftAdd(int num) {
        left.offer(num);
        if (left.size() > right.size() + 1) {
            rightAdd(left.poll());
        }
    }

    private int peek(PriorityQueue<Integer> queue) {
        if (queue.isEmpty())
            return 0;
        return queue.peek();
    }

    public boolean needAddToLeft(int num) {
        if (left.isEmpty()) {
            return true;
        }
        return num <= peek(left);
    }

    public double findMedian() {
        return left.size() > right.size() ? peek(left) : avg(peek(left), peek(right));
    }

    public double avg(double i1, double i2) {
        return (i1 + i2) / 2;
    }
}
