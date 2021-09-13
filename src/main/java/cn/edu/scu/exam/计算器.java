package cn.edu.scu.exam;

import java.util.*;


/**
 * 表达式求值
 */
public class 计算器 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回表达式的值
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public int solve (String s) {
        // 遇到右括号或当前运算符优先级小于等于栈内优先级时进行计算：消耗两个操作数、一个运算符、一个左括号（为右括号时）

        // 清楚空格
        s = s.replaceAll(" ", "");
        // 为操作符设置优先级
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        // 操作数栈
        Stack<Integer> nums = new Stack<>();
        // 第一个数设置为0
        nums.push(0);
        // 运算符栈
        Stack<Character> ops = new Stack<>();

        char[] ss = s.toCharArray();
        int n = ss.length;
        for(int i = 0;i < n;i++){
            Character c = ss[i];
            if (c.equals('(')) {
                ops.push(c);
            } else if (c.equals(')')) {
                while (!ops.isEmpty() && !ops.peek().equals('(')) {
                    nums.push(cal(nums, ops));
                }
                ops.pop();
            } else {
                if (Character.isDigit(c)) {
                    int num = 0;
                    while (i < n && Character.isDigit(ss[i])) {
                        num = 10 * num + (ss[i]-'0');
                        i++;
                    }
                    nums.push(num);
                    i = i - 1;
                } else {
                    if (i > 0 && (ss[i - 1] == '(' || ss[i - 1] == '-' || ss[i - 1] == '+')) {
                        nums.push(0);
                    } else {
                        while (!ops.isEmpty() && !ops.peek().equals('(') && priority.get(ops.peek()) >= priority.get(c)) {
                            nums.push(cal(nums, ops));
                        }
                        ops.push(c);
                    }
                }
            }
        }

        while (!ops.isEmpty()) {
            nums.push(cal(nums, ops));
        }
        return nums.pop();
    }

    public int cal(Stack<Integer> nums, Stack<Character> ops) {
        int b = nums.pop();
        int a = nums.pop();
        char op = ops.pop();
        int ret = 0;
        switch (op) {
            case '+':
                ret = a+b;
                break;
            case '-':
                ret = a-b;
                break;
            case '*':
                ret = a*b;
                break;
            default:
                break;
        }
        return ret;
    }


}
