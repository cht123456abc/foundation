package cn.edu.scu.algorithms.dp;

/**
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 *
 * 提示：
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 */
public class EditDistance_72 {

    public int minDistance(String first, String second) {
        // dp[i][j] : 匹配字符串1中i位置时，字符串2j位置时需要编辑的次数
        int lenA = first.length();
        int lenB = second.length();

        // 确定状态表达式
        int[][] dp = new int[lenA + 1][lenB + 1];

        // 边界条件
        // 当第一个字符串为”“时
        for (int j = 1; j <= lenB; j++) {
            dp[0][j] = j;
        }
        // 当第二个字符串为”“时
        for (int i = 1; i <= lenA; i++) {
            dp[i][0] = i;
        }

        // 递推顺序和状态转移方程
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 这个时候有三种情况：删除、增加、替换（两个字符串长度相同的时候）
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp[lenA][lenB];
    }
}
