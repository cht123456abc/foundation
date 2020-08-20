package cn.edu.scu.algorithms.sort;

/**
 * 选择排序
 */
public class SelectSort {

    private void sort(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < A.length; j++) {
                if (A[j] < A[min]) min = j;
            }
            if (min !=i) swap(A, min, i);
        }
    }

    private void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 2, 1,1,3,2,2,3,1};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }

    }
}
