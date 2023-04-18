package cn.edu.scu.algorithms.tree;

public class MaxAncestorDiff {

    // 维护从根节点到叶子节点的最大值和最小值，在从上到下的遍历过程中不断更新
    int res = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, 0, Integer.MAX_VALUE);
        return res;
    }

    private void dfs(TreeNode root, int max, int min) {
        if (root == null) return;

        if (root.val > max) {
            max = root.val;
        }
        if (root.val < min) {
            min = root.val;
        }
        res = Math.max(res, max - min);
        dfs(root.left, max, min);
        dfs(root.right, max, min);

    }
}
