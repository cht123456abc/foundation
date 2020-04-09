package cn.edu.scu.exercises.others;

import java.util.ArrayList;

public class ConstructBinaryTree {
	public static void main(String[] args) {
		TreeNode root = initTree();
		//前序遍历
		ArrayList<Integer> result1 = new ArrayList<>();
		preTraverse(root,result1);
		System.out.println(result1);
		//中序遍历
		ArrayList<Integer> result2 = new ArrayList<>();
		inTraverse(root,result2);
		System.out.println(result2);
		//后序遍历
		ArrayList<Integer> result3 = new ArrayList<>();
		backTraverse(root,result3);
		System.out.println(result3);
		System.out.println();
		//构造
		int[] pre = result1.stream().mapToInt(m -> m.intValue()).toArray();
		int[] in = result2.stream().mapToInt(m -> m.intValue()).toArray();
		TreeNode root2 = reConstructBinaryTree(pre,in);
		//后序遍历
		ArrayList<Integer> result4 = new ArrayList<>();
		System.out.println("重构二叉树的后序遍历：");
		backTraverse(root2, result4);
		System.out.println(result4);
	}
	
	// 根据前序和中序遍历重构二叉树
	public static TreeNode reConstructBinaryTree(int[] pre,int[] in) {
		return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
	}
	
	private static TreeNode reConstructBinaryTree(int[] pre,int lo1,int hi1,int[] in, int lo2, int hi2) {
		if(lo1 > hi1 || lo2 > hi2) return null; 
		int position = findPostion(pre[lo1],in);
		TreeNode node = new TreeNode(pre[lo1]);
		node.left = reConstructBinaryTree(pre,lo1+1,lo1+position-lo2,in,lo2,position-1);
		node.right = reConstructBinaryTree(pre,position+hi1-hi2+1,hi1,in,position+1,hi2);
		return node;
	}
	
	private static int findPostion(int preValue, int[] in) {
		for(int i = 0;i<in.length;i++) {
			if(in[i]==preValue) return i;
		}
		return -1;
	}

	public static void preTraverse(TreeNode a,ArrayList<Integer> b) {
		if(a != null) {
			b.add(a.value);
			System.out.print(a.value + ",");
			preTraverse(a.left,b);
			preTraverse(a.right,b);
		}
	}
	
	public static void inTraverse(TreeNode a,ArrayList<Integer> b) {
		if(a != null) {
			inTraverse(a.left,b);
			b.add(a.value);
			System.out.print(a.value + ",");
			inTraverse(a.right,b);
		}
	}
	
	public static void backTraverse(TreeNode a,ArrayList<Integer> b) {
		if(a != null) {
			backTraverse(a.left,b);
			backTraverse(a.right,b);
			b.add(a.value);
			System.out.print(a.value + ",");
		}
	}
	
	public static TreeNode initTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		return root;
	}
	
}

