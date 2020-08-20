package cn.edu.scu.algorithms.sort;

import sun.security.util.Length;

/**
 * 堆排序
 */
public class HeapSort {

    // 建立大顶堆
    private void buildMaxHeap(int[] A, int len) {
        for (int i = len / 2; i > 0; i--) {
            adjustDown(A, i, len);
        }
    }

    // 将元素k向下进行调整
    private void adjustDown(int[] A, int k, int len) {
        A[0] = A[k];// A[0]暂存
        for (int i = 2 * k; i <= len; i *= 2) {
            if (i < len && A[i] < A[i + 1]) {
                i++;
            }
            if (A[0] >= A[i]) break;
            else {
                A[k] = A[i];
                k = i;
            }
        }
        A[k] = A[0];
    }

    private void sort(int[] A) {
        buildMaxHeap(A, A.length - 1);
        for (int i = A.length - 1; i > 1; i--) {
            swap(A, i, 1);
            adjustDown(A, 1, i - 1);
        }
    }

    private void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public static void main(String[] args) {
        // index从1开始
        int[] A = new int[]{-1, 3, 2, 1, 4, 7, 9, 5, 6, 8};// 第一个数不存
        HeapSort heapSort = new HeapSort();
        heapSort.sort(A);
        for (int i = 1; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
