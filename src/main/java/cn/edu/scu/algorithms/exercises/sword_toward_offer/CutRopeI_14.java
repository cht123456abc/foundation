package cn.edu.scu.algorithms.exercises.sword_toward_offer;

/**
 *面试题14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 *
 * 2 <= n <= 58
 */
public class CutRopeI_14 {

    // public int cuttingRope(int n) {
    //     // 数学推导：当切分段的长度为3，且长度为3的段数尽可能多的时候取得乘积得最大值
    //     if(n <= 3) return n-1;
    //     int a = n / 3,b = n % 3;
    //     // 根据最后一段b得长度分三种情况讨论
    //     if(b == 0) return (int)Math.pow(3,a);
    //     if(b == 1) return (int)Math.pow(3,a-1) * 4;
    //     if(b == 2) return (int)Math.pow(3,a) * 2;
    //     return -1;

    // }

    // 动态规划解
    public int cuttingRope(int n) {
        if(n <= 3) return n-1;

        // 当n > 3的时候，最后一段长度只能是2或者3
        int[] dp = new int[n+1];
        dp[1] = 1;dp[2] = 2;dp[3] = 3;
        for(int i = 4;i<=n;i++){
            dp[i] = Math.max(dp[i-2]*2,dp[i-3]*3);
        }
        return dp[n];

    }
}
