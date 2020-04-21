package cn.edu.scu.algorithms.exercises.leetcode.eazy;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidBrackets_20 {

    // 用一个栈来装左括号，遇到相同类型的右括号则出栈
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLeft(c)) {
                stack.push(c);
            } else {// 如果是右括号，则判断是否有相对应的左括号
                if (stack.empty()) return false;
                if (!isMatch(stack.pop(),c)) return false;
            }
        }
        return stack.empty();
    }

    // 是否属于左括号
    public boolean isLeft(Character c) {
        if (c == '{' || c == '[' || c == '(') {
            return true;
        }
        return false;
    }

    // 是否相匹配
    public boolean isMatch(Character l, Character r) {
        if (l == '{' && r == '}') {
            return true;
        }
        if (l == '[' && r == ']') {
            return true;
        }
        if (l == '(' && r == ')') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
