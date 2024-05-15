package com.xuzhangtian.leetcode.algorithm.normal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: xzt
 * @Date: 2024-04-01
 **/
public class KthSmallestElementInBST {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        System.out.println(kthSmallest(n1, 1));
    }

    public static int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;
        Deque<Integer> topK = new LinkedList<>();
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = treeNodes.poll();
                addToDeque(topK, node.val);
                if (topK.size() > k) {
                    topK.pollLast();
                }
                if (node.left != null) {
                    treeNodes.add(node.left);
                }
                if (node.right != null) {
                    treeNodes.add(node.right);
                }
            }
        }
        return topK.pollLast();
    }

    private static void addToDeque(Deque<Integer> topK, int val) {
        if (topK.isEmpty()) {
            topK.offer(val);
            return;
        }
        Stack<Integer> temp = new Stack<>();
        while (!topK.isEmpty() && topK.peekLast() > val) {
            temp.push(topK.pollLast());
        }
        topK.offer(val);
        while (!temp.isEmpty()) {
            topK.offer(temp.pop());
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
