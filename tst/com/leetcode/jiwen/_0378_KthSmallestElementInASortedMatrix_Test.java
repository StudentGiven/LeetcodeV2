package com.leetcode.jiwen;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0378_KthSmallestElementInASortedMatrix_Test {

	@Test
	public void test1() {
		final int[][] matrix = new int[][]
				{
						{ 1,  5,  9},
						{10, 11, 13},
						{12, 13, 15}
				};
		final _0378_KthSmallestElementInASortedMatrix myClass =
				new _0378_KthSmallestElementInASortedMatrix();
		assertEquals(13, myClass.kthSmallest(matrix, 8));
	}
}
