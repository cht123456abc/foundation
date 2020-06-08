package cn.edu.scu.algorithms.dp;

/**
 * 1473. 给房子涂色 III
 * 在一个小城市里，有 m 个房子排成一排，你需要给每个房子涂上 n 种颜色之一（颜色编号为 1 到 n ）。有的房子去年夏天已经涂过颜色了，所以这些房子不需要被重新涂色。
 *
 * 我们将连续相同颜色尽可能多的房子称为一个街区。（比方说 houses = [1,2,2,3,3,2,1,1] ，它包含 5 个街区  [{1}, {2,2}, {3,3}, {2}, {1,1}] 。）
 *
 * 给你一个数组 houses ，一个 m * n 的矩阵 cost 和一个整数 target ，其中：
 *
 * houses[i]：是第 i 个房子的颜色，0 表示这个房子还没有被涂色。
 * cost[i][j]：是将第 i 个房子涂成颜色 j+1 的花费。
 * 请你返回房子涂色方案的最小总花费，使得每个房子都被涂色后，恰好组成 target 个街区。如果没有可用的涂色方案，请返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
 * 输出：9
 * 解释：房子涂色方案为 [1,2,2,1,1]
 * 此方案包含 target = 3 个街区，分别是 [{1}, {2,2}, {1,1}]。
 * 涂色的总花费为 (1 + 1 + 1 + 1 + 5) = 9。
 * 示例 2：
 *
 * 输入：houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
 * 输出：11
 * 解释：有的房子已经被涂色了，在此基础上涂色方案为 [2,2,1,2,2]
 * 此方案包含 target = 3 个街区，分别是 [{2,2}, {1}, {2,2}]。
 * 给第一个和最后一个房子涂色的花费为 (10 + 1) = 11。
 * 示例 3：
 *
 * 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[1,10],[10,1],[1,10]], m = 5, n = 2, target = 5
 * 输出：5
 * 示例 4：
 *
 * 输入：houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n = 3, target = 3
 * 输出：-1
 * 解释：房子已经被涂色并组成了 4 个街区，分别是 [{3},{1},{2},{3}] ，无法形成 target = 3 个街区。
 *
 *
 * 提示：
 *
 * m == houses.length == cost.length
 * n == cost[i].length
 * 1 <= m <= 100
 * 1 <= n <= 20
 * 1 <= target <= m
 * 0 <= houses[i] <= n
 * 1 <= cost[i][j] <= 10^4
 */
public class PrintHouseIII_1473 {

    final int MAXM = 105;
    final int MAXN = 25;
    int[][][] dp = new int[MAXM][MAXM][MAXN];// 第i个房子前，形成的第j个街区，第i个房子涂成的颜色k。

    // 参考 坑神的答案
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // 初始化
        for(int i = 0;i <= m;i++){
            for(int j = 0;j <= m;j++){
                for(int k = 0;k <= n;k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        // 边界条件,考虑第一个房子所涂的不同颜色
        for(int c = 1;c <= n;c++){
            if(houses[0] != 0 && houses[0] != c) continue;// 不合法条件
            if(houses[0] == 0) {
                dp[0][0][c] = cost[0][c-1];
            }else{
                dp[0][0][c] = 0;
            }
        }

        // 状态转移
        for(int i = 1;i < m;i++){
            for(int c = 1;c <= n;c++){
                if(houses[i] != 0 && houses[i] != c) continue;
                int p = (houses[i] == 0 ? cost[i][c-1] : 0);
                for(int lc = 1;lc <= n;lc++){
                    for(int lblc = 0;lblc < m-1;lblc++) {
                        int lastp = dp[i-1][lblc][lc];
                        if(lastp == -1) continue;
                        int blc = (lc == c ? 0 : 1) + lblc;
                        if(dp[i][blc][c] == -1 || dp[i][blc][c] > lastp + p){
                            dp[i][blc][c] = lastp + p;
                        }
                    }
                }
            }
        }

        // 取最小结果
        int res = -1;
        for(int c = 1;c <= n;c++){
            int targetp = dp[m-1][target-1][c];
            if(targetp == -1) continue;
            if(res == -1 || res > targetp) res = targetp;
        }
        return res;
    }
}
