package com.juyingoa.jiwen;

public class _004_ReturnSign {

    /**
     * Write a function solution that, given an array A of N integers [-100, 100], returns the sign (-1, 0, 1) of all numbers in the array multiple together.
     * Assuming that N is between 1 and 1000.
     *
     * For example, given A = [1,-2,-3,5], the function should return 1
     * Given A = [1,2,3,-5], your function should return -1
     * Given A = [1,2,0,-5], your function should return 0
     */

    public int solution(int[] A) {
        int count_negative = 0;
        for (int j : A) {
            if (j == 0) {
                return 0;
            }
            if (j < 0) {
                count_negative++;
            }
        }
        return (count_negative % 2) == 0 ? 1 : -1;
    }
}
