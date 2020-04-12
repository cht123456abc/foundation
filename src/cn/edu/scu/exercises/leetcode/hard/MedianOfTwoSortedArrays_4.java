package cn.edu.scu.exercises.leetcode.hard;

/**
 * 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays_4 {

    // 条件一：
    //     对于分别对应A和B的切分位置i,j,满足：
    //     i + j == m - i + n - j;左右部分个数相同
    // 条件二：
    //     A[i-1] > B[j] && B[j-1] < A[i]
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            return findMedianSortedArrays(B, A);
        }
        // 用二分法寻找A数组的完美切分位置i
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                // 边界条件单独考虑
                int maxLeft = 0;
                if (i == 0) maxLeft = B[j-1];
                else if (j == 0) maxLeft = A[i-1];
                else maxLeft = Math.max(A[i-1], B[j-1]);
                if ( (m + n) % 2 == 1 ) return maxLeft; // 为奇数，不需要考虑右半部分

                int minRight = 0;
                if (i == m) minRight = B[j];
                else if (j == n) minRight = A[i];
                else minRight = Math.min(B[j], A[i]);

                return (maxLeft + minRight) / 2.0;// 为偶数
            }
        }
        return 0.0;
    }
}
