package cn.edu.scu.exercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。


*/
public class TraverseOnLevel {
	/**
	 * 思路：左右子树为同一个层级.
	 * 用一个ArrayList，一个Queue,ArrayList表示最后结果，Queue表示当前层级
	 * Queue队列的重要性：保证左右子树的先后顺序。
	 * @param root
	 * @return
	 */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	if(root == null) return new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> level = new LinkedList<TreeNode>();
        level.offer(root);
        TreeNode current = null;
        while(!level.isEmpty()) {
        	current = level.poll();
        	result.add(current.val);
        	if(current.left != null) {
        		level.offer(current.left);
        	}
        	if(current.right != null) {
        		level.offer(current.right);
        	}
        }
        return result;
    }
    
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}