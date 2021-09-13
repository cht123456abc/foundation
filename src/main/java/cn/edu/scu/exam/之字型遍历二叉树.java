package cn.edu.scu.exam;

import cn.edu.scu.algorithms.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class 之字型遍历二叉树 {


    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }


        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int total = 1;
        int last = total;
        int cur = 0;
        boolean change = false;
        ArrayList<Integer> level = new ArrayList<>();
        while (!deque.isEmpty()) {
            TreeNode head = change ? deque.removeLast(): deque.removeFirst();
            cur++;
            level.add(head.val);
            // 每层遍历完
            if (cur == last) {
                ans.add(level);
                level = new ArrayList<>();
            }

            if (!change) {
                if (head.left != null) {
                    deque.addLast(head.left);
                    total++;
                }
                if (head.right != null) {
                    deque.addLast(head.right);
                    total++;
                }

            } else {
                if (head.right != null) {
                    deque.addFirst(head.right);
                    total++;
                }
                if (head.left != null) {
                    deque.addFirst(head.left);
                    total++;
                }
            }

            if (cur == last) {
                last = total;
                change = !change;
            }


        }
        return ans;
    }

    public static void main(String[] args) {



    }
}
