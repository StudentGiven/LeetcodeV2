package com.leetcode.jiwen;

import java.util.LinkedList;
import java.util.Queue;

public class _0785_IsGraphBipartite {

    /**
     * Time: O(n + e)
     * Space: O(n)
     */
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            visited[i] = 1; // Blue: 1; Red: -1.

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int neighbour : graph[cur]) {
                    if (visited[neighbour] == 0) {
                        // If this node hasn't been coloured,
                        // Colour it with a different colour.
                        visited[neighbour] = -visited[cur];
                        q.offer(neighbour);
                    } else if (visited[neighbour] != -visited[cur]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // Just a test to see contribution works
}
