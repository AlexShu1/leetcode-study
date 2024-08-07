package com.alex.算法.二叉树;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左
 * 子树
 * 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 输入：root = [2,1,3]
 * 输出：true
 */
public class 验证二叉搜索树_98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }

        // 若当前节点的val < lower, 则认为不符合规则;
        // 若当前节点的val > upper, 也认为不符合规则;
        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        // 验证左子树 + 右子树.
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
