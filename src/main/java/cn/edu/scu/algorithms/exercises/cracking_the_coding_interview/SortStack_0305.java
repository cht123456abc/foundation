package cn.edu.scu.algorithms.exercises.cracking_the_coding_interview;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 面试题 03.05. 栈排序
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null,null,null,1,null,2]
 * 示例2:
 * <p>
 * 输入：
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 * 输出：
 * [null,null,null,null,null,true]
 * 说明:
 * <p>
 * 栈中的元素数目在[0, 5000]范围内。
 */
public class SortStack_0305 {

    Deque<Integer> minStack; // 单调递减栈
    Deque<Integer> tempStack; // 辅助栈

    public SortStack_0305() {
        minStack = new LinkedList<>();
        tempStack = new LinkedList<>();
    }

    public void push(int val) {
        while (!minStack.isEmpty() && minStack.peek() < val) {
            tempStack.push(minStack.pop());
        }
        minStack.push(val);
        while (!tempStack.isEmpty()) {
            minStack.push(tempStack.pop());
        }
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }
        minStack.pop();
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }

    public boolean isEmpty() {
        return minStack.isEmpty();
    }


}
