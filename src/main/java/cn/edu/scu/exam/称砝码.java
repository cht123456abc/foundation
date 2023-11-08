package cn.edu.scu.exam;
import java.util.Scanner;

public class 称砝码 {
// 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] weights = new int[n];
            for(int i=0;i<n;i++){
                weights[i] = in.nextInt();
            }
            int[] counts = new int[n];
            for(int i=0;i<n;i++){
                counts[i] = in.nextInt();
            }

            System.out.println(countUniqueWeights(weights,counts));
        }
    }

    public static int countUniqueWeights(int[] mWeights, int[] mCounts) {
        int maxWeight = 0;
        for (int i = 0; i < mWeights.length; i++) {
            maxWeight += mWeights[i] * mCounts[i];
        }

        boolean[] dp = new boolean[maxWeight + 1];
        dp[0] = true;

        for (int i = 0; i < mWeights.length; i++) {
            for (int j = maxWeight; j >= 0; j--) {// 重点，一定是逆序，不然会大量重复计算，导致超时
                if (dp[j]) {// 在基础值存在的情况下，才进行运算；所以基础值得事先确认，即须事先逆序算出
                    for (int k = 1; k <= mCounts[i]; k++) {
                        if (j + k * mWeights[i] <= maxWeight) {
                            dp[j + k * mWeights[i]] = true;
                        }
                    }
                }
            }
        }

        int uniqueWeights = 0;
        for (boolean weight : dp) {
            if (weight) {
                uniqueWeights++;
            }
        }

        return uniqueWeights;
    }

}