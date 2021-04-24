package com.leetcode.jiwen;

public class _1448_CountGoodNodesInBinaryTree {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }

        max = Math.max(node.val, max);
        int result = (node.val >= max ? 1 : 0) +
                dfs(node.left, max) +
                dfs(node.right, max);

        return result;
    }
}
