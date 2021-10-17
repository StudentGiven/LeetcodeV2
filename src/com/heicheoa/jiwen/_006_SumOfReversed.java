package com.heicheoa.jiwen;

public class _006_SumOfReversed {

    /**
     * Q: 给定一个numbers arrays of array, 将里面所有number 按照题目规则reverse后，将所有结果加总。
     *
     * Example:
     * Input: numbers =[ [7, 20, 73200], [12, 23, 15]]
     * Output: 23727 + 104 = 23831
     *
     * Explain:
     * 将数字倒过来后, 将开头的0通通放到末尾
     * 第一个array:
     * 7 -> 7
     * 20 -> 02 -> 20
     * 73200 -> 00237 -> 23700
     * sum = 7 + 20 + 23700 = 23727
     * 第二个array:
     * 12 -> 21
     * 23 -> 32
     * 15 -> 51
     * sum = 21 + 32 + 51 = 104
     * 返回: 23727 + 104 = 23831
     */

    public static int sumOfReversed(int[][] input) {
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                result += reverse(input[i][j]);
            }
        }

        return result;
    }

    private static int reverse(int input) {
        int current = input;
        int mul = 1;
        while (current % 10 == 0) {
            mul *= 10;
            current /= 10;
        }

        int temp = 0;
        while (current != 0) {
            temp = temp * 10 + current % 10;
            current /= 10;
        }
        return temp * mul;
    }

    public static void main(String[] args) {
        int[][] input = {{7, 20, 73200}, {12, 23, 15}};
        System.out.println(sumOfReversed(input));

    }




}
