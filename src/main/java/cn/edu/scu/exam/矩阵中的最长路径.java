package cn.edu.scu.exam;

public class 矩阵中的最长路径 {

    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 递增路径的最大长度
         *
         * @param matrix int整型二维数组 描述矩阵的每个数
         * @return int整型
         */
        // 纯dp
        public int solve(int[][] matrix) {

            boolean flush = true;

            int n = matrix.length;
            int m = matrix[0].length;
            int[][] dp = new int[n][m];

            int res = 0;

            while (flush) {
                flush = false;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (check(i - 1, j, n, m) && matrix[i][j] > matrix[i - 1][j] && dp[i-1][j]+1 > dp[i][j]) {
                            dp[i][j] = dp[i - 1][j] + 1;
                            flush = true;
                        }
                        if (check(i, j - 1, n, m) && matrix[i][j] > matrix[i][j - 1] && dp[i][j - 1] + 1> dp[i][j]) {
                            dp[i][j] = dp[i][j - 1] + 1;
                            flush = true;
                        }
                        if (check(i + 1, j, n, m) && matrix[i][j] > matrix[i + 1][j] && dp[i + 1][j] + 1> dp[i][j]) {
                            dp[i][j] = dp[i + 1][j] + 1;
                            flush = true;
                        }
                        if (check(i, j + 1, n, m) && matrix[i][j] > matrix[i][j + 1] && dp[i][j + 1] + 1> dp[i][j]) {
                            dp[i][j] = dp[i][j + 1] + 1;
                            flush = true;
                        }
                        res = Math.max(res,dp[i][j]);
                    }
                }
            }

            return res+1;
        }

        private boolean check(int i, int j, int n, int m) {
            return i >= 0 && j >= 0 && i < n && j < m;
        }
    }

    /**
     * 记忆化搜索
     */
    public class Solution1 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 递增路径的最大长度
         * @param matrix int整型二维数组 描述矩阵的每个数
         * @return int整型
         */
        int[][] dp;
        int[] dirs = new int[]{0,1,0,-1,0};
        int m, n;
        public int solve (int[][] matrix) {
            // write code here
            int max = 1;
            m = matrix.length;
            n = matrix[0].length;
            dp = new int[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    max = Math.max(max,  dfs(matrix, i, j));
                }
            }
            return max;
        }

        private int dfs(int[][] matrix, int x, int y) {
            if(dp[x][y] != 0) {
                return dp[x][y];
            }

            dp[x][y] = 1;
            for(int k = 0; k < 4; k++) {
                int nx = x + dirs[k];
                int ny = y + dirs[k+1];
                if(nx>=0 && nx<m && ny>=0 && ny<n && matrix[nx][ny] < matrix[x][y]) {
                    dp[x][y] = Math.max(dp[x][y], 1+dfs(matrix, nx, ny));
                }
            }
            return dp[x][y];
        }
    }
}
