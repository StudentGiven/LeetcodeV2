package com.leetcode.jiwen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0047_Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, nums, 0);

        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> current = new ArrayList<>();
            for(int num: nums){
                current.add(num);
            }
            result.add(current);
            return;
        }

        Set<Integer> appeared = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (appeared.add(nums[i])) {
                swap(index, i, nums);
                dfs(result, nums, index + 1);
                swap(index, i, nums);
            }
        }
    }

    private void swap(int index, int i, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[index];
        nums[index] = tmp;
    }
}
