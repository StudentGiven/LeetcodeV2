package com.juyingoa.jiwen;

import java.util.Random;

public class _002_FindMinBug {

    /**
     * The following find_min function should return the smallest integer from a given array A.
     *
     * int find_min(int[] A) {
     *     int ans = 0;
     *     for (int i = 1; i < A.length; i++) {
     *         if (ans > A[i]) {
     *             ans = A[i];
     *         }
     *     }
     *     return ans;
     * }
     *
     * Unfortunately it is an incorrect implementation. In other words, when the function is called with certain parameters, it returns the wrong
     * answer. Your task is to generate a counterexample, i.e. an array A consisting of N integers such that the find_min function returns the
     * wrong answer.
     *
     * Write a function:
     *     class Solution { public int[] solution(int N); }
     * that, given an integer N, returns an array A consisting of N integers which describes a counterexample.
     *
     * Example:
     * Given N = 4, your function may return [4, 2, 4, 5]. It is a counterexample, because calling the find_min function with this array returns 0, but
     * the correct answer is 2. Your function may also return another counterexample; for example, [10, 567, 99, 456].
     *
     * Assume that:
     *     · N is an integer within the range [1 ... 1,000].
     */

     public int find_min_wrong(int[] A) {
         int ans = 0;
         for (int i = 1; i < A.length; i++) {
             if (ans > A[i]) {
                 ans = A[i];
             }
         }
         return ans;
     }

    public int find_min_correct(int[] A) {
        int ans = A[0];
        for (int i = 1; i < A.length; i++) {
            if (ans > A[i]) {
                ans = A[i];
            }
        }
        return ans;
    }

    public int[] solution(int N) {
        int[] result = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            result[i] = random.nextInt(100000) + 1; // From 1 to 100001
        }
        result[0] = -result[0];
        return result;
    }

}
