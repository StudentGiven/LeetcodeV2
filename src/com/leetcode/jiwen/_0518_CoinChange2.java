package com.leetcode.jiwen;

import java.util.ArrayList;
import java.util.Arrays;
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

    // https://leetcode.com/problems/coin-change-2/discuss/668531/DFS-%2B-memo-to-DP
    public int change2(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dfs2(coins, coins.length - 1, amount, memo);
    }

    private int dfs2(int[] coins, int index, int amount, int[][] memo) {
        if (amount == 0) {
            return 1;
        }

        if (index == -1) {
            return 0;
        }

        if (memo[index][amount] != -1) {
            return memo[index][amount];
        }

        int result = 0;
        if (coins[index] <= amount) {
            result += dfs2(coins, index, amount - coins[index], memo);
        }

        result += dfs2(coins, index - 1, amount, memo);
        memo[index][amount] = result;
        return result;
    }
}
