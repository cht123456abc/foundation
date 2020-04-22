package cn.edu.scu.algorithms.tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 102. 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class BinaryTreeLevelTraverse_102 {

    // bfs解法
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> level = new ArrayList<>();
        int rear = 1, head = 0, last = 1;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            level.add(t.val);
            head++;
            if (last == head) {// 该层遍历完毕,创建下一层数组
                res.add(level);
                level = new ArrayList<>();
                last = -1;
            }
            if (t.left != null) {
                queue.offer(t.left);
                rear++;
            }
            if (t.right != null) {
                queue.offer(t.right);
                rear++;
            }
            if (last == -1) {
                last = rear;
            }

        }
        return res;
    }

    // dfs
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, 0, res);
//        Collections.reverse(res);
        return res;

    }

    // dfs
    public void traverse(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null) return;
        if (res.size() == depth){// 该层还没有创建数组
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        traverse(root.left, depth + 1, res);
        traverse(root.right, depth + 1, res);
    }
}
