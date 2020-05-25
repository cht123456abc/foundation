package cn.edu.scu.algorithms.exercises.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        if(n == 0) return res;
        int m = matrix[0].length;
        if(m == 0) return res;

        // 右下左上方向
        int[] x = new int[]{0,1,0,-1};
        int[] y = new int[]{1,0,-1,0};
        int k = 0;
        int count = 0;
        int i = 0,j = 0;
        while(count < m*n){
            res.add(matrix[i][j]);
            count++;
            matrix[i][j] = -9999;
            int next_i = i + x[k];
            int next_j = j + y[k];
            // 如果下一步超过边界或者遇到已经遍历过的，就换方向
            if(next_i < 0 || next_i >= n || next_j < 0 || next_j >= m || matrix[next_i][next_j] == -9999) {
                k = (k+1) % 4;
                next_i = i + x[k];
                next_j = j + y[k];
            }
            i = next_i;
            j = next_j;
        }
        return res;
    }
}
