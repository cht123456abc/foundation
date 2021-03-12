package cn.edu.scu.algorithms.search;

import java.util.Queue;

/**
 * bfs
 */
public class BFS {

    /**
     * 求图G中start->dst的最短距离
     * @param G 无权有向图 已经初始化的
     * @param visited 访问数组 初始为false
     * @param dist 距离数组 初始为0
     * @param queue bfs的队列
     * @param start 开始点
     * @param dst 终点
     * @return start->dst的距离
     */
    public int bfs(int[][] G, boolean[] visited, int[] dist, Queue<Integer> queue, int start, int dst){
        if(start == dst) return dist[dst];
        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int from = queue.poll();
            if(from == dst) return dist[dst];
            for (int i = 0; i < G.length; i++) {
                if (!visited[i] && G[from][i] == 1) {
                    visited[i] = true;
                    dist[i] = dist[from] + 1;
                    queue.offer(i);
                }

            }
        }
        return -1;// 没有start->dst的路径
    }
}
