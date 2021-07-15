package com.xiebiao.leetcode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * @author bjxieb
 * @date 7/15/21
 **/
public class _32 {

    public static void main(String[] args) {
        //  String s = ")()(())";
        //String s = "(()";
        // String s = ")()())";
        String s = "(()()";
        System.out.println(_32.longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static int longestValidParentheses2(String s) {
        int len = 0, start = 0, n = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();//弹出
                    if (stack.isEmpty()) {//栈中只有一个匹配`(`
                        len = Math.max(len, i - start + 1);
                    } else {//栈中不止一个匹配`(`
                        len = Math.max(len, i - stack.peek());
                    }
                }
            }
        }
        return len;
    }

}
