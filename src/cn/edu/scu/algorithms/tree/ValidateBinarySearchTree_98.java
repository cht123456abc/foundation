package cn.edu.scu.algorithms.tree;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class ValidateBinarySearchTree_98 {

    // 自上而下递归
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        return helper(node.left,lower,val) && helper(node.right,val,upper);
    }


    // 利用中序遍历
    public boolean isValidBST1(TreeNode root) {
        // 以中序遍历判断是否是由小到大的序列
        Integer[] last_val = new Integer[]{Integer.MIN_VALUE};
        Boolean[] begin = new Boolean[]{true};
        return traverse(root,last_val,begin);
    }


    public boolean traverse(TreeNode root,Integer[] last_val,Boolean[] begin){
        if(root == null) return true;
        boolean left = traverse(root.left,last_val,begin);
        if(last_val[0] >= root.val && !begin[0]) return false;
        last_val[0] = root.val;
        begin[0] = false;
        boolean right = traverse(root.right,last_val,begin);
        return left && right;
    }
}
