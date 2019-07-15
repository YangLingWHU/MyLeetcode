package StackQueue;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class ValidParentheses20 {
    public boolean isValid(String s) {
        if (s.length() == 0 || s == null) {
            return true;
        }
        boolean rt = true;
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char currentStack = stack.pop();
                if ((currentChar == ')' && currentStack == '(') ||
                        (currentChar == '}' && currentStack == '{') ||
                        (currentChar == ']' && currentStack == '[')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (stack.size() != 0) {
            return false;
        }
        return rt;
    }
}
