package cn.edu.scu.exercises;

import java.util.ArrayList;
import java.util.Stack;
/**


题目描述
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
*/
public class FindPath {
	/**
	 * 思路:用一个stack来装从根节点到叶节点的一条路径，当遍历到某一叶节点时，判断该路径能否称为目标路径，如果能，就将该路径转存到ArrayList中；如果不能，则弹出顶点，转向另一个分支。
	 * 也就是DFS(深度优先搜索)--也叫回溯法
	 * @param root
	 * @param target
	 * @return
	 */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    	Stack<Integer> stack = new Stack<Integer>();
    	traverse(root,target,stack,result);
    	return result;
    }

	private void traverse(TreeNode root, int target, Stack<Integer> stack, ArrayList<ArrayList<Integer>> result) {
		if(root == null) return;
		stack.push(root.val);
		//如果到叶子节点的时候，就判断此时堆栈里面数的和是否为target
		if(root.left == null && root.right == null) {
			//计算stack里面的路径和
			Integer sum = 0;
			for(int i=0;i<stack.size();i++) {
				sum += stack.get(i);
			}
			//如果该路径为一条目标路径，则转存到一个ArrayList中
			if(target == sum) {
			 	ArrayList<Integer> sumArray = new ArrayList<Integer>();
			 	sumArray.addAll(stack);
			 	result.add(sumArray);
			}
		}
		traverse(root.left,target,stack,result);
		traverse(root.right,target,stack,result);
		stack.pop();
	}
	
	private static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
    
}



//更简洁算法
//public class Solution {
//    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
//    private ArrayList<Integer> list = new ArrayList<Integer>();
//    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
//        if(root == null) return listAll;
//        list.add(root.val);
//        target -= root.val;
//        if(target == 0 && root.left == null && root.right == null)
//            listAll.add(new ArrayList<Integer>(list));
//        FindPath(root.left, target);
//        FindPath(root.right, target);
//        list.remove(list.size()-1);
//        return listAll;
//    }
//}

}