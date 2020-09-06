package cn.edu.scu.algorithms.exercises.SwordTowardOffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *
 *
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 */
public class MaxmumInQueue_59_II {


    // 单调队列
    Deque<Integer> deque;

    // 主队列
    Queue<Integer> queue;


    public MaxmumInQueue_59_II() {
        this.deque = new ArrayDeque();
        this.queue = new LinkedList();
    }

    public int max_value() {
        return queue.isEmpty() || deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        // 保证双端队列单调
        while(!deque.isEmpty() && deque.peekLast() < value){
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int ret = queue.poll();
        // 判断是否poll deque
        if(!deque.isEmpty() && deque.peekFirst().equals(ret)) deque.pollFirst();
        return ret;
    }
}
