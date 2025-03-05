package com.alex.算法.二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 */
public class 二叉树中第K小的元素_230 {

    public static void main(String[] args) {
        二叉树中第K小的元素_230 call = new 二叉树中第K小的元素_230();
        int[] nums = new int[]{3, 1, 4, 0, 2};
        TreeNode root = TreeNode.fromSortedArray(nums);
        int value = call.kthSmallestV2(root, 2);
        System.out.println(value);
    }

    /**
     * 核心思想:
     * 1. 因为是二叉搜索树是一个很规则的保证: 左子树 < 根节点 < 右子树
     * 2. 因此, 小的数据都是在左子树上.
     * 3. 通过栈的方式, 把最小的压缩在栈底. 不断的弹出最小的, 直到K==0的时候, 则到了第K小的树节点
     */
    public int kthSmallestV2(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            k--;
            if (k == 0) {
                break;
            }

            root = root.right;
        }

        return root.val;
    }
}
