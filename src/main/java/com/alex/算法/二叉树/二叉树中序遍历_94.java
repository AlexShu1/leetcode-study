package com.alex.算法.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 */
public class 二叉树中序遍历_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
