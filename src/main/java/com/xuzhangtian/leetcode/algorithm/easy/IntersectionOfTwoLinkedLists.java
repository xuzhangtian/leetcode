package com.xuzhangtian.leetcode.algorithm.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xzt
 * @Date: 2024-03-11
 **/
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> set = new HashSet<>();
        ListNode node = headA;
        while (node != null) {
            set.add(node);
            node = node.next;
        }
        node = headB;
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
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


