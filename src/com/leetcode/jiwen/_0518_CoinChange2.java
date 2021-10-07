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

    /**
     *     public int change(int amount, int[] coins) {
     *
     *         to avoid duplicated count for combination to reach amount, avoid to repeated calcualte [1,2] and [2,1]
     *         e.x., coins = {1,2}, amount = 3
     *             comb = [1,1,1], [1,2]
     *         need to loop coins first, which means if 2 has been used in one path, it cannot be used again, need to have a way to record which coins has been used and cannot be used again
     *                              3
     *                        (1)/     \ (2): pass 1 already, so 1 cannot be used again in any branch below
     *                          2        1 (cannot go further)
     *                     (1)/   \(2)
     *                       1     0
     *                   (1)/
     *                     0
     *
     *         if (amount == 0) {
     *              return 1;
     *         } else if (coins == null || coins.length == 0) {
     *              return 0;
     *         }
     *         int[][] memo = new int[coins.length][amount + 1];
     *         /**use index to keep track which coin has been used
     *         memo[i][j]: # of combination to reach j with coin choices[0, i], so going forward
     *         1. keep using coins[i]
     *             memo[i][j] = memo[i][j - coins[i]];
     *         2. skip coins[i] and use coins[i + 1]
     *             memo[i][j] = memo[i + 1][j]
     *         *
             *for(
    int[] m :memo)

    {
     *Arrays.fill(m, -1);
     *}
     *return

    dfs(coins, coins.length -1, amount, memo);
     *
}
     *private int dfs(int[]coins,int index,int amount,int[][]memo){
        *if(amount==0){
        *return 1;
        *}else if(index==-1){
        *return 0;
        *}else if(memo[index][amount]!=-1){
        *return memo[index][amount];
        *}
        *int result=0;
        *if(coins[index]<=amount){
        *result+=dfs(coins,index,amount-coins[index],memo);
        *}
        *result+=dfs(coins,index-1,amount,memo);
        *memo[index][amount]=result;
        *return result;
        *}
     */
}
