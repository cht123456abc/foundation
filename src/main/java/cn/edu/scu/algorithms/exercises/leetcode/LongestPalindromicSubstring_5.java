package cn.edu.scu.algorithms.exercises.leetcode;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindromicSubstring_5 {

    // 对于字符串的dp，多数用二维数组。
    // 对于动态规划：看题目能否用动态规划来做，看结构是否有递推关系。
    // 关键一：先确定状态表达式
    // 关键二：再确定状态转移方程
    // 关键二：最后根据转移方程决定转移顺序
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

    // 方法二，中心扩展优化，排除重复元素且不用考虑奇偶
    public String longestPalindrome1(String s) {
        String result = "";
        int[] limit = {0, 0};// 字串左限制和右限制
        char[] ch = s.toCharArray();
        int i = 0;
        while (i < ch.length) {
            i = indexOf(ch, i, limit);
        }
        result = s.substring(limit[0], limit[1]);
        return result;
    }
    public int indexOf(char[] ch, int low, int[] limit) {
        // 优化：去除重复元素
        int high = low + 1;
        while (high < ch.length && ch[high] == ch[low]) {// 先向右考虑相同元素
            high++;
        }
        int result = high;// 每次返回右边第一个与char[low]不相同的元素
        // 以low为中心扩展
        while (low > 0 && high < ch.length && ch[low - 1] == ch[high]) {
            low--;
            high++;
        }

        // 更新回文串区间
        if (high - low > limit[1] - limit[0]) {
            limit[0] = low;
            limit[1] = high;
        }
        return result;
    }

    // 方法三：普通中心扩展
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
