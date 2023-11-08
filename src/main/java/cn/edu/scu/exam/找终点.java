package cn.edu.scu.exam;

import java.util.Arrays;
import java.util.Scanner;

public class 找终点 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String line = in.nextLine();
            String[] lines = line.split(" ");
            int[] arr = Arrays.stream(lines).mapToInt(Integer::parseInt).toArray();

            int n = arr.length;
            // 从后往前推,在前半部分寻找最小值
            int[] dp = new int[n];// 从第i个数到最后一个数需要多少步
            dp[n-1] = 1;
            for (int i = n-1; i>=1; i--) {
                int lastIndex = arr[i] + i;
                if (lastIndex < n && dp[lastIndex] > 0) {
                    dp[i] = dp[lastIndex] + 1;
                }
            }

            int res = Integer.MAX_VALUE;
            for (int i = 1;i<=n / 2; i++) {
                if (dp[i] > 0) {
                    res = Math.min(res, dp[i]);
                }
            }
            System.out.println(res == Integer.MAX_VALUE ? -1 : res);

        }
    }
}
