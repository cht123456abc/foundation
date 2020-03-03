package cn.edu.scu.algorithms.search;

/**
 * 二分查找
 * 前提数组是有序的
 */
public class BinarySearch {

    private int search(int[] list, int key) {
        int lo = 0,hi = list.length-1,mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (list[mid] == key) {
                return mid;
            } else if (key < list[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        int[] list = new int[]{1, 3, 5, 6, 7, 8, 9, 22, 34};
        int res = binarySearch.search(list, 6);
        System.out.println(res);
    }
}
