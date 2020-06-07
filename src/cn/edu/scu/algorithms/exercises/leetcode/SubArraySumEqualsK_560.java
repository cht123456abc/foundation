package cn.edu.scu.algorithms.exercises.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class SubArraySumEqualsK_560 {

    public int subarraySum(int[] nums, int k) {
        // 前缀和 + 哈希,T = O(n)算法
        int current_sum = 0;
        Map<Integer,Integer> map = new HashMap<>();// 统计相同前缀和的个数
        map.put(0,1);
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            current_sum += nums[i];
            int pre_sum = current_sum - k;
            if(map.containsKey(pre_sum)) res += map.get(pre_sum);
            map.put(current_sum,map.getOrDefault(current_sum,0)+1);
        }
        return res;


    }
}
