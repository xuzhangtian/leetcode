package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * Created xzt.
 * Date : 2018/8/23
 * Time : 下午3:07
 */

/**
 * 2. 两数相加
 * <p>
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        int count = 0;

        ListNode result = new ListNode(0);

        ListNode r = result;

        while (p != null || q != null || count != 0) {
            int pVal = p == null ? 0 : p.val;
            int qVal = q == null ? 0 : q.val;
            r.val = (pVal + qVal + count) % 10;
            count = (pVal + qVal + count) / 10;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;

            if (p != null || q != null || count != 0) {
                r.next = new ListNode(0);
                r = r.next;
            }
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
