package com.leetcode.jiwen;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _0078_Subsets {

	public List<List<Integer>> subsets_dfs_recursion(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}

		List<Integer> current = new ArrayList<>(); // record the current subset
		dfs_recursion(nums, current, 0, result);

		return result;
	}

	// At each level, determine the integer at current index to be picked or not
	private void dfs_recursion(int[] nums,
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
		dfs_recursion(nums, current, index + 1, result);
		current.remove(current.size() - 1);

		// Not pick
		dfs_recursion(nums, current, index + 1, result);

	}

	public List<List<Integer>> subsets_dfs_iteration(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}

		List<Integer> current = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		while (!stack.isEmpty()) {
			int index = stack.pop();
			if (index == nums.length) {
				result.add(new ArrayList<>(current));
				if (!current.isEmpty()) {
					current.remove(current.size() - 1);
				}
				continue;
			}
			stack.push(index + 1);
			current.add(nums[index]);
			stack.push(index + 1);
		}
		return result;
	}
}
