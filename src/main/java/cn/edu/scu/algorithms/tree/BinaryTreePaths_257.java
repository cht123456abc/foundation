package cn.edu.scu.algorithms.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class BinaryTreePaths_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<>();
        List<String> res = new ArrayList<>();
        traverse(root,path,res);
        return res;
    }

    public void traverse(TreeNode root,List<String> path,List<String> res){
        if(root == null) return;
        path.add(String.valueOf(root.val));
        if(root.left == null && root.right == null){
            // 记录一条路径
            res.add(String.join("->",path));
            // pop最后一个元素
            path.remove(path.size() - 1);
            return;
        }
        traverse(root.left,path,res);
        traverse(root.right,path,res);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(String.join("->",list));
    }
}
