package com.xuzhangtian.leetcode.algorithm.utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: xzt
 * @Date: 2023-11-24
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode constructTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        // 创建根节点
        TreeNode root = new TreeNode(array[0]);
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < array.length) {
            TreeNode current = queue.poll(); // 父节点

            // 构建左子节点
            if (i < array.length && array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            // 构建右子节点
            if (i < array.length && array[i] != null) {
                current.right = new TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
}
