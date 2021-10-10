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

    int result;

    public int goodNodes(TreeNode root) {
        result = 0;

        if (root == null) {
            return result;
        }

        dfs(root, root.val);

        return result;
    }

    private void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }

        if (node.val >= max) {
            result++;
        }

        max = Math.max(node.val, max);

        dfs(node.left, max);
        dfs(node.right, max);
    }
}
