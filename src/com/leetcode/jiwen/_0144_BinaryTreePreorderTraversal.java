package com.leetcode.jiwen;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _0144_BinaryTreePreorderTraversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() { }

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public List<Integer> preorderTraversal_1(TreeNode root) {
		List<Integer> pre = new LinkedList<Integer>();
		if(root==null) return pre;
		pre.add(root.val);
		pre.addAll(preorderTraversal_1(root.left));
		pre.addAll(preorderTraversal_1(root.right));
		return pre;
	}

	public List<Integer> preorderTraversal_2(TreeNode root) {
		List<Integer> pre = new LinkedList<Integer>();
		preHelper(root,pre);
		return pre;
	}

	private void preHelper(TreeNode root, List<Integer> pre) {
		if(root==null) return;
		pre.add(root.val);
		preHelper(root.left,pre);
		preHelper(root.right,pre);
	}

	public List<Integer> preorderTraversal_3(TreeNode root) {
		List<Integer> pre = new LinkedList<Integer>();
		if(root==null) return pre;
		Stack<TreeNode> tovisit = new Stack<TreeNode>();
		tovisit.push(root);
		while(!tovisit.empty()) {
			TreeNode visiting = tovisit.pop();
			pre.add(visiting.val);
			if(visiting.right!=null) tovisit.push(visiting.right);
			if(visiting.left!=null) tovisit.push(visiting.left);
		}
		return pre;
	}
}
