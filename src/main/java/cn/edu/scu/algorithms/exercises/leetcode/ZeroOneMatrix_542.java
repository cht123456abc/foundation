package cn.edu.scu.algorithms.exercises.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 */
public class ZeroOneMatrix_542 {

    public int[][] updateMatrix(int[][] matrix) {
        // 广搜+标记
        int n = matrix.length;
        if (n == 0) return matrix;
        int m = matrix[0].length;
        if (m == 0) return matrix;
        boolean[][] changed = new boolean[n][m];
        // 将每一个0加入队列
        Queue<Integer> x = new LinkedList<>();
        Queue<Integer> y = new LinkedList<>();
        // 第一次遍历，将所有的0一次加入队列
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    x.offer(i);
                    y.offer(j);
                    changed[i][j] = true;
                }
            }
        }
        while(!x.isEmpty()){
            int i = x.poll();
            int j = y.poll();
            if(i+1 < m && !changed[i + 1][j]) {
                matrix[i+1][j] = matrix[i][j] + 1;
                changed[i+1][j] = true;
                x.offer(i+1);
                y.offer(j);
            }
            if(j+1 < n && !changed[i][j+1]) {
                matrix[i][j+1] = matrix[i][j] + 1;
                changed[i][j+1] = true;
                x.offer(i);
                y.offer(j+1);
            }
            if(i-1>= 0 && !changed[i-1][j]) {
                matrix[i-1][j] = matrix[i][j] + 1;
                changed[i-1][j] = true;
                x.offer(i - 1);
                y.offer(j);
            }
            if(j-1 >= 0 && !changed[i][j-1]) {
                matrix[i][j-1] = matrix[i][j] + 1;
                changed[i][j-1] = true;
                x.offer(i);
                y.offer(j - 1);
            }
        }
        return matrix;
    }

}
