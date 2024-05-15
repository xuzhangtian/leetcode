package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: xzt
 * @Date: 2024-03-11
 * <p>
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 * <p>
 * <p>
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 **/
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = null;
            if (!map.containsKey(node.val)) {
                map.put(node.val, node);
            } else {
                ListNode pre = map.get(node.val);
                while (pre.next != null) {
                    pre = pre.next;
                }
                pre.next = node;
            }
            node = next;
        }
        List<Integer> keys = map.keySet().stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < keys.size() - 1; i++) {
            ListNode pre = map.get(keys.get(i));
            while (pre.next != null) {
                pre = pre.next;
            }
            pre.next = map.get(keys.get(i + 1));
        }
        return map.get(keys.get(0));
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
