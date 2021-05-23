package cn.edu.scu.algorithms.exercises.leetcode;


import java.util.Stack;

/**
 * 1856. 子数组最小乘积的最大值
 * 一个数组的 最小乘积 定义为这个数组中 最小值 乘以 数组的 和 。
 *
 * 比方说，数组 [3,2,5] （最小值是 2）的最小乘积为 2 * (3+2+5) = 2 * 10 = 20 。
 * 给你一个正整数数组 nums ，请你返回 nums 任意 非空子数组 的最小乘积 的 最大值 。由于答案可能很大，请你返回答案对  109 + 7 取余 的结果。
 *
 * 请注意，最小乘积的最大值考虑的是取余操作 之前 的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数 保存。
 *
 * 子数组 定义为一个数组的 连续 部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,2]
 * 输出：14
 * 解释：最小乘积的最大值由子数组 [2,3,2] （最小值是 2）得到。
 * 2 * (2+3+2) = 2 * 7 = 14 。
 * 示例 2：
 *
 * 输入：nums = [2,3,3,1,2]
 * 输出：18
 * 解释：最小乘积的最大值由子数组 [3,3] （最小值是 3）得到。
 * 3 * (3+3) = 3 * 6 = 18 。
 * 示例 3：
 *
 * 输入：nums = [3,1,5,6,4,2]
 * 输出：60
 * 解释：最小乘积的最大值由子数组 [5,6,4] （最小值是 4）得到。
 * 4 * (5+6+4) = 4 * 15 = 60 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 107
 */
public class MaxValueInSubarrayMinProduct_1856 {

    // 前缀和 + 单调栈
    public int maxSumMinProduct(int[] nums) {
        long mod = (long)1e9+7;
        int n = nums.length;

        // 前缀和
        long[] pre_sum = new long[n];
        pre_sum[0] = nums[0];
        for(int i = 1;i < n;i++){
            pre_sum[i] = pre_sum[i-1] + nums[i];
        }

        // 单调栈 拿第一个小于元素的值
        Stack<Integer> stack = new Stack<>();
        int[] idxl = new int[n];
        int[] idxr = new int[n];
        for(int i = 0;i < n;i++){
            idxr[i] = n;
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                idxr[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.clear();
        for(int i = n-1;i >=0;i--){
            idxl[i] = -1;
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                idxl[stack.pop()] = i;
            }
            stack.push(i);
        }

        // 区间最小值
        long res = 0;
        for(int i = 0;i < n;i++){
            int left=idxl[i],right=idxr[i];
            long sum = pre_sum[right-1] - (left < 0 ? 0 : pre_sum[left]);
            res = Math.max(res,sum * nums[i]);
        }
        return (int)(res % mod);
    }


}
