package cn.edu.scu.algorithms.dp;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbStairs_70 {

    // 递推
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }

    // 记忆化搜索
    int[] dp;
    public int climbStairs1(int n) {
        dp = new int[n+1];
        // 初始化dp为-1
        for (int i = 0; i < n+1; i++) {
            dp[i] = -1;
        }
        return dfs(n);
    }

    public int dfs(int n) {
        // 边界处理
        if (n<0) return 0;
        if (n==0) return 1;
        // 记忆化搜索
        if (dp[n] != -1) return dp[n];
        // 状态转移
        dp[n] = dfs(n-1) + dfs(n-2);
        return dp[n];
    }
}
