package cn.edu.scu.algorithms.exercises.leetcode;

import cn.edu.scu.algorithms.tree.TreeNode;

import java.util.*;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例:
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
public class SerializeAndDeserializeBinaryTree_297 {

    // 方法一：dfs
    // 前序遍历dfs序列化
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return dfs(root,sb).toString();
    }

    public StringBuilder dfs(TreeNode root,StringBuilder res){
        if(root == null){
            res.append("null,");
            return res;
        }
        res.append(root.val).append(",");
        dfs(root.left,res);
        dfs(root.right,res);
        return res;
    }

    // 用队列来装
    public TreeNode deserialize(String data) {
        String[] datas = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(datas));
        return dedfs(queue);
    }

    public TreeNode dedfs(Queue<String> queue){
        if(queue.peek().equals("null")){
            queue.poll();
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(queue.poll()));
        root.left = dedfs(queue);
        root.right = dedfs(queue);
        return root;
    }


    // 方法二：层次遍历，空间超出
    public String serialize1(TreeNode root) {
        // 用dfs来层次遍历,首先得知道总共有多少层
        int h = depth(root);
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res, h);
        // 将res转换为String data
        StringBuilder sb = new StringBuilder();
        for (List<Integer> level : res) {
            for (Integer i : level) {
                sb.append(i).append(",");
            }
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        String[] datas = data.split(",");// 数据长度
        int n = datas.length;
        TreeNode[] nodes = new TreeNode[n];
        TreeNode root = null;
        // 根据层序遍历序列转换为二叉树
        for (int j = 0; j < n; j++) {
            if (!"null".equals(datas[j])) {
                TreeNode node = new TreeNode();
                node.val = Integer.parseInt(datas[j]);
                // 将节点装数组里面
                nodes[j] = node;
                if (j == 0) {
                    root = node;
                    continue;
                }
                // 计算父节点的左右引用
                int parent = 0;
                if ((j - 1) % 2 == 0) {
                    // j为左孩子
                    parent = (j - 1) / 2;
                    nodes[parent].left = node;
                } else {
                    // j为右孩子
                    parent = (j - 2) / 2;
                    nodes[parent].right = node;
                }
            }
        }
        return root;
    }

    public void dfs(TreeNode root, int depth, List<List<Integer>> res, int h) {
        if (depth > h) return;
        if (depth == res.size()) {
            // 该层还没有创建数组
            res.add(new ArrayList<>());
        }
        if (root != null) {
            res.get(depth).add(root.val);
            dfs(root.left, depth + 1, res, h);
            dfs(root.right, depth + 1, res, h);
        } else {
            res.get(depth).add(null);
            dfs(null, depth + 1, res, h);
            dfs(null, depth + 1, res, h);
        }
    }

    // 求树的高度
    public int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
