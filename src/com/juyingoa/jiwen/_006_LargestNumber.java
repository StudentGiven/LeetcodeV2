package com.juyingoa.jiwen;

public class _006_LargestNumber {

    /**
     * 给你一个三位数，给你一个总次数。每次可以改一个数，给这个数+1. 问你小于 1000 的数，总次数之内能‍‌‍‍‍‌‍‍‍‍‍‌‌‍‌‌‌‌改的最大值是多少。
     */

    public int solution(int number, int N) {

        int hundred = number / 100;
        int tens = (number - hundred * 100) / 10;
        int digit = number - hundred * 100 - tens * 10;

        if (hundred + N <= 9) {
            return (hundred + N) * 100 + tens * 10 + digit;
        }

        if (hundred + tens + N <= 18) {
            return 9 * 100 + (hundred + N - 9 + tens) * 10 + digit;
        }

        if (hundred + tens + digit + N <= 27) {
            return 9 * 100 + 9 * 10 + hundred + tens + N - 18 + digit;
        }

        return 0;
    }
}
