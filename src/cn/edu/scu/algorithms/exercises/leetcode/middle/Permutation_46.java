package cn.edu.scu.algorithms.exercises.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int[] permutation = new int[n];
        dfs(res,nums,0,permutation);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, int last, int[] permutation){
        if(last == nums.length) return;
        for(int i = last;i < nums.length;i++){
            permutation[last] = nums[i];
            dfs(res,nums,last+1,permutation);
            if(last == nums.length-1) {
                res.add(Arrays.stream(permutation).boxed().collect(Collectors.toList()));
            }
        }
    }
}
