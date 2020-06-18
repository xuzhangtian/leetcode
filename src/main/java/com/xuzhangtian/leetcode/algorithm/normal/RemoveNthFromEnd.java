package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * Created xzt.
 * Date : 2020/6/18
 * Time : 1:45 下午
 */

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {

    static class A {
        Integer count;

        A(int n) {
            count = n;
        }

        public Integer getCount() {
            return count;
        }

        public void decrease() {
            count--;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        removeNthFromEnd(node, 5);
        System.out.println(node);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        A a = new A(n);
        if (head.next == null)
            return null;
        traverse(head, head.next, a);
        if (a.getCount() == 1) {
            return head.next;
        }
        return head;
    }

    public static void traverse(ListNode preNode, ListNode node, A a) {
        if (node.next == null) {
            a.decrease();
            if (a.getCount() == 0)
                preNode.next = null;
            return;
        } else {
            traverse(node, node.next, a);
        }
        a.decrease();
        if (a.getCount() == 0)
            preNode.next = node.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEndOtherWrite(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        while (node2.next != null) {
            node2 = node1;
            for (int i = 0; i < n; i++) {
                node2 = node2.next;
            }
            //要删除的是头节点
            if (node2 == null) {
                return head.next;
            }
            if (node2.next != null) {
                node1 = node1.next;
            }
        }
        node1.next = node1.next.next;
        return head;
    }
}
