package cn.edu.scu.algorithms.sort;

/**
 * 快速排序
 * 前面
 */
public class InsertSort {

    private void sort(int[] A) {
        if (A.length <= 0) {
            return;
        }
        int temp = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= A[i - 1]) continue;
            // 记录待插入元素
            temp = A[i];
            // 开始查找待插入位置
            int j = i - 1;
            while (temp < A[j]) {
                A[j + 1] = A[j];
                j--;
                if (j == -1) break;
            }
            A[j+1] = temp;
        }
    }

    // 折半插入排序。“折半”体现在查找已排好序的插入位置
    private void sortB(int[] A) {
        if (A.length <= 0) {
            return;
        }
        int temp = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= A[i-1]) continue;
            // 记录待插入元素
            temp = A[i];
            // 开始查找待插入位置
            int lo = 0, hi = i - 1,mid = 0;
            while (lo <= hi) {
                mid = (lo + hi) / 2;
                if (temp < A[mid]) hi = mid - 1;
                else lo = mid + 1;

            }
            // 待插入位置后的元素后移
            int j = i - 1;
            while (j >= mid) {
                A[j + 1] = A[j];
                j--;
                if (j == -1) break;
            }
            A[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 2, 1,2,3,1,1,3,2};
        InsertSort insertSort = new InsertSort();
//        insertSort.sort(A);
        insertSort.sortB(A);

        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
