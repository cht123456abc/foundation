package cn.edu.scu.algorithms.dp;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindromicSubstring_5 {

    // dp[i][j]
    public int getLongestPalindrome(String A, int n) {
        if (n < 1) return 0;
        int[][] dp = new int[n][n];
        char[] S = A.toCharArray();

        // 表右上顺序遍历（逆转态转移顺序）
        int res = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            dp[j][j] = 1;
            for (int i = 0; i < j; i++) {
                if(S[i] == S[j]) {
                    if(i+1 > j-1) dp[i][j] = 2;
                    else dp[i][j] = dp[i+1][j-1] + 2;
                    res = Math.max(res, dp[i][j]);
                }

            }
        }
        return res;
    }

    // 对于字符串的dp，多数用二维数组。
    // 对于动态规划：看题目能否用动态规划来做，看结构是否有递推关系。
    // 关键一：状态表达式的确定
    // 关键二：状态转移方程
    // 关键二：状态转移顺序
    public String longestPalindrome(String s) {
        // dp[i][j] : s[i..j]是否是回文串
        int n = s.length();
        if (n <= 1) return s;
        boolean[][] dp = new boolean[n][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= j) dp[i][j] = true;// 下三角形默认为true
            }
        }
        int begin = 0;
        int maxLen = 1;
        char[] sc = s.toCharArray();
        // 状态转移 遍历顺序按上三角矩阵右上顺序。
        for (int j = 1; j < n; j++) {
            int i = 0;
            while (i < j) {
                dp[i][j] = (sc[i] == sc[j]) && dp[i + 1][j - 1];
                int len = j - i + 1;
                if (dp[i][j] && len > maxLen) {
                    begin = i;
                    maxLen = len;
                }
                i++;
            }
        }
        return s.substring(begin, begin + maxLen);
    }


}
