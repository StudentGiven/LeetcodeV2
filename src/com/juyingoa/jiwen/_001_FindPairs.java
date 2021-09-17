package com.juyingoa.jiwen;

public class _001_FindPairs {

    /**
     * You are given an array of integers. Your task is to create pairs of them, such that every pair consists of equal numbers.
     * Each array element may belong to one pair only. Is it possible to use all of the integers?
     *
     * Write a function:
     *     class Solution { public boolean solution(int[] A); }
     * that, given an array A consisting of N integers, return whether it is possible to split all integers into pairs.
     *
     * Examples:
     * 1. Given A = [1, 2, 2, 1], your function should return True, as the pairs are (A[0], A[3]) (both have value 1) and (A[1], A[2]) (both have value 2).
     * 2. Given A = [7, 7, 7], your function should return False, as you can make one pair of numbers 7, but you still have a single 7 left.
     * 3. Given A = [1, 2, 2, 3], your function should return False, as there's nothing that A[0] can be paired with.
     *
     * Write an efficient algorithm for the following assumptions:
     *     · N is an integer within the range [1 ... 100,000];
     *     · each element of array A is an integer within the range [-1,000,000 ... 1,000,000].
     */

    /*
       Bit Manipulation
       Concept
        · If we take XOR of zero and some bit, it will return that bit
            a ⊕ 0 = a
        · If we take XOR of two same bits, it will return 0
            a ⊕ a = 0
        · a ⊕ b ⊕ a = (a ⊕ a) ⊕ b = 0 ⊕ b = b
       So we can XOR all bits together to see if we get 0 or not.
     */

    public boolean solution(int[] A) {
        if (A.length % 2 == 1) {
            return false;
        }

        int a = 0;
        for (int i : A) {
            a ^= i;
        }
        return a == 0;
    }
}
