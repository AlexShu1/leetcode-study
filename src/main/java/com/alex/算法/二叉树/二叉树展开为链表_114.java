package com.alex.算法.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 */
public class 二叉树展开为链表_114 {

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        // 前序遍历得到LIST.
        preOrderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            // 把原来的二叉树, 都赋值到右子树上, 形成链表.,
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preOrderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preOrderTraversal(root.left, list);
            preOrderTraversal(root.right, list);
        }
    }
}
