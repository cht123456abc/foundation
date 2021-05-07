package cn.edu.scu.algorithms.exercises.leetcode;


import java.util.Arrays;

/**
 * 932. 漂亮数组
 * 对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：
 *
 * 对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。
 *
 * 那么数组 A 是漂亮数组。
 *
 *
 *
 * 给定 N，返回任意漂亮数组 A（保证存在一个）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：4
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：5
 * 输出：[3,1,2,5,4]
 *
 *
 * 提示：
 *
 * 1 <= N <= 1000
 */
public class BeautifulArray_932 {

    // 分治
    public int[] beautifulArray(int N) {
        int[] A = new int[N];
        Arrays.fill(A,1);
        sub(A,0,N-1);
        return A;
    }

    public void sub(int[] A,int lo,int hi){
        if(lo >= hi) return;
        int mid = lo + (hi-lo)/2;
        sub(A,lo,mid);
        sub(A,mid+1,hi);
        for(int i = lo;i <= mid;i++){
            A[i] = 2*A[i]-1;
        }
        for(int i = mid+1;i <= hi;i++){
            A[i] = 2*A[i];
        }
        return;
    }
}
