package cn.edu.scu.exam;

import java.util.ArrayList;

/**
 * cn.edu.scu.exam.螺旋矩阵 相似的企业真题
 * 时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 64M，其他语言128M 热度指数：39619
 * 本题知识点： 数组
 *  算法知识视频讲解
 * 题目描述
 * 给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
 * 示例1
 * 输入
 * 复制
 * [[1,2,3],[4,5,6],[7,8,9]]
 * 返回值
 * 复制
 * [1,2,3,6,9,8,7,4,5]
 */
public class 螺旋矩阵 {

    public static void main(String[] args) {


    }

    public ArrayList<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();

        int n = matrix.length;
        if (n == 0) {
            return res;
        }
        int m = matrix[0].length;
        if(m == 0) return res;

        boolean[][] visited = new boolean[n][m];

        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};
        int i = 0,j = 0;
        int dir = 0;
        for (int k = 0; k < n*m; k++) {
            visited[i][j] = true;
            res.add(matrix[i][j]);

            int nexti = i + x[dir];
            int nextj = j + y[dir];
            if (nexti == n || nextj == m || nextj < 0 || visited[nexti][nextj]) {
                dir = (dir+1) % 4;
            }
            i += x[dir];
            j += y[dir];
        }
        return res;

    }
}
