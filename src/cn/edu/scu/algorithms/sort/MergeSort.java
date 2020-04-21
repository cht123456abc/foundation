package cn.edu.scu.algorithms.sort;

/**
 * 归并排序
 */
public class MergeSort {

    // 用一个辅助数组aux，复制A,将两段有序数组合并为一个有序数组
    private void merge(int[] A, int lo, int mid, int hi) {
        int[] aux = new int[A.length];
        System.arraycopy(A, 0, aux, 0, aux.length);

        int i = lo, j = mid + 1, k = i;
        for (; i <= mid && j <= hi; k++) {
            if (aux[i] <= aux[j]) {
                A[k] = aux[i++];
            } else {
                A[k] = aux[j++];
            }

        }
        while (i <= mid) A[k++] = aux[i++];
        while (j <= hi) A[k++] = aux[j++];
    }

    // 分治，自顶向下
    private void sort(int[] A, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            sort(A, lo, mid);
            sort(A, mid + 1, hi);
            merge(A, lo, mid, hi);
        }
    }

    private void sort(int[] A) {
        sort(A, 0, A.length - 1);
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 2, 1, 3, 1, 2, 1, 2, 3};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);

        }

    }
}
