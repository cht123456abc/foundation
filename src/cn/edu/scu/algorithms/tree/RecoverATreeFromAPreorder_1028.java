package cn.edu.scu.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1028. 从先序遍历还原二叉树
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 *
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 *
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 *
 * 给出遍历输出 S，还原树并返回其根节点 root。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 *
 *
 *
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 *
 *
 *
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 *
 *
 * 提示：
 *
 * 原始树中的节点数介于 1 和 1000 之间。
 * 每个节点的值介于 1 和 10 ^ 9 之间。
 */
public class RecoverATreeFromAPreorder_1028 {

    public TreeNode recoverFromPreorder(String S) {
        // 拆分
        Queue<int[]> queue = new LinkedList<>();// 先解析为深度信息和值成对的队列
        int n = S.length();
        int i = 0;
        while(i < n) {
            int[] pair = new int[2];
            // 计算横线长度
            int l = i;
            char c = S.charAt(i);
            while(c == '-'){
                c = S.charAt(++i);
            }
            pair[0] = i - l;
            l = i;
            while (Character.isDigit(c)) {
                i++;
                if(i == n) break;
                c = S.charAt(i);
            }
            pair[1] = Integer.parseInt(S.substring(l, i));
            queue.offer(pair);
        }
        // 反序列化
        return decode(queue,0);
    }

    // dfs 反序列化
    public TreeNode decode(Queue<int[]> queue,int depth){
        if(queue.isEmpty()) return null;
        int[] pair = queue.peek();
        int depth0 = pair[0];
        int num = pair[1];
        if(depth0 != depth) return null;
        TreeNode root = new TreeNode(num);
        queue.poll();
        root.left = decode(queue,depth+1);
        root.right = decode(queue,depth+1);
        return root;
    }

    public static void main(String[] args) {
        String S = "1-2--3--4-5--6--7";
        RecoverATreeFromAPreorder_1028 recoverATreeFromAPreorder_1028 = new RecoverATreeFromAPreorder_1028();
        recoverATreeFromAPreorder_1028.recoverFromPreorder(S);
    }
}
