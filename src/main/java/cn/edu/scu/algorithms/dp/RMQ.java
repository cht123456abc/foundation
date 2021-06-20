package cn.edu.scu.algorithms.dp;


/**
 * 区间最值问题--st表
 */
public class RMQ {

    int n = 5;
    int[][] dp = new int[n][25];
    int[] a = new int[]{1, 2, 3, 4, 5};

    private void init() {

        for (int i = 0; i < n; i++) {
            dp[i][0] = a[i];
        }
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                dp[i][j] = Math.min(dp[i][j-1],dp[i+(1<<j-1)][j-1]);
            }
        }
    }

    private int query(int l, int r) {
        int k = (int)Math.log(r - l + 1);
        return Math.min(dp[l][k], dp[r - (1 << k)+1][k]);
    }

    public static void main(String[] args) {
        RMQ rmq = new RMQ();
        rmq.init();
        System.out.println(rmq.query(1, 2));
        System.out.println(rmq.query(3, 4));
        System.out.println(rmq.query(2, 3));

    }
}
