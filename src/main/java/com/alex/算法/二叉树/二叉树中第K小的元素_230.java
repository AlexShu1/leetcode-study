package com.alex.算法.二叉树;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 */
public class 二叉树中第K小的元素_230 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            // 因为二叉搜索树的性质, 左子树上的元素就是最小的一系列元素(最小的是最左叶子节点.).
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 当root == null的时候, 弹出来的就是最小元素.
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
