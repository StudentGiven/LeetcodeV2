package com.leetcode.jiwen;

public class _0518_CoinChange2_Test {

    public static void main(String[] args) {
        _0518_CoinChange2 myClass = new _0518_CoinChange2();
        int amount = 500;
        int[] coins = new int[]{3, 5, 7, 8, 9, 10, 11};
        System.out.println(myClass.change(amount, coins));
    }
}
