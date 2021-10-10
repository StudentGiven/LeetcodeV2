package com.leetcode.jiwen;

public class _0200_NumberOfIslands {

    int row;
    int col;

    public int numIslands(char[][] grid) {

        int result = 0;

        row = grid.length;
        col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j>= col || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
