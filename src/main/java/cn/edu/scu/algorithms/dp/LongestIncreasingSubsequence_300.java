package cn.edu.scu.algorithms.dp;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 */
public class LongestIncreasingSubsequence_300 {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            // 找到所有i-1之前比nums[i-1]更小的数
            for (int j = i - 1; j >= 1; j--) {
                if (nums[j - 1] < nums[i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;

    }

    // 牛客网 超时
    public int[] LIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int len = Integer.MIN_VALUE;
        int[] path = new int[n + 1];
        // 找到最大长度 
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            // 找到所有i-1之前比nums[i-1]更小的数
            int min = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 1; j--) {
                if (nums[j - 1] < nums[i - 1]) {
                    if(dp[j] + 1 >= dp[i]){
                        dp[i] = dp[j] + 1;
                        // 记录最小的nums[j-1]作为nums[i-1]的上一元素
                        if (nums[j - 1] < min) {
                            min = nums[j - 1];
                            path[i] = j;
                        }
                    }
                }
            }
            len = Math.max(len, dp[i]);
        }

        // 找到最大长度时的所有序列
        List<int[]> all = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            if (dp[i] == len) {
                int[] res = new int[len];
                int j = i;
                int k = len;
                while (k > 0) {
                    res[--k] = nums[j - 1];
                    j = path[j];
                }
                all.add(res);
            }
        }

        // 找出字典序最小的序列
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < all.size(); i++) {
            ans.add(i);
        }
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            // 找到每个最小元素
            for (int[] ans1 : all) {
                min = Math.min(ans1[i], min);
            }
            // 丢弃比min大的ans
            for (int j = 0; j < all.size(); j++) {
                if (!ans.contains(j)) continue;
                if (all.get(j)[i] > min) {
                    // 丢弃j答案
                    ans.remove(j);
                }
            }
            // 如果仅剩唯一答案，输出
            if (ans.size() == 1) {
                return all.get(ans.stream().findAny().get());
            }
        }
        // 答案为all - ans 中剩下的ans
        return all.get(ans.stream().findAny().get());

    }
}
