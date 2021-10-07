package com.leetcode.jiwen;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class _0322_CoinChange {

    public int coinChange(int[] coins, int amount) {

        if (amount <= 0) {
            return 0;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.addFirst(amount);
        visited.add(amount);
        int result = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size > 0) {
                int current = queue.removeLast();
                if (current == 0) {
                    return result;
                }
                for (int coin : coins) {
                    int next = current - coin;
                    if (next >= 0 && !visited.contains(next)) {
                        queue.addFirst(next);
                        visited.add(next);
                    }
                }
                size--;
            }
            result++;
        }
        return -1;
    }
}
