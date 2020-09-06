package cn.edu.scu.algorithms.dp;

/**
 * 求出不超过容量M,的最大价值
 */
public class Knapsack01 {

    // 记忆化搜索
    public int mostValue(int[] v,int[] w,int M){
        int[][] dp = new int[v.length][M+1];// dp[i][j] 表示装到第i个物品背包当前容量为j的最大价值。
        return dfs(v,w,v.length-1,M,dp);
    }

    public int dfs(int[] v,int[] w,int index, int capacity,int[][] dp){
        if (index < 0 || capacity <= 0) return 0;

        if (dp[index][capacity] != 0) return dp[index][capacity];

        int res = dfs(v, w, index - 1, capacity,dp);
        if (w[index] <= capacity) res = Math.max(res,dfs(v,w,index-1,capacity-w[index],dp) + v[index]);

        dp[index][capacity] = res;
        return res;
    }

    // 递推
    public int mostValue1(int[] v,int[] w,int M){
        int n = v.length;

        int[][] dp = new int[n][M+1];
        // 初始化第一个物品的数据
        for (int j = 0; j <= M; j++) {
            dp[0][j] = w[0] <= j ? v[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <=M ; j++) {
                dp[i][j] = dp[i-1][j];
                if (w[i] <= j) dp[i][j] = Math.max(dp[i][j],dp[i-1][j - w[i]] + v[i]);
            }
        }
        return dp[n-1][M];
    }

    // TODO: 2020/4/28 还需要看看 
    // 压缩状态空间的递推
    public int mostValue2(int[] v,int[] w,int M){
        int n = w.length;

        int[] dp = new int[M + 1];
        //初始化第一行
        //仅考虑当前容量为i的背包放第0个物品的情况
        for (int i = 0; i <= M; i++) {
            dp[i] = w[0] <= i ? v[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = M; j >= w[i]; j--) {// 从后往前
                dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
            }
        }
        return dp[M];
    }

    public static void main(String[] args) {
        int[] v = new int[]{10,2,6,5,3,2};
        int[] w = new int[]{200,50,100,100,50,50};
        int M = 500;

        Knapsack01 knapsack01 = new Knapsack01();
        System.out.println(knapsack01.mostValue(v,w,M));
        System.out.println(knapsack01.mostValue1(v,w,M));
        System.out.println(knapsack01.mostValue2(v,w,M));
    }
}
