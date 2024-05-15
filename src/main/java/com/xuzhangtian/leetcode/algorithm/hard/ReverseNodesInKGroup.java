package com.xuzhangtian.leetcode.algorithm.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: xzt
 * @Date: 2024-03-01
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * <p>
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 **/
public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (Objects.isNull(head)) {
            return null;
        }
        List<ListNode> list = nodeSplit(head, k);
        if (list.isEmpty()) {
            return head;
        }
        return nodeConcat(list);
    }

    private static ListNode nodeConcat(List<ListNode> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        ListNode node = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            while (node.next != null) {
                node = node.next;
            }
            node.next = list.get(i);
            node = list.get(i);
        }
        return list.get(0);
    }

    public static List<ListNode> nodeSplit(ListNode nodes, int k) {
        List<ListNode> list = new ArrayList<>();
        int count = k;
        ListNode head = nodes;
        ListNode current = nodes;
        while (current.next != null) {
            count--;
            if (count == 0) {
                count = k;
                ListNode temp = current.next;
                current.next = null;
                list.add(reverse(head));
                head = temp;
                current = temp;
            } else {
                current = current.next;
            }
        }
        if (count == 1) {
            list.add(reverse(head));
        } else if ((count > 1 && !list.isEmpty())) {
            list.add(head);
        }
        return list;
    }


    public static ListNode reverse(ListNode nodes) {
        ListNode pre = null;
        ListNode current = nodes;
        while (current.next != null) {
            current = nodes.next;
            nodes.next = pre;
            pre = nodes;
            nodes = current;
        }
        nodes.next = pre;
        return current;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(reverseKGroup(node1, 2));
    }
}
