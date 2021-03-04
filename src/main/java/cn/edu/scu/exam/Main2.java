package cn.edu.scu.exam;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 通过前序和中序数组构成的树，并层序打印这棵树
 */
public class Main2 {

    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char x) {
            val = x;
        }

        public TreeNode() {

        }
    }

    // 构造二叉树 + bfs层次遍历
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            String[] two = line.split(" ");
//            System.out.println(two[0]);
//            System.out.println(two[1]);

            char[] pre = two[0].toCharArray();
            char[] in = two[1].toCharArray();

            // 构造二叉树
            TreeNode root = construct(pre, in);

            // 层序遍历二叉树
            String res = levelTraverse(root);

            // 输出结果
            System.out.println(res);
        }

    }

    private static String levelTraverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        String res = "";
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            res = res + head.val;
            if(head.left != null){
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }
        }
        return res;
    }


    private static TreeNode construct(char[] pre, char[] in) {
        return build(pre,0,pre.length-1,in,0,in.length-1);
    }

    private static TreeNode build(char[] preorder, int prelo, int prehi, char[] inorder, int inlo, int inhi){
        if(prelo > prehi || inlo > inhi) return null;
        char root_val = preorder[prelo];
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
