package com.heicheoa.jiwen;

import java.util.Stack;

public class _004_FindWinner {

    // There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
    // Alice and Bob take turns, with Alice starting first.
    // On each player's turn, that player can take 2 consecutive stones where piles[i] == piles[i + 1].
    // The game continues until nobody can make any move. Return true if Alice can win.
    // Ex. [1, 2, 2, 3, 3, 1, 1]
    // Alice take [2, 2], Bob [3, 3], Alice[1, 1]. 剩下一个1没办法take, Alice赢

    public static boolean findWinner(int[] piles) {
        boolean aliceWin = false;
        int n = piles.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < n) {
            if (stack.empty() || piles[i] != stack.peek()) {
                stack.push(piles[i]);
            } else {
                stack.pop();
                aliceWin = !aliceWin;
            }
            i++;
        }
        return aliceWin;
    }

    public static void main(String[] args) {
        int[] piles = {1, 2, 2, 3, 3, 1, 1};
        System.out.println(findWinner(piles));
    }
}
