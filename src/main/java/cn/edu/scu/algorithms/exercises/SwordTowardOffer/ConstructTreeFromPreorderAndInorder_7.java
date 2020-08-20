package cn.edu.scu.algorithms.exercises.SwordTowardOffer;


/**
 * 面试题07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *
 *
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructTreeFromPreorderAndInorder_7 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder,int prelo,int prehi,int[] inorder, int inlo,int inhi){
        if(prelo > prehi || inlo > inhi) return null;
        int root_val = preorder[prelo];
        TreeNode root = new TreeNode(root_val);
        // 在中序数组中找到root_val的位置
        int pos = -1;
        for(int i = inlo;i <= inhi;i++){
            if(root_val == inorder[i]) pos = i;
        }
        int len = pos - inlo;
        root.left = build(preorder,prelo+1,prelo+len,inorder,inlo,pos-1);
        root.right = build(preorder,prelo+len+1,prehi,inorder,pos+1,inhi);
        return root;
    }
}
