package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * Created xzt.
 * Date : 2020/6/19
 * Time : 10:44 上午
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode result = swapPairs(listNode);
        System.out.println(result);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        swap(null, head, head.next);
        return result;
    }

    public static void swap(ListNode preNode, ListNode node, ListNode nextNode) {
        if (nextNode.next != null && nextNode.next.next != null) {
            swap(nextNode, nextNode.next, nextNode.next.next);
        }
        if (preNode == null) {
            node.next = nextNode.next;
            nextNode.next = node;
        } else {
            node.next = nextNode.next;
            nextNode.next = node;
            preNode.next = nextNode;
        }
    }

}
