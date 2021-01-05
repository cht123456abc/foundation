package cn.edu.scu.algorithms.exercises.cracking_the_coding_interview;


/**
 *面试题 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 */
public class OneEditDistance_0105 {

    // 双指针
    public boolean oneEditAway(String first, String second) {

        int lenA = first.length();
        int lenB = second.length();
        // 保证第二个字符串更长
        if (lenA > lenB) return oneEditAway(second, first);
        if (lenB - lenA > 1) return false;

        boolean flag = false;
        for (int i = 0, j = 0; i < lenA && j < lenB; i++, j++) {
            if (first.charAt(i) != second.charAt(j)) {
                // 只允许1次不相等
                if (flag) return false;
                flag = true;
                // 继续比较后续子串
                if (lenA != lenB) i--;// 第一个字符串不变
            }
        }
        return true;
    }


    // 动态规划 最小编辑距离
    public boolean oneEditAway1(String first, String second) {
        // dp[i][j] : 匹配字符串1中i位置时，字符串2j位置时需要编辑的次数

        int lenA = first.length();
        int lenB = second.length();
        // 剪枝
        if (Math.abs(lenA - lenB) > 1) return false;

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

        return dp[lenA][lenB] <= 1;
    }

}
