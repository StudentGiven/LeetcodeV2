package com.leetcode.jiwen;

import java.util.ArrayList;
import java.util.List;

public class _0078_Subsets {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		generateSubsets(0, nums, new ArrayList<>(), res);

		return res;
	}

	private void generateSubsets(int index,
	                             int[] nums,
	                             List<Integer> current,
	                             List<List<Integer>> subsets) {
		subsets.add(new ArrayList<>(current));

		for (int i = 0; i < nums.length; i++) {
			current.add(nums[i]);
			generateSubsets(i + 1, nums, current, subsets);
			current.remove(current.size() - 1);
		}
	}
}
