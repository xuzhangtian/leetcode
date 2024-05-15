package com.xuzhangtian.leetcode.algorithm.normal;

import com.xuzhangtian.leetcode.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xzt
 * @Date: 2024-04-24
 * <p>
 * 2385. 感染二叉树需要的总时间
 * 中等
 * <p>
 * 提示
 * 给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。
 * <p>
 * 每分钟，如果节点满足以下全部条件，就会被感染：
 * <p>
 * 节点此前还没有感染。
 * 节点与一个已感染节点相邻。
 * 返回感染整棵树需要的分钟数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,5,3,null,4,10,6,9,2], start = 3
 * 输出：4
 * 解释：节点按以下过程被感染：
 * - 第 0 分钟：节点 3
 * - 第 1 分钟：节点 1、10、6
 * - 第 2 分钟：节点5
 * - 第 3 分钟：节点 4
 * - 第 4 分钟：节点 9 和 2
 * 感染整棵树需要 4 分钟，所以返回 4 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1], start = 1
 * 输出：0
 * 解释：第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。
 **/
public class AmountOfTimeForBinaryTreeToBeInfected {

    public static void main(String[] args) {
        TreeNode root = TreeNode.constructTree(new Integer[]{1,5,3,null,4,10,6,9,2});
        System.out.println(amountOfTimeGood(root, 3));
    }

    public static int amountOfTime(TreeNode root, int start) {
        List<TreeNode> list = new ArrayList<>();
        int time = 0;
        // 遍历二叉树，加入与被感染节点相邻的正常节点
        traverse(root, null, start, list);
        while (list.size() > 0) {
            time++;
            list.forEach(n -> n.val = start);
            list.clear();
            traverse(root, null, start, list);
        }
        return time;
    }

    private static void traverse(TreeNode node, Integer parentValue, int start, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        if (parentValue != null && parentValue.equals(start) && node.val != start) {
            list.add(node);
        }
        if (node.left != null) {
            if (node.left.val == start && node.val != start) {
                list.add(node);
            }
            traverse(node.left, node.val, start, list);
        }
        if (node.right != null) {
            if (node.right.val == start && node.val != start) {
                list.add(node);
            }
            traverse(node.right, node.val, start, list);
        }
    }


    public static int amountOfTimeGood(TreeNode root, int start) {
        int time = 0;
        if (root == null) {
            return time;
        }
        if (root.val == start) {
            return computeMaxLevel(0, root) - 1;
        }

        TreeNode startNode = findStartNode(root, start);
        int startTreeLevel = computeMaxLevel(0, startNode);
        startNode.left = null;
        startNode.right = null;
        int startRadius = computeMaxRadius(root, start, 0);
        return Math.max(startTreeLevel - 1, startRadius);
    }

    private static Integer computeMaxRadius(TreeNode node, int start, int radius) {
        if (node == null) {
            return null;
        }
        if (node.val == start)
            return radius;
        Integer result = computeMaxRadius(node.left, start, Math.max(radius + 1, computeMaxLevel(0, node.right) + 1));
        if (result != null) {
            return result;
        } else {
            return computeMaxRadius(node.right, start, Math.max(radius + 1, computeMaxLevel(0, node.left) + 1));
        }
    }

    private static TreeNode findStartNode(TreeNode node, int start) {
        if (node == null)
            return null;
        if (node.val == start) {
            return node;
        }
        TreeNode left = findStartNode(node.left, start);
        if (left != null) {
            return left;
        } else {
            return findStartNode(node.right, start);
        }
    }


    private static int computeMaxLevel(int level, TreeNode node) {
        if (node == null) {
            return level;
        }
        if (node.left == null) {
            return computeMaxLevel(level + 1, node.right);
        } else if (node.right == null) {
            return computeMaxLevel(level + 1, node.left);
        } else {
            return Math.max(computeMaxLevel(level + 1, node.left), computeMaxLevel(level + 1, node.right));
        }
    }

}
