package cn.edu.scu.algorithms.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class PascalsTriangleII_119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> last = null;
        for (int i = 1; i <= rowIndex+1; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i,1));
            for (int j = 1;j < i-1; j++) {// 从第三行开始才进入此循环
                row.set(j, last.get(j - 1) + last.get(j));
            }
            last = row;
        }
        return last;
    }
}
