import cn.edu.scu.algorithms.tree.TreeNode;

public class TestNull {

    public static void main(String[] args) {

        TreeNode head = null;
        TreeNode p = head;// 这里的p 仍然和head无关。
        p = new TreeNode(0);
        System.out.println(p);
        System.out.println(head);
    }
}
