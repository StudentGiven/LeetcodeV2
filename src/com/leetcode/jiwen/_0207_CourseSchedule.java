package com.leetcode.jiwen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _0207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create graph
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            if (graph.containsKey(prerequisites[i][1])) {
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1], list);
            }
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            List<Integer> toTake = graph.get(current);
            for (int i = 0; toTake != null && i < toTake.size(); i++) {
                inDegree[toTake.get(i)]--;
                if (inDegree[toTake.get(i)] == 0) {
                    queue.offer(toTake.get(i));
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }

        return true;
    }

    boolean hasCircle;

    // Topological sort
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
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
                return false;
            }
            dfs(i, graph, visited);
        }

        return !hasCircle;
    }

    private void dfs(int current, ArrayList<ArrayList<Integer>> graph, int[] visited) {
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
            dfs(next, graph, visited);
        }

        visited[current] = 2;
    }
    
}
