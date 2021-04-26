package com.leetcode.jiwen;

import java.util.ArrayList;
import java.util.List;

public class _0545_BoundaryOfBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> result = new ArrayList<>(1000);

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        if(root == null) {
            return result;
        }

        result.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return result;
    }

    private void leftBoundary(TreeNode node) {
        if (node == null || isLeave(node)) {
            return;
        }

        result.add(node.val);

        if (node.left == null) {
            leftBoundary(node.right);
        } else {
            leftBoundary(node.left);
        }
    }

    private void rightBoundary(TreeNode node) {
        if (node == null || isLeave(node)) {
            return;
        }

        if (node.right == null) {
            rightBoundary(node.left);
        } else {
            rightBoundary(node.right);
        }
        result.add(node.val);
    }

    private void leaves(TreeNode node) {
        if (node == null) {
            return;
        }

        if (isLeave(node)) {
            result.add(node.val);
            return;
        }
        leaves(node.left);
        leaves(node.right);
    }

    private boolean isLeave(TreeNode node) {
        return (node.left == null && node.right == null);
    }
    
}
