package com.leetcode.jiwen;

public class _0004_MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        // Let's deal the case that nums2's length is greater than nums1's length.
        // If not, then switch.
        if (m < n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = m;

        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            int L1 = partition1 - 1;
            int R1 = partition1;
            int L2 = partition2 - 1;
            int R2 = partition2;

            int ValueL1 = (L1 == -1) ? Integer.MIN_VALUE : nums1[L1];
            int ValueR1 = (R1 == m) ? Integer.MAX_VALUE : nums1[R1];
            int ValueL2 = (L2 == -1) ? Integer.MIN_VALUE : nums2[L2];
            int ValueR2 = (R2 == n) ? Integer.MAX_VALUE : nums2[R2];

            if (ValueL1 <= ValueR2 && ValueL2 <= ValueR1) {
                // We partitioned the array in the correct place,
                // try get the median now.
                if ((m + n) % 2 == 0) {
                    return ((double)Math.max(ValueL1, ValueL2) + Math.min(ValueR1, ValueR2)) / 2;
                } else {
                    return (double)Math.max(ValueL1, ValueL2);
                }
            } else if (ValueL1 > ValueR2) {
                // We are too far on right side for partition1, go on left side.
                high = partition1 - 1;
            } else {
                // We are too far on left side for partition1, go on right side.
                low = partition1 + 1;
            }
        }

        return -1;
    }

}
