package cn.edu.scu.exam;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 二进制含101 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();


            int bit = 5;
            boolean[] dp = new boolean[m-n+1]; // 区间内前i个数是包含101的
            int count = 0;
            for (int i = n; i <= m; bit <<= 1,i++) {
                if(dp[i]) continue;
                if ((bit & i) == bit) {
                    dp[i] = dp[i >> 1];
                    count++;
                }
            }
            System.out.println(count);

        }
    }
}
