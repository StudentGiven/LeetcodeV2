package com.leetcode.jiwen;

public class _0529_Minesweeper {

    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;

        int clickM = click[0];
        int clickN = click[1];

        if (board[clickM][clickN] == 'M') {
            board[clickM][clickN] = 'X';
            return board;
        }

        int[][] dirs = new int[][] {
                {1, 0},  // right
                {-1, 0}, // left
                {0, 1},  // up
                {0, -1}, // down
                {1, 1},  // up right
                {1, -1}, // down right
                {-1, 1}, // up left
                {-1, -1} // down left
        };

        dfs(board, clickM, clickN, m, n, dirs);

        return board;
    }

    private void dfs(char[][] board, int clickM, int clickN, int m, int n, int[][] dirs) {
        if (clickM < 0 || clickM >= m || clickN < 0 || clickN >= n || board[clickM][clickN] != 'E') {
            return;
        }

        int mineCount = countMine(board, clickM, clickN, m, n);
        if (mineCount > 0) {
            board[clickM][clickN] = (char) ('0' + mineCount);
        } else {
            board[clickM][clickN] = 'B';
            for (int[] d : dirs) {
                dfs(board, clickM + d[0], clickN + d[1], m, n, dirs);
            }
        }
    }

    private int countMine(char[][] board, int clickM, int clickN, int m, int n) {
        int count = 0;
        for (int i = clickM - 1; i <= clickM + 1; i++) {
            for (int j = clickN - 1; j <= clickN + 1; j++) {
                if (i >= 0 && i <= m && j >= 0 && j <= n && board[i][j] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }
}
