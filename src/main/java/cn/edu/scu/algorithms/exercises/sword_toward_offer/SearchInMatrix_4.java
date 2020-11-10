package cn.edu.scu.algorithms.exercises.sword_toward_offer;

/**
 * 面试题04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 *
 *
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 *
 *
 *
 * 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class SearchInMatrix_4 {


    // T  = O(n+m)
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 从右上角或者左下角开始遍历
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        if (m == 0) return false;
        for (int i = 0; i < n; i++) {
            for (int j = m-1; j >= 0; j--) {
                if (matrix[i][j] == target) return true;
                else if (target > matrix[i][j]) break;
            }
        }
        return false;
    }


    // T = O(nlogm)
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        if (m == 0) return false;
        // 行遍历，列二分
        for (int i = 0; i < n; i++) {
            if (target > matrix[i][m-1]) continue;
            // 二分查找列
            int lo = 0,hi = m-1,mid = 0;
            while (lo <= hi) {
                mid = (lo + hi) / 2;
                if (matrix[i][mid] == target) return true;
                else if (matrix[i][mid] < target) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return false;
    }
}

