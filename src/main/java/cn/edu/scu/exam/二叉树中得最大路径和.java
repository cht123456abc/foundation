package cn.edu.scu.exam;

import cn.edu.scu.algorithms.tree.TreeNode;

/**
 * 描述
 * 二叉树里面的路径被定义为:从该树的任意节点出发，经过父=>子或者子=>父的连接，达到任意节点的序列。
 * 注意:
 * 1.同一个节点在一条二叉树路径里中最多出现一次
 * 2.一条路径至少包含一个节点，且不一定经过根节点
 *
 * 给定一个二叉树的根节点root，请你计算它的最大路径和
 *
 * 例如：
 * 给出以下的二叉树，
 *
 * 最优路径是:2=>1=>3，或者3=>1=>2，最大路径和=2+1+3=6
 *
 * 数据范围：节点数满足 0 \le n \le 100000≤n≤10000 ，节点上的值满足 |val| \le 1000∣val∣≤1000
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * 示例1
 * 输入：
 * {1,2,3}
 * 复制
 * 返回值：
 * 6
 * 复制
 * 示例2
 * 输入：
 * {-20,8,20,#,#,15,6}
 * 复制
 * 返回值：
 * 41
 * 复制
 * 说明：
 *
 * 其中一条最大路径为:15=>20=>6，路径和为15+20+6=41
 *
 * 示例3
 * 输入：
 * {-2,#,-3}
 * 复制
 * 返回值：
 * -2
 */
public class 二叉树中得最大路径和 {

    int max_value = Integer.MIN_VALUE;
    public int maxPathSum (TreeNode root) {
        dfs(root);
        return max_value;
    }

    // 回溯上面套贪心
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0,dfs(root.left));
        int right = Math.max(0,dfs(root.right));
        max_value = Math.max(max_value,root.val + left + right);

        return root.val + Math.max(left,right);
    }
}
