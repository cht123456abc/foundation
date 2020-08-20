package cn.edu.scu.algorithms.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class BinaryTreeRightSideView_199 {

    // bfs
    public List<Integer> rightSideView(TreeNode root) {
        // 返回每一层的最后一个元素
        if (root == null) return Collections.emptyList();
        TreeNode[] queue = new TreeNode[100];
        List<Integer> res = new ArrayList<>();
        int head = 0,rear = 0;
        queue[rear++] = root;
        int last = rear;
        int len = 0;
        while(head != rear){
            TreeNode node = queue[head++];
            if(head == last){// 头指针到达最近的尾指针,说明到达层尾。
                res.add(node.val);
            }
            if(node.left != null) {
                queue[rear++] = node.left;
                len++;
            }
            if(node.right != null) {
                queue[rear++] = node.right;
                len++;
            }
            // 如果rear 到达层尾，记录层尾
            if(len == rear - head){
                last = rear;
                len=0;
            }
        }
        return res;
    }

    // dfs
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView1(TreeNode root) {
        dfs(root,0);
        return res;
    }

    private void dfs(TreeNode root,int depth){
        if (root == null) return;
        if (depth == res.size()) res.add(root.val);
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);
    }
}
