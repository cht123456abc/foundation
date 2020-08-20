package cn.edu.scu.algorithms.tree;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 *
 * 提示：
 *
 * 数组长度 <= 1000
 */
public class BinarySearchTreePostOrder {

    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder,0,postorder.length-1);

    }

    // 分治，用上后序遍历的特点：根结点是最后一个元素
    public boolean verify(int[] postorder,int i,int j){
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && verify(postorder,i,m-1) && verify(postorder,m,j-1);
    }
}
