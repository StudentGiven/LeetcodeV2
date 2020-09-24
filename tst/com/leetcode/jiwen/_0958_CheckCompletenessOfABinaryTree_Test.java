package com.leetcode.jiwen;

import com.leetcode.jiwen._0958_CheckCompletenessOfABinaryTree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _0958_CheckCompletenessOfABinaryTree_Test {

	@Test
	public void test1() {
        /*
          Construct a tree test case like this:
                  1
                /   \
               2     3
             /  \   /
            4    5 6
          Array representation: [1, 2, 3, 4, 5, 6]
         */
		final TreeNode node_Index_5 = new TreeNode(6);
		final TreeNode node_Index_4 = new TreeNode(5);
		final TreeNode node_Index_3 = new TreeNode(4);
		final TreeNode node_Index_2 = new TreeNode(3, node_Index_5, null);
		final TreeNode node_Index_1 = new TreeNode(2, node_Index_3, node_Index_4);
		final TreeNode node_Index_0 = new TreeNode(1, node_Index_1, node_Index_2);

		_0958_CheckCompletenessOfABinaryTree myClass = new _0958_CheckCompletenessOfABinaryTree();
		assertTrue(myClass.isCompleteTree(node_Index_0));
	}

	@Test
	public void test2() {
        /*
          Construct a tree test case like this:
                  1
                /   \
               2     3
             /  \     \
            4    5     7
          Array representation: [1, 2, 3, 4, 5, null, 7]
         */
		final TreeNode node_Index_6 = new TreeNode(7);
		final TreeNode node_Index_4 = new TreeNode(5);
		final TreeNode node_Index_3 = new TreeNode(4);
		final TreeNode node_Index_2 = new TreeNode(3, null, node_Index_6);
		final TreeNode node_Index_1 = new TreeNode(2, node_Index_3, node_Index_4);
		final TreeNode node_Index_0 = new TreeNode(1, node_Index_1, node_Index_2);

		_0958_CheckCompletenessOfABinaryTree myClass = new _0958_CheckCompletenessOfABinaryTree();
		assertFalse(myClass.isCompleteTree(node_Index_0));
	}
}
