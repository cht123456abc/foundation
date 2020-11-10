package cn.edu.scu.algorithms.exercises.sword_toward_offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 */
public class KthLargestNodeInBinarySearchTree_54 {

    // 从右往左的中序遍历
    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode next = root;// next 指针
        while(!stack.isEmpty() || next !=null){
            if(next != null){
                stack.push(next);
                next = next.right;
            }else {
                next = stack.pop();
                k--;
                if(k == 0) return next.val;
                next = next.left;
            }
        }
        return -1;
    }

    // 中序遍历递归
    int K;
    public int kthLargest1(TreeNode root, int k) {
        K = k;
        return midTraverse(root);
    }

    public int midTraverse(TreeNode root){
        if(root == null) return 0;
        int res = midTraverse(root.right);
        K--;
        if(K == 0) return root.val;
        res += midTraverse(root.left);
        return res;
    }
}
