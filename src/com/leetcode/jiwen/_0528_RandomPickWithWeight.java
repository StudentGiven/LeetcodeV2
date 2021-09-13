package com.leetcode.jiwen;

import java.util.Random;

public class _0528_RandomPickWithWeight {

    Random random;
    int[] wSum;

    public _0528_RandomPickWithWeight(int[] w) {
        this.random = new Random();
        wSum = w;
        for (int i = 1; i < w.length; i++) {
            wSum[i] += wSum[i - 1];
        }

    }

    public int pickIndex() {
        int length = wSum.length;
        int index = random.nextInt(wSum[length - 1]) + 1;

        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (wSum[mid] == index) {
                return mid;
            } else if (wSum[mid] > index) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }
}
