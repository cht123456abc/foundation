package cn.edu.scu.algorithms.exercises.cracking_the_coding_interview;

/**
 * 面试题 01.07. 旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 *
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class RotateMatrix_0107 {

    // 原地算法
    public void rotate(int[][] matrix) {

        // 根据旋转矩阵和平移矩阵得到旋转后坐标与原坐标的映射关系
        // [i`,j`] = [j,n-1-i] ,其中n为矩阵的边长

        int n = matrix.length;
        if (n <= 1) return;

        // 由外围到中心
        for (int i = 0; i < n / 2; i++) {
            // 沿着边
            for (int j = i; j < n - 1 - i; j++) {
                int last = matrix[i][j];
                // 旋转4次
                for (int N = 4; N > 0; N--) {
                    int i_ = j;
                    int j_ = n - 1 - i;
                    int now = matrix[i_][j_];
                    matrix[i_][j_] = last;
                    last = now;
                    i = i_;
                    j = j_;
                }
            }
        }
    }

    // 非原地算法
    public void rotate1(int[][] matrix) {

        // 根据旋转矩阵和平移矩阵得到旋转后坐标与原坐标的映射关系
        // [i`,j`] = [j,n-1-i] ,其中n为矩阵的边长


        int n = matrix.length;
        if (n <= 0) return;

        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }
}

