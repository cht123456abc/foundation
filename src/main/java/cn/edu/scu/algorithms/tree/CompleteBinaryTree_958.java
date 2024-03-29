package cn.edu.scu.algorithms.tree;

/**
 * 958. 二叉树的完全性检验
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 *
 * 百度百科中对完全二叉树的定义如下：
 *
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 * 示例 2：
 *
 *
 *
 * 输入：[1,2,3,4,5,null,7]
 * 输出：false
 * 解释：值为 7 的结点没有尽可能靠向左侧。
 *
 *
 * 提示：
 *
 * 树中将会有 1 到 100 个结点。
 */
public class CompleteBinaryTree_958 {

    int max;
    int count;

    public boolean isCompleteTree(TreeNode root) {
        dfs(root,1);
        return max == count;
    }

    private void dfs(TreeNode root,int index){
        if(root == null) return;
        max = Math.max(max,index);
        count++;
        dfs(root.left,2*index);
        dfs(root.right,2*index+1);
    }


//    /**
//     * 广度遍历二叉树，当出现 null 值时停止遍历，如果此时还有没有遍历到的结点，说明该树非完全二叉树。
//     */
//    public boolean isCompleteTree(TreeNode root) {
//        LinkedList<TreeNode> q = new LinkedList<>();
//        TreeNode cur;
//        q.addLast(root);
//        while ((cur = q.removeFirst()) != null) {
//            q.addLast(cur.left);
//            q.addLast(cur.right);
//        }
//        while (!q.isEmpty()) {
//            if (q.removeLast() != null) {
//                return false;
//            }
//        }
//        return true;
//    }
}
