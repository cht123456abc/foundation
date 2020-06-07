package cn.edu.scu.algorithms.exercises.leetcode;

import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStack_155 {

    private Stack<Integer> stack;
    private Stack<Integer> aux;// 用一个辅助栈来存储最小的几个数。

    /** initialize your data structure here. */
    public MinStack_155() {
        this.stack = new Stack<>();
        this.aux = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (aux.isEmpty() || x < aux.peek()) {
            aux.push(x);
        } else {
            aux.push(aux.peek());
        }
    }

    public void pop() {
        stack.pop();
        aux.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return aux.peek();
    }
}
