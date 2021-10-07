package com.leetcode.jiwen;

import java.util.ArrayList;
import java.util.List;

public class _0518_CoinChange2 {

    // DFS works but TLE
    public int change(int amount, int[] coins) {
        int[] result = new int[]{0};
        List<Integer> current = new ArrayList<>();
        dfs(coins, amount, 0, result, current);
        return result[0];
    }

    private void dfs(int[] coins, int amount, int index, int[] result, List<Integer> currentList) {
        // This can also be done at index == coins.length where all the coins have been picked.
        // But a probably better one is at previous level to reduce the number of unnecessary branches in the DFS.
        if (index == coins.length - 1) {
            if (amount % coins[coins.length - 1] == 0) {
                result[0]++;
            }
            return;
        }

        int max = amount / coins[index];
        for (int i = 0; i <= max; i++) {
            currentList.add(i);
            dfs(coins, amount - i * coins[index], index + 1, result, currentList);
            currentList.remove(currentList.size() - 1);
        }
    }
}
