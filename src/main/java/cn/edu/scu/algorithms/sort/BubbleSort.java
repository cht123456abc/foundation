package cn.edu.scu.algorithms.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    // 冒泡排序
    private void bubbleSort(int[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {// 最多n-1次交换
            boolean flag = false;// 是否交换的标志
            for (int j = n - 1; j > i; j--) {
                if (A[j - 1] > A[j]) {
                    swap(A, j - 1, j);
                    flag = true;
                }
            }
            if (!flag) {// 如果一次都没有交换
                return;
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 2, 1,2,3,1,1,3,2};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
