package cn.edu.scu.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSumII_113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, sum, path,res);
        return res;
    }

    // 前序遍历
    public void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) res.add(new ArrayList<>(path));
        if (root.left != null) dfs(root.left, sum - root.val, path, res);
        if (root.right != null) dfs(root.right, sum - root.val, path, res);
        path.remove(path.size() - 1);
    }

}
