package cn.edu.scu.algorithms.exercises.leetcode;

import java.util.*;

/**
 * 946. 验证栈序列
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *
 *
 * 提示：
 *
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 */
public class ValidStackSequences_946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 只要poped里面存在一个元素，该元素比当前栈顶元素小，就视为invalid。
        int n = pushed.length;
        Set<Integer> set = new HashSet<>();// 记录索引，方便查找
        Stack<Integer> stack = new Stack<>();
        int ptr = -1;
        for(int i = 0;i < n;i++){
            int pop = popped[i];
            if(set.contains(pop)){
                if(!stack.peek().equals(pop)) return false;
                else {
                    stack.pop();
                    set.remove(pop);
                }
            }else{
                // 从后续元素中找到
                for(int j = ptr+1;j < n;j++){
                    int push = pushed[j];
                    if(push == pop){
                        ptr = j;
                        break;
                    }
                    stack.push(push);
                    set.add(push);
                }
            }
        }
        return true;
    }

}
