package cn.edu.scu.algorithms.tree;

/**
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 */
public class LowestCommonAncestorOfABinarySearchTree_235 {

    // T = O(log(n))算法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode t = root;
        while (t != p){
            if (p.val < t.val && q.val < t.val) t = t.left;
            else if (p.val > t.val && q.val > t.val) t = t.right;
            else return t;
        }
        return t;
    }

    // 递归算法
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p) return p;
        if (root == q) return q;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor1(root.left, p, q);
        else if (p.val > root.val && q.val > root.val) return lowestCommonAncestor1(root.right, p, q);
        else return root;
    }


    // 递归算法，没有考虑是否是搜索树
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p) return p;
        if (root == q) return q;
        boolean left = isExsit(root.left,p,q);
        boolean right = isExsit(root.right,p,q);
        if (left && right) return root;
        if (left) return lowestCommonAncestor2(root.left,p,q);
        if (right) return lowestCommonAncestor2(root.right,p,q);
        return null;

    }

    // 判断节点是否存在与此树中
    public boolean isExsit(TreeNode root,TreeNode p,TreeNode q) {
        if (root == null) return false;
        if (root == p || root == q) return true;
        return isExsit(root.left,p,q) || isExsit(root.right,p,q);
    }
}
