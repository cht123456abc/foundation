package cn.edu.scu.algorithms.tree;

import javafx.util.Pair;
import java.util.Stack;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
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
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class PathSum_112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        // 用dfs递归算法来找到路径和
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    // 用迭代模拟dfs
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<Pair<TreeNode, Integer>> path = new Stack<>();
        Pair<TreeNode, Integer> pair = new Pair<>(root, sum - root.val);
        path.push(pair);
        while (!path.isEmpty()) {
            Pair<TreeNode,Integer> cur_pair = path.pop();
            TreeNode node = cur_pair.getKey();
            Integer cur_sum = cur_pair.getValue();
            if (node.left == null && node.right == null && cur_sum == 0) return true;
            if (root.right != null) path.push(new Pair<>(root.right, cur_sum - root.val));
            if (root.left != null) path.push(new Pair<>(root.left, cur_sum - root.val));
        }
        return false;
    }
}
