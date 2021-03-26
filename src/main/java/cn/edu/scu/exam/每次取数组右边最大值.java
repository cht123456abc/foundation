package cn.edu.scu.exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 每次取索引右边最大值替换当前索引数据值
 */
public class 每次取数组右边最大值 {

    public static void main(String[] args) {


        int[] arr = new int[]{7, 18, 5, 4, 6, 1};
        int[] res = function1(arr);
        for (int re : res) {
            System.out.println(re);

        }

    }

    public static int[] function(int[] arr) {

        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int max = -1;

            for (int j = i+1; j < arr.length; j++) {
                max = Math.max(max, arr[j]);
            }
            res[i] = max;
        }
        return res;
    }

    public static int[] function1(int[] array) {
        int n = array.length;
        int max = -1;
        for (int i = n-1; i >= 0; i--) {
            max = Math.max(max, array[i]);
            array[i] = max;
        }
        array[n-1] = -1;
        return array;
    }
}
