package cn.edu.scu.exam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * bfs 最短路径问题
 */
public class BFS最短路 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String a = scanner.nextLine();
            int n = Integer.parseInt(a.split(" ")[0]);
            int m = Integer.parseInt(a.split(" ")[1]);


            int[][] graph = new int[n][n];
            int i = 1;
            int k = m;
            while(k > 0){
                String line = scanner.nextLine();
                String[] ab = line.split(" ");

                graph[Integer.parseInt(ab[0])-1][Integer.parseInt(ab[1])-1] = 1;
                k--;
            }
            // 测试次数N
            int N = Integer.parseInt(scanner.nextLine());
            k = N;
            while(scanner.hasNextLine()){
                // 开始测试
                String line = scanner.nextLine();
                String[] ss = line.split(" ");
                int from = Integer.parseInt(ss[0])-1;
                int dst = Integer.parseInt(ss[1])-1;

                int res = bfs(graph,n,from,dst);

                System.out.println(res);
                k--;
            }
        }
    }


    private static int bfs(int[][] graph, int n,int from, int dst) {
        int[] dist = new int[n];
        dist[from] = 0;
        boolean[] visited = new boolean[n];
        // 求from to dst的最短路径,没有为-1
        visited[from] = true;
        if(from == dst) return dist[dst];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(from);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if(start == dst) return dist[dst];

            int[] edges = graph[start];
            for (int i = 0; i < edges.length; i++) {
                if (!visited[i] && graph[start][i] == 1) {
                    // 访问
                    visited[i] = true;
                    dist[i] = dist[start] + 1;
                    queue.offer(i);
                }
            }

        }
        return -1;


    }


}
