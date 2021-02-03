package cn.edu.scu.algorithms.dp;

/**
 * 求出不超过容量M,的最大价值
 */
public class Knapsack01 {

    // 记忆化搜索
    public int mostValue(int[] v,int[] w,int n ,int C){
        int[][] dp = new int[n][C+1];// dp[i][j] 表示装到第i个物品背包当前容量为j的最大价值。
        return dfs(v,w,n-1,C,dp);
    }

    private int dfs(int[] v,int[] w,int i, int C,int[][] dp){
        if (i < 0 || C <= 0) return 0;

        if (dp[i][C] != 0) return dp[i][C];

        int res = dfs(v, w, i - 1, C,dp);
        if (w[i] <= C) res = Math.max(res,dfs(v,w,i-1,C-w[i],dp) + v[i]);

        dp[i][C] = res;
        return res;
    }

    // 递推
    public int mostValue1(int[] v,int[] w,int n,int C){
        int[][] dp = new int[n][C+1];
        // 初始化第一个物品的数据
        for (int j = 0; j <= C; j++) {
            dp[0][j] = w[0] <= j ? v[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <=C ; j++) {
                dp[i][j] = dp[i-1][j];
                if (w[i] <= j) dp[i][j] = Math.max(dp[i][j],dp[i-1][j - w[i]] + v[i]);
            }
        }
        return dp[n-1][C];
    }

    // TODO: 2020/4/28 还需要看看
    // 压缩状态空间的递推
    public int mostValue2(int[] v,int[] w,int n ,int C){

        int[] dp = new int[C + 1];

        for (int i = 0; i < n; i++) {
            for (int j = C; j >= w[i]; j--) {// 从后往前
                dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
            }
        }
        return dp[C];
    }

    public static void main(String[] args) {
        int[] v = new int[]{10,2,6,5,3,2};
        int[] w = new int[]{200,50,100,100,50,50};
//        v = new int[]{2,3,5,6,2,10};
//        w = new int[]{50, 50, 100, 100, 50, 200};
        int C = 500;
        int n = v.length;

        Knapsack01 knapsack01 = new Knapsack01();
        System.out.println(knapsack01.mostValue(v,w,n,C));
        System.out.println(knapsack01.mostValue1(v,w,n,C));
        System.out.println(knapsack01.mostValue2(v,w,n,C));
    }
}
