package com.leetcode.jiwen;

import java.util.PriorityQueue;

public class _0378_KthSmallestElementInASortedMatrix {

	class Cell implements Comparable<Cell> {
		int row;
		int column;
		int value;

		Cell(int row, int column, int value) {
			this.row = row;
			this.column = column;
			this.value = value;
		}

		@Override
		public int compareTo(Cell o) {
			return value - o.value;
		}
	}

	/**
	 * x = min(k, n)
	 * Time: O(x + klgx)
	 * Space: O(x)
	 */
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Cell> queue = new PriorityQueue<>();
		boolean[][] visited = new boolean[n][n];
		queue.offer(new Cell(0, 0, matrix[0][0]));
		visited[0][0] = true;

		for (int i = 0; i < k - 1; i++) {
			Cell cur = queue.poll();
			if (cur.row + 1 < n && !visited[cur.row + 1][cur.column]) {
				queue.offer(new Cell(cur.row + 1, cur.column,
						matrix[cur.row + 1][cur.column]));
				visited[cur.row + 1][cur.column] = true;
			}
			if (cur.column + 1 < n && !visited[cur.row][cur.column + 1]) {
				queue.offer(new Cell(cur.row, cur.column + 1,
						matrix[cur.row][cur.column + 1]));
				visited[cur.row][cur.column + 1] = true;
			}
		}
		return queue.peek().value;
	}
}
