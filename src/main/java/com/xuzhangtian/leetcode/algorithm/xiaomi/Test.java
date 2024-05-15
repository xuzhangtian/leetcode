package com.xuzhangtian.leetcode.algorithm.xiaomi;

/**
 * @Author: xzt
 * @Date: 2024-03-12
 * <p>
 * 标题
 * 删除链表的倒数第 N 个结点
 * <p>
 * 题目描述
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 **/
public class Test {

    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        System.out.println("hello world");
    }

    public static ListNode removeLastN(ListNode node, int n) {
        int length = 0;
        ListNode head = node;
        while (head != null) {
            length++;
            head = head.next;
        }
        if (length == 0 && n > length)
            return node;
        if (length == n) {
            return node.next;
        }
        int k = length - n + 1;
        head = node;
        for (int i = 0; i < k - 1; i++) {
            head = head.next;
        }
        head.next = head.next.next;
        return node;
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
