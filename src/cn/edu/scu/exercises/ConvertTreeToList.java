package cn.edu.scu.exercises;

/**
 * 题目描述 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertTreeToList {
	TreeNode head = null;
    TreeNode realHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }
     
    private void ConvertSub(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return;
        ConvertSub(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
	}

	private static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}
	
	//我的错误做法
//	 public TreeNode Convert(TreeNode pRootOfTree) {
//	        if(pRootOfTree == null) return null;
//	        else if(pRootOfTree.left == null && pRootOfTree.right == null) return pRootOfTree; 
//	        TreeNode left = Convert(pRootOfTree.left);
//	        left.right = pRootOfTree;
//	        pRootOfTree.left = left;
//	        if(pRootOfTree.right == null) return pRootOfTree;
//	        TreeNode right = Convert(pRootOfTree.right);
//	        right.left = pRootOfTree;
//	        pRootOfTree.right = right;
//	        return pRootOfTree.right;
//	    }
}