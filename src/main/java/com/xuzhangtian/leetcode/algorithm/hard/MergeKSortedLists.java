package com.xuzhangtian.leetcode.algorithm.hard;

/**
 * @Author: xzt
 * @Date: 2024-03-11
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 **/
public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[0];
        System.out.println(mergeKLists(listNodes));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode merged = lists[0];
        for (int i = 1; i < lists.length; i++) {
            merged = merge2Lists(merged, lists[i]);
        }
        return merged;
    }

    public static ListNode merge2Lists(ListNode node1, ListNode node2) {
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;
        if (node1.val < node2.val) {
            node1.next = merge2Lists(node1.next, node2);
            return node1;
        } else {
            node2.next = merge2Lists(node2.next, node1);
            return node2;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
