package cn.edu.scu.algorithms.greed;

/**
 * Dijkstra 算法求最短路径
 */
public class Dijkstra {


    /**
     *
     * @param graph 用邻接矩阵表示的图
     * @param start 起点
     * @return start到其余所有顶点的最短距离
     */
    public int[] dijkstra(int[][] graph, int start) {
        int n = graph.length;
        boolean[] visited = new boolean[n];// 已访问过的顶点
        int[] dist = new int[n];// start到其余各点的最短距离，没有边为∞

        // 初始化dist
        System.arraycopy(graph[start], 0, dist, 0, n);
        visited[start] = true;

        // 外层循环遍历每个节点
        for (int i = 0; i < n; i++) {
            // 内循环一，找到visited = false的，距离start最短的顶点作为middle
            int middle = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    middle = j;
                }
            }
            visited[middle] = true;
            // 内循环二，找到visited = false的其余各个点k，更新start - k 的最短距离
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[middle] < dist[j] - graph[middle][j]) {
                    dist[j] = dist[middle] + graph[middle][j];
                }
            }
        }
        return dist;

    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        int n = 4;
        int[][] graph = new int[n][n];
        // 初始化图
        graph[1][2] = 100;
        graph[2][1] = 100;
        graph[2][3] = 200;
        graph[3][2] = 200;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) graph[i][j] = 0;
                else if (graph[i][j] == 0) {
                    graph[i][j] = Integer.MAX_VALUE;
                }
                System.out.print(graph[i][j] + "\t\t\t");

            }
            System.out.println();
        }
        int[] dist = dijkstra.dijkstra(graph, 1);
        System.out.println();
        for (int i : dist) {
            System.out.println(i);
        }
    }
}
