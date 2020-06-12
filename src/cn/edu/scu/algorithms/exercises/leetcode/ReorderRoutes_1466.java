package cn.edu.scu.algorithms.exercises.leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * 1466. 重新规划路线
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 *
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 *
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 *
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 *
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * 输出：3
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 2：
 *
 *
 *
 * 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * 输出：2
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 3：
 *
 * 输入：n = 3, connections = [[1,0],[2,0]]
 * 输出：0
 *
 *
 * 提示：
 *
 * 2 <= n <= 5 * 10^4
 * connections.length == n-1
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] <= n-1
 * connections[i][0] != connections[i][1]
 * 通过次数2,934提交次数5,666
 */
public class ReorderRoutes_1466 {
    int N = (int)5e4 + 50;
    
    // bfs,图的代码展现一般用邻接表，内存占用少和查找效率高。
    public int minReorder(int n, int[][] connections) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[n];
        List<int[]>[] edges = new List[n];

        // 初始化
        for(int i = 0;i < n;i++){
            edges[i] = new ArrayList<>();
        }

        // 转换为图
        for (int[] connection : connections) {
            int v = connection[0],w = connection[1];
            edges[v].add(new int[]{w,1});
            edges[w].add(new int[]{v,0});
        }
        int res = 0;
        queue.add(0);
        vis[0] = true;
        while(!queue.isEmpty()){
            int v = queue.remove();
            for (int[] pair : edges[v]) {
                int w = pair[0];
                if(vis[w]) continue;
                res += pair[1];
                vis[w] = true;
                queue.add(w);
            }
        }
        return res;

    }
}
