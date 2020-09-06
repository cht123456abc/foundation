package cn.edu.scu.algorithms.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class PathSumIII_437 {

    // 方法一：记录前缀和；T = O(n);
    Map<Integer, Integer> freq = new HashMap<>();// 用一个map来记录前缀和的频率。
    int result = 0;
    public int pathSum(TreeNode root, int sum) {
        freq.put(0,1);// 初始化前缀和为0的频率为1；
        dfs(root,sum,0);
        return result;
    }

    private void dfs(TreeNode root, int sum, Integer pathSum) {
        if(root == null) return;
        pathSum += root.val;
        result += freq.getOrDefault(pathSum - sum,0);// 结果加上前缀和的频率
        freq.put(pathSum,freq.getOrDefault(pathSum,0)+1);

        dfs(root.left,sum,pathSum);
        dfs(root.right,sum,pathSum);

        freq.put(pathSum,freq.getOrDefault(pathSum,0)-1);
    }


    // 方法二：暴力回溯;T = O(n^2);
    public int pathSum1(TreeNode root, int sum) {
        if(root == null) return 0;
        return f(root,sum) + pathSum1(root.left,sum) + pathSum1(root.right,sum);
    }

    // 以root节点为根的树上搜索
    public int f(TreeNode root, int sum) {
        if(root == null) return 0;
        int res = 0;
        if(root.val == sum) res++;
        return res + f(root.left,sum - root.val) + f(root.right,sum - root.val);
    }
}
