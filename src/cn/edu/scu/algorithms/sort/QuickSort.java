package cn.edu.scu.algorithms.sort;

/**
 * 交换排序
 */
public class QuickSort {

    // 快速排序
    private void quickSort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    // 分治
    private void quickSort(int[] A, int lo, int hi) {
        if (lo < hi) {
            int pivotpos = Partition(A, lo, hi);
            quickSort(A, lo, pivotpos - 1);
            quickSort(A, pivotpos + 1, hi);
        }
    }

    // 找到枢轴值得位置
    private int Partition(int[] A, int lo, int hi) {
        int pivot = A[lo];
        while (lo < hi) {
            while (lo < hi && A[hi] >= pivot) --hi;// 找到右半部分比pivot小的数
            A[lo] = A[hi];
            while (lo < hi && A[lo] <= pivot) ++lo;// 找到左半部分比pivot大的数
            A[hi] = A[lo];
        }
        A[lo] = pivot;
        return lo;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 2, 1,2,3,1,1,3,2};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
