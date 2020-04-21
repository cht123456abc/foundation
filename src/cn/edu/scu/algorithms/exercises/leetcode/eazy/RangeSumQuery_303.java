package cn.edu.scu.algorithms.exercises.leetcode.eazy;

/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 */
public class RangeSumQuery_303 {

    private int[] sums;// 记录的是0-i的和

    public RangeSumQuery_303(int[] nums) {
        if (nums.length == 0) return;
        sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i = 1;i < nums.length;i++){
            sums[i] = sums[i-1] + nums[i];
        }

    }

    // 多次调用sumRange方法，所以该方法得实现T = O(1)的时间复杂度。
    public int sumRange(int i, int j) {
        if (i <= 0) return sums[j];
        return sums[j] - sums[i-1];
    }
}
