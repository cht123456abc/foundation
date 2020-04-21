package cn.edu.scu.algorithms.exercises.leetcode.eazy;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class ContainsDuplicatesII_219 {

    // T = O(n) 哈希表
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();// 存储每个数字出现的最近索引
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    // T = O(n*k) 滑动窗口
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if (k > nums.length-1) k = nums.length-1;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j <= i+k && j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}
