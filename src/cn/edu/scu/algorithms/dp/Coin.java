package cn.edu.scu.algorithms.dp;

/**
 * 面试题 08.11. 硬币
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 *
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 */
public class Coin {

    final int mod = (int) (1e9+7);
    int[] coins = new int[]{25,10,5,1};
    public int waysToChange(int n) {
        // TODO: 2020/4/23 学习一下背包问题
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 0; i < 4; i++) {
            int coin = coins[i];
            for (int j = coin; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % mod;
            }
        }
        return dp[n];
    }
}
