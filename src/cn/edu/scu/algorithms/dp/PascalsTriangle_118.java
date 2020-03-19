package cn.edu.scu.algorithms.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle_118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> last = null;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i,1));
            for (int j = 1;j < i-1; j++) {// 从第三行开始才进入此循环
                row.set(j, last.get(j - 1) + last.get(j));
            }
            res.add(row);
            last = row;
        }
        return res;
    }

    public static void main(String[] args) {
//        List<Integer> l = new ArrayList<>(3);
        List<Integer> l = new ArrayList<>(Collections.nCopies(2, 1));
        l.add(1);
        l.stream().forEach(System.out::println);
    }
}
