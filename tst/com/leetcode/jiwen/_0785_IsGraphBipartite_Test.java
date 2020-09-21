package com.leetcode.jiwen;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _0785_IsGraphBipartite_Test {

    @Test
    public void test1() {
        final int[][] graph = new int[][]
                {
                        {1, 3},
                        {0, 2},
                        {1, 3},
                        {0, 2}
                };
        final _0785_IsGraphBipartite myClass = new _0785_IsGraphBipartite();
        assertTrue(myClass.isBipartite(graph));
    }

    @Test
    public void test2() {
        final int[][] graph = new int[][]
                {
                        {1, 2, 3},
                        {0, 2},
                        {0, 1, 3},
                        {0, 2}
                };
        final _0785_IsGraphBipartite myClass = new _0785_IsGraphBipartite();
        assertFalse(myClass.isBipartite(graph));
    }
}
