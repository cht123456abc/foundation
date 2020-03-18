package cn.edu.scu.algorithms.dp;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSumOfSubArray_53 {

    // 递推
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(0,dp[i-1]) + nums[i-1];
            if (dp[i] > res) res = dp[i];
        }
        return res;
    }

    // 记忆化搜索
    int[] dp;
    int[] Nums;
    int max = Integer.MIN_VALUE;
    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        dp = new int[n+1];
        Nums = nums;
        // 初始化
        for (int i = 0; i < n+1; i++) {
            dp[i] = -1;
        }
        dfs(n);
        return max;

    }

    private int dfs(int n) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        dp[n] = Math.max(0,dfs(n-1)) + Nums[n-1];
        if (dp[n] > max) max = dp[n];
        return dp[n];
    }
}
