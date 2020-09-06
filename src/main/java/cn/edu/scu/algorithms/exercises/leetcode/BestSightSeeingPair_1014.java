package cn.edu.scu.algorithms.exercises.leetcode;

/**
 *1014. 最佳观光组合
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 *
 *
 * 示例：
 *
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 *
 * 提示：
 *
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 */
public class BestSightSeeingPair_1014 {

    public int maxScoreSightseeingPair(int[] A) {
        // 将目标转换为（A[i] + i） + （A[j] - j） 两部分，即求两者的最大值和。
        int n = A.length;
        int res = 0;
        int maxLeft = A[0] + 0;
        for(int j = 1;j < n;j++){
            res = Math.max(res,maxLeft + A[j] - j);
            maxLeft = Math.max(maxLeft,A[j] + j);
        }
        return res;

    }
}
