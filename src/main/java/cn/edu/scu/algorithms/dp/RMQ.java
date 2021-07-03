package cn.edu.scu.algorithms.dp;
import java.util.Random;

/**
 * 区间最值问题
 */
public class RMQ {

    static int M;

    public static void main(String[] args) {
        Random random = new Random();
        final int count = (int)1e7;
        int[] a = new int[1000];
        for (int i = 0; i < 1000; i++) {
            a[i] = random.nextInt(1000);
        }

        // st表
        ST st = new ST(a);
        st.init();
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            int l = random.nextInt(500);
            int r = 500 + random.nextInt(500);
            M = st.query(l, r);
        }
        long end = System.currentTimeMillis();
        System.out.println("st表耗时：" + (end - start) + "ms");

        // 暴力
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            int l = random.nextInt(500);
            int r = 500 + random.nextInt(500);
            int min = Integer.MAX_VALUE;
            for (int j = l; j <= r; j++) {
                if (a[j] < min) min = a[j];
            }
            M = min;
        }
        end = System.currentTimeMillis();
        System.out.println("暴力法耗时：" + (end - start) + "ms");

    }
}


/**
 * ST表
 */
class ST {
    int n;
    int[] a;
    int[][] dp;// st表,dp[i][j] 代表从a[i]开始，到a[i+2^j-1]即区间[a[i],a[i+2^j-1]]的最值

    public ST(int[] a) {
        this.a = a;
        this.n = a.length;
        this.dp = new int[n][31];
    }

    // 初始化 T=O(n)
    public void init() {
        for (int i = 0; i < n; i++) {
            dp[i][0] = a[i];
        }
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                dp[i][j] = Math.min(dp[i][j-1],dp[i+(1<<(j-1))][j-1]);
            }
        }
    }

    // 查询区间最值 T=O(1)
    public int query(int l, int r) {
        int k = (int)Math.log(r - l + 1);
        return Math.min(dp[l][k], dp[r - (1 << k)+1][k]);
    }
}
