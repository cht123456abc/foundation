package cn.edu.scu.algorithms.exercises.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 ** 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutation_46 {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> A = new LinkedList<>();// 排列数组
    private List<Integer> R = new LinkedList<>();// 剩余数组

    public List<List<Integer>> permute(int[] nums) {
        for(int i : nums) R.add(i);// 初始化剩余数组
        dfs();
        return res;
    }

    public void dfs(){
        if(R.isEmpty()){
            res.add(new ArrayList(A));
            return;
        }
        int n = R.size();
        for(int i = 0;i < n;i++){
            Integer node = R.get(0);
            A.add(node);
            R.remove(0);
            dfs();
            R.add(node);
            A.remove(A.size()-1);
        }
    }
}
