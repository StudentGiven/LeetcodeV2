package com.leetcode.jiwen;

import java.util.LinkedList;
import java.util.Queue;

public class _0958_CheckCompletenessOfaBinaryTree {

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

	/**
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		boolean flag = false;
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();

			if (cur.left == null) {
				flag = true;
			} else if (flag) {
				// If flag is set but we still see cur has a left child,
				// The binary tree is not a completed one.
				return false;
			} else {
				queue.offer(cur.left);
			}

			if (cur.right ==null) {
				flag = true;
			} else if (flag) {
				return false;
			} else {
				queue.offer(cur.right);
			}
		}

		return true;
	}
}
