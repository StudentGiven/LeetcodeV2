package com.leetcode.jiwen;

import java.util.ArrayList;
import java.util.List;

public class _0078_Subsets {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}

		List<Integer> current = new ArrayList<>(); // record the current subset
		dfs(nums, current, 0, result);

		return result;
	}

	// At each level, determine the integer at current index to be picked or not
	public void dfs(int[] nums,
					List<Integer> current,
					int index,
					List<List<Integer>> result) {
		// Terminate condition: when the index reaches to the input end
		if (index == nums.length) {
			result.add(new ArrayList<>(current));
			return;
		}

		// Pick
		current.add(nums[index]);
		dfs(nums, current, index + 1, result);
		current.remove(current.size() - 1);

		// Not pick
		dfs(nums, current, index + 1, result);

	}
}
