package cn.edu.scu.algorithms.exercises.cracking_the_coding_interview;


/**
 * 面试题 01.08. 零矩阵
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */
public class ZeroMatrix_0108 {


    public void setZeroes(int[][] matrix) {

        int n = matrix.length;
        if(n == 0) return;
        int m = matrix[0].length;
        if(m == 0) return;
        boolean[] X = new boolean[n];
        boolean[] Y = new boolean[m];
        for(int i = 0 ;i < n;i++){
            for(int j = 0;j < m;j++){
                if(matrix[i][j] == 0){
                    X[i] = true;
                    Y[j] = true;
                }

            }
        }

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(X[i] || Y[j]) matrix[i][j] = 0;
            }
        }



    }
}
