package com.heicheoa.jiwen;

import java.util.Arrays;

public class _001_Zigzag {
    // 给定一个数组，返回一个zigzag数组，a[i] < a[i + 1] > a[i + 2] || a[i] > a[i + 1] < a[i + 2] => true
    // Ex. [1, 3, 4, 2, 5]
    // return [false. true, true]
    public static boolean[] zigzag(int[] array) {
        boolean[] result = new boolean[array.length - 2];
        for (int i = 0; i < array.length - 2; i++) {
            if (array[i + 1] > array[i] && array [i + 1] > array[i + 2] ||
                    array[i + 1] < array[i] && array [i + 1] < array[i + 2]) {
                result[i] = true;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 2, 5};
        System.out.println(Arrays.toString(zigzag(array)));
    }
}
