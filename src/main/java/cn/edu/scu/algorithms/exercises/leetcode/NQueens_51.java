package cn.edu.scu.algorithms.exercises.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[["Q"]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 */
public class NQueens_51 {
    boolean[] col;// 列
    boolean[] rd;// 右下对角线
    boolean[] ld;// 左下对角线

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        rd = new boolean[2 * n - 1];
        ld = new boolean[2 * n - 1];

        List<List<String>> res = new ArrayList<>();
        List<String> once = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dfs(0, i, n, res, once);
        }
        return res;
    }

    public void dfs(int i,int j,int n,List<List<String>> res,List<String> once) {
        if(col[j]|| rd[j-i+n-1] || ld[i+j]) return;
        // 定下位置
        col[j] = true;
        rd[j-i+n-1] = true;
        ld[i+j] = true;
        StringBuilder line = new StringBuilder();
        for (int k = 0; k < n; k++) {
            line.append(k == j ? 'Q' : '.');
        }
        once.add(line.toString());

        // 完成一次解法
        if (i == n-1) {
            res.add(new ArrayList<>(once));
        } else {
            // 下一行
            for (int k = 0; k < n; k++) {
                dfs(i+1,k,n,res,once);
            }
        }

        // 回溯
        once.remove(once.size() - 1);
        col[j] = false;
        rd[j-i+n-1] = false;
        ld[i+j] = false;

    }

    public static void main(String[] args) {
        List<List<String>> res = new NQueens_51().solveNQueens(4);

        for (List<String> re : res) {
            for (String s : re) {
                System.out.println(s);

            }
            System.out.println();
        }
    }

}
