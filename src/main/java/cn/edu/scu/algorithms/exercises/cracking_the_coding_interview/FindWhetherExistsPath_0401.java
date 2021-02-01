package cn.edu.scu.algorithms.exercises.cracking_the_coding_interview;


import java.util.*;

/**
 * 面试题 04.01. 节点间通路
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 *
 * 示例1:
 *
 *  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 *  输出：true
 * 示例2:
 *
 *  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 *  输出 true
 * 提示：
 *
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 */
public class FindWhetherExistsPath_0401 {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (start == target) {
            return true;
        }
        for (int[] g : graph) {
            if (g[1] == target) {
                return findWhetherExistsPath(n, graph, start, g[0]);
            }
        }
        return false;
    }

    public boolean findWhetherExistsPath1(int n, int[][] graph, int start, int target) {

        // 构建连接表
        Map<Integer, Set<Integer>> G = new HashMap<>();
        // 初始化
        for (int i = 0; i < graph.length; i++) {
            int node = graph[i][0];
            int next = graph[i][1];
            Set<Integer> edge;
            if (G.containsKey(node)) {
                edge = G.get(node);
            } else {
                edge = new HashSet<>();// 去重
            }
            edge.add(next);
            G.put(node, edge);
        }

        // dfs
        return findPath(G, start, target);

    }

    private boolean findPath(Map<Integer, Set<Integer>> graph, int root, int target) {
        if(root == target) return true;
        if(graph.get(root) == null) return false;

        boolean res = false;
        for (Integer child : graph.get(root)) {
            res = res || findPath(graph,child,target);
        }
        return res;
    }
}
