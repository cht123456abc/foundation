package cn.edu.scu.exam;

import cn.edu.scu.algorithms.tree.TreeNode;

import java.util.*;

public class 之字形层序遍历 {

    public static void main(String[] args) {




    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // 两队列交替
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> lastLevel = new LinkedList<>();
        Deque<TreeNode> nextLevel = new LinkedList<>();

        lastLevel.add(root);

        ArrayList<Integer> level = new ArrayList<>();
        boolean flag = true;
        while (!lastLevel.isEmpty()) {
            TreeNode node = lastLevel.removeLast();
            level.add(node.val);


            TreeNode first, second;
            if (flag) {
                first = node.left;
                second = node.right;
            }else {
                first = node.right;
                second = node.left;
            }

            if (first != null) {
                nextLevel.offer(first);
            }

            if (second != null) {
                nextLevel.offer(second);
            }

            if (lastLevel.isEmpty()) {
                lastLevel = nextLevel;
                nextLevel = new LinkedList<>();
                res.add(level);
                level = new ArrayList<>();
                flag = !flag;
            }
        }
        return res;

    }
}
