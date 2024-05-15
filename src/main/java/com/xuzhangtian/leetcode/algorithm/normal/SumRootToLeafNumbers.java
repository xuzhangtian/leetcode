package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * @Author: xzt
 * @Date: 2023-11-23
 * <p>
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 * <p>
 * 示例 2：
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 **/
public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(3));
        System.out.println(sumNumbers(treeNode));
    }

    public static int sumNumbers(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (root.left != null) {
            root.left.val = root.val * 10 + root.left.val;
        }
        if (root.right != null) {
            root.right.val = root.val * 10 + root.right.val;
        }
        if (root.left == null) {
            return sumNumbers(root.right);
        }
        if (root.right == null) {
            return sumNumbers(root.left);
        }
        return sumNumbers(root.left) + sumNumbers(root.right);
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
