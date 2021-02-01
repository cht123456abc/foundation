package cn.edu.scu.algorithms.exercises.cracking_the_coding_interview;


/**
 * 面试题 03.01. 三合一
 * 三合一。描述如何只用一个数组来实现三个栈。
 *
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 *
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * 示例1:
 *
 *  输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 示例2:
 *
 *  输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, -1, -1]
 */
public class TripleInOne_0301 {

    private int[] A;
    private int[] point;
    private int stackSize;

    public TripleInOne_0301(int stackSize) {
        this.A = new int[stackSize * 3];
        this.point = new int[3];
        this.stackSize = stackSize;

        this.point[0] = 0;
        this.point[1] = stackSize;
        this.point[2] = 2 * stackSize;

    }

    public void push(int i, int value) {
        // push判断栈满
        if(point[i] == (i+1)*stackSize) return;
        A[point[i]++] = value;
    }

    public int pop(int i) {
        // pop判断栈空
        if(isEmpty(i)) return -1;
        return A[--point[i]];

    }

    public int peek(int i) {
        if(isEmpty(i)) return -1;
        return A[point[i]-1];
    }

    public boolean isEmpty(int i) {
        return point[i] == i*stackSize;
    }
}
