package com.leetcode.jiwen;

import com.leetcode.jiwen._0124_BinaryTreeMaximumPathSum.TreeNode;

public class _0124_BinaryTreeMaximumPathSum_Test {
    public static void main(String[] args) {
        /*
          Construct a tree test case like this:
                  1
                /   \
             -12     -3
             /  \   /
            4    5 6
          Array representation: [1, -12, 3, 4, 5, 6]
         */
        final TreeNode node_Index_5 = new TreeNode(6);
        final TreeNode node_Index_4 = new TreeNode(5);
        final TreeNode node_Index_3 = new TreeNode(4);
        final TreeNode node_Index_2 = new TreeNode(-3, node_Index_5, null);
        final TreeNode node_Index_1 = new TreeNode(-12, node_Index_3, node_Index_4);
        final TreeNode node_Index_0 = new TreeNode(1, node_Index_1, node_Index_2);

        _0124_BinaryTreeMaximumPathSum myClass = new _0124_BinaryTreeMaximumPathSum();
        System.out.println(myClass.maxPathSum(node_Index_0));


    }
}
