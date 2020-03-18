package cn.edu.scu.algorithms.dp;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class HouseRubber_198 {

    // 状态表示一：dp[i][0/1]:前i个房子里第i个房子偷或不偷的最大非法所得。
    // T = O(n)
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;// 第一个房子不偷
        dp[0][1] = nums[0];// 第一个房子偷
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }

    // 状态表示二：dp[i]:前i个房子里第i个房子偷的最大非法所得。
    // T = O(n^2)
    public int rob2(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int res = Math.max(dp[0],dp[1]);
        for (int i = 2; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j <= i-2; j++) {
                if (dp[j] > max) max = dp[j];
            }
            dp[i] = max + nums[i];
            if (dp[i] > res) res = dp[i];
        }
        return res;
    }
}
