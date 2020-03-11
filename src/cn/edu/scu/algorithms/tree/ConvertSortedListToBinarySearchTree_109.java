package cn.edu.scu.algorithms.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedListToBinarySearchTree_109 {

    public TreeNode sortedListToBST(ListNode head) {
        // 将链表转换为数组再进行分治转换
        List<Integer> list = new ArrayList();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        return convert(0, list.size() - 1, list);
    }

    public TreeNode convert(int lo, int hi,List<Integer> list) {
        if (lo <= hi) {
            int mid = (lo + hi + 1) / 2;
            TreeNode root = new TreeNode(list.get(mid));
            root.left = convert(lo, mid-1, list);
            root.right = convert(mid+1, hi, list);
            return root;
        }
        return null;
    }
}
