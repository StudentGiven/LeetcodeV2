package com.leetcode.jiwen;

import java.util.ArrayList;
import java.util.List;

public class _0022_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        dfs("", n, n, result);

        return result;
    }

    // left: how many '(' left for us to use
    // right: how many ')' left for us to use
    private void dfs(String current, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }

        if (left > 0) {
            dfs(current + '(', left - 1, right, result);
            // No need to delete the last char when back tracking since String is immutable.
            // If use StringBuilder, delete the last char is needed.
        }

        if (right > left) {
            dfs(current + ')', left, right - 1, result);
        }

    }

}
