package cn.edu.scu.exercises;

import java.util.ArrayList;

public class HasSubtree {
	public static void main(String[] args) {
		
	}
	
	public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
		if(root1 == null || root2 == null) return false;
		boolean result = false;
		if(root1.val == root2.val) {
			result = isSubTree(root1,root2);
		}
		if(!result) {
			result = HasSubtree(root1.left,root2);
		}
		
		if(!result) {
			result = HasSubtree(root1.right,root2);
		}
		return false;
	}
	
	private static boolean isSubTree(TreeNode root1, TreeNode root2) {
		if(root2 == null) return true;
		else if(root1 == null) return false;
		else if(root1.val != root2.val) return false;
		return isSubTree(root1.left, root2.left) && isSubTree(root1.right,root2.right);
	}

	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
}
