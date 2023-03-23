package cn.edu.scu;

import cn.edu.scu.algorithms.tree.TreeNode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    /**
     * 解码
     * @param nums string字符串 数字串
     * @return int整型
     */
    public static int solve (String nums) {
        int n = nums.length();
        int[] dp = new int[n + 1];// dp[i]:前i个数字能翻译成多少种编码
        dp[0] = 0;
        dp[1] = 1;
        char[] chars = nums.toCharArray();

        Integer last = Integer.parseInt(String.valueOf(chars[0]));
        for (int i = 2; i <= n; i++) {
            Integer cur = Integer.parseInt(String.valueOf(chars[i-1]));
            Integer two = last * 10 + cur;
            if (two <= 26) {
                dp[i] = Math.max(dp[i - 2]*2, dp[i - 1]);
            } else {
                dp[i] = Math.max(dp[i-2],dp[i-1]);
            }
            last = cur;
        }
        return dp[n];
    }


    public static void main(String[] args) {


    }
}