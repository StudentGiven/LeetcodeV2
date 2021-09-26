package com.leetcode.jiwen;

import java.util.Stack;

public class _0020_ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (current == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            } else if (current == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            } else if (current == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
