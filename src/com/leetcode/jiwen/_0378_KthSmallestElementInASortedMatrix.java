package com.leetcode.jiwen;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _0378_KthSmallestElementInASortedMatrix {

	class Cell {
		int row;
		int column;
		int value;

		Cell(int row, int column, int value) {
			this.row = row;
			this.column = column;
			this.value = value;
		}
	}

	/**
	 * x = min(k, n)
	 * Time: O(x + klgx)
	 * Space: O(x)
	 */
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				return c1.value - c2.value;
			}
		});
		boolean[][] visited = new boolean[n][n];
		minHeap.offer(new Cell(0, 0, matrix[0][0]));
		visited[0][0] = true;

		for (int i = 0; i < k - 1; i++) {
			Cell cur = minHeap.poll();
			if (cur.row + 1 < n && !visited[cur.row + 1][cur.column]) {
				minHeap.offer(new Cell(cur.row + 1, cur.column,
						matrix[cur.row + 1][cur.column]));
				visited[cur.row + 1][cur.column] = true;
			}
			if (cur.column + 1 < n && !visited[cur.row][cur.column + 1]) {
				minHeap.offer(new Cell(cur.row, cur.column + 1,
						matrix[cur.row][cur.column + 1]));
				visited[cur.row][cur.column + 1] = true;
			}
		}
		return minHeap.peek().value;
	}
}
