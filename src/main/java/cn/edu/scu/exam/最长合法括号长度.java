package cn.edu.scu.exam;

import java.util.Stack;

public class 最长合法括号长度 {

    // 动态规划方法
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];// dp[i] 表示的是以i结尾的最长合法括号子串的长度。由此定义可知，以’（‘结尾的值为0；

        // 寻找状态转移方程的初始动机： 寻找能够转移的”原子问题“
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {// i-dp[i-1]-1表示的是与右括号相匹配的左括号 ，比如这种"((()))"
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    // 堆栈方法
    public int longestValidParentheses1(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();// 存的是数组元素的下标

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
}
