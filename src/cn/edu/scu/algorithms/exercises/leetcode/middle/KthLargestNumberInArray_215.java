package cn.edu.scu.algorithms.exercises.leetcode.middle;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class KthLargestNumberInArray_215 {

    // 用快速排序的思想，寻找切分点，当切分点正好位于第k个位置的时候，则返回这个位置的元素。
    public int findKthLargest(int[] nums, int k) {
        int lo = 0,hi = nums.length-1;
        int pos = partition(nums, lo, hi);
        while (pos != k-1) {
            if (pos < k-1) pos = partition(nums, pos + 1, hi);
            if (k-1 < pos) pos = partition(nums, lo, pos-1);
        }
        return nums[pos];

    }

    // 寻找切分点函数,左大右小
    public int partition(int[] nums, int lo, int hi) {
        int partition = nums[lo];
        while (lo < hi) {
            while (lo < hi && nums[hi] <= partition) hi--;
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] >= partition) lo++;
            nums[hi] = nums[lo];
        }
        nums[lo] = partition;
        return lo;
    }

    // 方法二：用堆
    public int findKthLargest1(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(new KthLargestNumberInArray_215().findKthLargest(nums,k));
    }

}
