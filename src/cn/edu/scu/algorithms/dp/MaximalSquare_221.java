package cn.edu.scu.algorithms.dp;

/**
 * 221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
public class MaximalSquare_221 {

    // dp解
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;
        int len = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;// 关键
                    len = Math.max(len,dp[i][j]);
                }
            }
        }
        return len * len;
    }

    // 暴力解
    public int maximalSquare1(char[][] matrix) {
        // 暴力循环判断是否能形成正方形
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') res = Math.max(res,square(matrix,i,j));
            }
        }
        return res * res;

    }

    // 返回以i,j为左上角顶点的正方形的最大面积
    public int square(char[][] matrix,int x,int y){
        int n = matrix.length;
        int m = matrix[0].length;
        int max_probable_len = Math.min(n-x,m-y);
        int max_len = 1;
        for (int k = 1; k < max_probable_len; k++) {
            // 判断新增的列和行
            boolean flag = true;
            for (int i = 0; i <= k; i++) {
                if (matrix[x+i][y+k] == '0' || matrix[x+k][y+i] == '0') {
                    flag = false;
                    break;
                }
            }
            // 更新边长
            if (flag)
                max_len = Math.max(max_len,k+1);
            else break;
        }
        return max_len;
    }

}
