package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * Created xzt.
 * Date : 2020/8/4
 * Time : 10:52 上午
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        int length = 1;
        ListNode checkNode = head;
        while (checkNode.next != null) {
            length++;
            checkNode = checkNode.next;
        }
        ListNode rearNode = checkNode;
        if (k % length == 0)
            return head;
        int index = length - 1 - (k % length);
        ListNode realRearNode = head;
        for (int i = 0; i < index; i++) {
            realRearNode = realRearNode.next;
        }
        ListNode realHeadNode = realRearNode.next;
        realRearNode.next = null;
        rearNode.next = head;
        return realHeadNode;
    }

}
