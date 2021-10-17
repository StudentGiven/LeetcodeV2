package com.heicheoa.jiwen;

public class _005_CheckMonotonicity {

    /**
     *
     * Q: Given an array A containing n integers. The task is to check whether the array is Monotonic or not.
     *    An array is monotonic if it is either monotone increasing or monotone decreasing.
     *    An array A is monotone increasing if for all i <= j, A <= A[j]. An array A is monotone decreasing if for all i <= j, A >= A[j].
     *    Return “True” if the given array A is monotonic else return “False” (without quotes).
     *
     * Example:
     * Input : 6 5 4 4
     * Output : true
     * Input : 5 15 20 10
     * Output : false
     */

    public static boolean checkMonotonicity(int[] input) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < input.length; i++) {
            isIncreasing &= input[i - 1] <= input[i];
            isDecreasing &= input[i - 1] >= input[i];
        }

        return isIncreasing || isDecreasing;
    }

    public static void main(String[] args) {
        int[] input1 = {6, 5, 4, 4};
        int[] input2 = {5, 15, 20, 10};
        System.out.println(checkMonotonicity(input1));
        System.out.println(checkMonotonicity(input2));
    }

}
