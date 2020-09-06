package cn.edu.scu.algorithms.exercises.leetcode;


import java.util.*;

/**
 *56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeIntervals_56 {

    public int[][] merge(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 遍历
        int n = intervals.length;
        if (n <= 1) return intervals;
        List<int[]> res = new ArrayList<>();
        int left = intervals[0][0],right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 如果两个当中有交集，就合并
            if(intervals[i][0] <= right) right = Math.max(right,intervals[i][1]);
            else {
                //  如果没有交集，就将上一个区间放入结果集
                res.add(new int[]{left,right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        // 放入最后一个区间
        res.add(new int[]{left,right});
        return res.toArray(new int[0][]);
    }
}
