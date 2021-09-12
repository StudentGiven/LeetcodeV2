package com.leetcode.jiwen;

public class _0033_SearchInRotatedSortedArray {

    public int find_rotate_index(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return 0;
        }

        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] > nums[pivot + 1]) {
                return pivot + 1;
            } else if (nums[pivot] < nums[left]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return 0;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int res;

        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int rotate_index = find_rotate_index(nums);

        // If target is the smallest element
        if (nums[rotate_index] == target) {
            return rotate_index;
        }

        // If array is not rotated
        if (rotate_index == 0) {
            return binary_search(nums, target, 0, n - 1);
        }

        // Determine which half should we do binary search
        if (target >= nums[0] && target <= nums[rotate_index - 1]) {
            res = binary_search(nums, target, 0, rotate_index - 1);
        } else {
            res = binary_search(nums, target, rotate_index + 1, n - 1);
        }

        return res;
    }

    public int binary_search(int[] nums, int target, int left, int right) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)  {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
