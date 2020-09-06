package cn.edu.scu.algorithms.dp;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinimumPathSum_64 {


    int[][] dp;// 记录每个格子的最优解
    int[][] Grid;// 保存全局网格信息
    // 方法一：记忆化搜索
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        // 初始化dp数组为-1
        dp = new int[n][m];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        Grid = grid;
        return dfs(n-1, m-1);
    }

    // 1.状态表达式
    private int dfs(int x, int y) {
        // 2.确定边界
        if (x == 0 && y == 0) return Grid[0][0];
        if (x < 0 || y < 0) return Integer.MAX_VALUE;
        // 4.记忆化
        if (dp[x][y] != -1) return dp[x][y];
        // 3.状态转移
        dp[x][y] = Math.min(dfs(x - 1, y), dfs(x, y - 1)) + Grid[x][y];
        return dp[x][y];
    }

    // 方式二：递推
    public int minPathSum1(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        // 决策边界
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) dp[i][0] = dp[i-1][0] + grid[i][0];
        for (int j = 1; j < m; j++) dp[0][j] = dp[0][j-1] + grid[0][j];
        // 状态转移
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {

    }
}
