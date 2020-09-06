package cn.edu.scu.algorithms.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */
public class BalancedBinaryTree_110 {

    public boolean isBalanced(TreeNode root) {
        boolean[] isBalanced = new boolean[1];
        isBalanced[0] = true;
        height(root, isBalanced);
        return isBalanced[0];
    }

    // 返回每个节点所在子树的高度,附带平衡信息
    public int height(TreeNode root, boolean[] isBalanced) {
        if (root == null){
            return 0;
        }
        int hleft = height(root.left, isBalanced);
        int hright = height(root.right, isBalanced);
        if (hleft - hright > 1 || hright - hleft > 1) isBalanced[0] = false;
        return Math.max(hleft,hright) + 1;
    }

}
