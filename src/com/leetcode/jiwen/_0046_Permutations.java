package com.leetcode.jiwen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0046_Permutations {

    // https://leetcode.com/problems/permutations/discuss/150665/java-dfs-swap-swap
    public List<List<Integer>> permute(int[] nums) {
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
        }

        for (int i = index; i < nums.length; i++) {
            swap(index, i, nums);
            dfs(result, nums, index + 1);
            swap(index, i, nums);
        }
    }

    private void swap(int index, int i, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[index];
        nums[index] = tmp;
    }


}
