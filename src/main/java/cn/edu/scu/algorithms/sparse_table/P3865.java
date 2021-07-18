package cn.edu.scu.algorithms.sparse_table;


import java.util.Scanner;

public class P3865 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        ST st = new ST(a);
        st.init();
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(st.query(l-1,r-1));
        }
    }

}

class ST {
    int[] a;
    int[][] dp;

    public ST(int[] a) {
        this.a = a;
        this.dp = new int[a.length][31];
    }

    public void init() {
        for (int i = 0; i < a.length; i++) {
            dp[i][0] = a[i];
        }
        for (int j = 1; (1 << j) <= a.length; j++) {
            for (int i = 0; i + (1 << j) - 1 < a.length; i++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    public int query(int l, int r) {
        int k = (int)(Math.log(r-l+1) / Math.log(2));
        return Math.max(dp[l][k], dp[r - (1 << k) + 1][k]);
    }
}