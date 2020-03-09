package cn.edu.scu.exercises.leetcode.eazy;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */

public class MergeTwoSortedArrays_88 {

    // 双指针从后往前
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            // 谁越大谁放后面
            if (nums2[j] > nums1[i]) {
                nums1[i + n] = nums2[j--];
                n--;
            } else {
                nums1[i + n] = nums1[i--];
            }
        }
        // i从一开始就小于0或者经过循环变为小于0,将nums2剩余的n个数放到num1前面的n个位置。
        while (n > 0) {
            nums1[n - 1] = nums2[n - 1];
            n--;
        }
    }
}
