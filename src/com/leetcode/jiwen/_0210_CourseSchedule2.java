package com.leetcode.jiwen;

import java.util.ArrayList;
import java.util.List;

public class _0210_CourseSchedule2 {

    boolean hasCircle;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<Integer>();
        int[] resultArray = new int[numCourses];

        List<List<Integer>> graph = new ArrayList<>();
        hasCircle = false;

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            graph.get(course).add(prerequisite);
        }

        int[] visited = new int[numCourses]; // 1 means visiting, 2 means visited
        for (int i = 0; i < numCourses; i++) {
            if (hasCircle) {
                return new int[0];
            }
            dfs(i, graph, visited, result);
        }

        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    private void dfs(int current, List<List<Integer>> graph, int[] visited, List<Integer> result) {
        if (visited[current] == 1) {
            hasCircle = true;
            return;
        }

        if (visited[current] == 2) {
            return;
        }

        visited[current] = 1;

        for (int next : graph.get(current)) {
            if (hasCircle) {
                return;
            }
            dfs(next, graph, visited, result);
        }

        visited[current] = 2;
        result.add(current);
    }
}
