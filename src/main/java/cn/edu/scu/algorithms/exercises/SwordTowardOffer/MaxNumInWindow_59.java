package cn.edu.scu.algorithms.exercises.SwordTowardOffer;

import java.util.Deque;
import java.util.LinkedList;

/**i
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class MaxNumInWindow_59 {

    // 用双端队列构成的单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k <= 0 || nums.length <= 0) return new int[0];
        int[] res = new int[nums.length+1-k];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1 - k, j = 0; j < nums.length; i++, j++) {
            if(i > 0 && nums[i-1] == deque.peekFirst()) deque.pollFirst();// 使得单调队列的队头（最大值）如果被滑动窗口移除了，相应的队列里面也要移除
            while(!deque.isEmpty() && deque.peekLast() < nums[j]) deque.pollLast();// 使得队列保持单调递减
            deque.offer(nums[j]);
            if(i >= 0) res[i] = deque.peekFirst();// 形成窗口后，将最大值加入结果\
        }
        return res;

    }
}
