package cn.edu.scu.algorithms.tree;


/**
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedArrayToBinarySearchTree_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        // 用二分法将数组自顶向下转换为二叉树
        return convert(0, nums.length - 1, nums);
    }

    public TreeNode convert(int lo, int hi, int[] nums) {
        if (lo <= hi) {
            int mid = (lo + hi + 1) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = convert(lo, mid-1, nums);
            root.right = convert(mid+1, hi, nums);
            return root;
        }
        return null;
    }
}
