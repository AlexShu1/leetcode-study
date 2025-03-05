package com.alex.算法.二叉树;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个二叉树 root ，返回其最大深度。
 * <p>
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 */
public class 二叉树的最大深度_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            // 不断递推 -> 回归, 得到每一个节点的最长路径节点数;
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
