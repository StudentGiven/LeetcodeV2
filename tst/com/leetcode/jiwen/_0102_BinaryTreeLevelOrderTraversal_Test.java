package com.leetcode.jiwen;

import com.leetcode.jiwen._0102_BinaryTreeLevelOrderTraversal.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class _0102_BinaryTreeLevelOrderTraversal_Test {

    @Test
    public void test1() {
        /*
          Construct a tree test case like this:
                  3
                /   \
               9    20
                   /  \
                  15   7
          Array representation: [3, 9, 20, null, null, 15, 7]
         */
        final TreeNode node_Index_6 = new TreeNode(7);
        final TreeNode node_Index_5 = new TreeNode(15);

        final TreeNode node_Index_2 = new TreeNode(20, node_Index_5, node_Index_6);
        final TreeNode node_Index_1 = new TreeNode(9);

        final TreeNode node_Index_0 = new TreeNode(3, node_Index_1, node_Index_2);

        /*
          Construct the expected result. Like this:
          [
              [3],
              [9, 20],
              [15, 7]
          ]
        */
        final List<List<Integer>> expectedRes = new ArrayList<>();
        final List<Integer> result_Level_0 = new ArrayList<>();
        final List<Integer> result_Level_1 = new ArrayList<>();
        final List<Integer> result_Level_2 = new ArrayList<>();
        result_Level_0.add(3);
        result_Level_1.add(9);
        result_Level_1.add(20);
        result_Level_2.add(15);
        result_Level_2.add(7);
        expectedRes.add(result_Level_0);
        expectedRes.add(result_Level_1);
        expectedRes.add(result_Level_2);

        _0102_BinaryTreeLevelOrderTraversal myClass = new _0102_BinaryTreeLevelOrderTraversal();
        assertEquals(expectedRes, myClass.levelOrder(node_Index_0));
    }
}
