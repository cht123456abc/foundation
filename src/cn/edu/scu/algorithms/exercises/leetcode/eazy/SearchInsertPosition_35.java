package cn.edu.scu.algorithms.exercises.leetcode.eazy;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsertPosition_35 {

    // 用二分法来搜索位置
    public int searchInsert(int[] nums, int target) {
        int lo = 0,hi = nums.length-1,mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (target < nums[mid]) hi = mid - 1;
            else if (target > nums[mid]) lo = mid + 1;
            else break;
        }
        return  mid;
    }
}
