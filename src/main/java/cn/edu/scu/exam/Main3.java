package cn.edu.scu.exam;

import java.util.*;

/**
 * 图
 */
public class Main3 {

    // 构造图 + 亲和互斥剪枝 ，最终求最小值
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            Integer n = scanner.nextInt();// 边的个数
            List<String> edges = new ArrayList<>();
            while(n > 0){
                edges.add(scanner.nextLine());
                n--;
            }
            Integer m = scanner.nextInt();// 条件的个数
            List<String> condition = new ArrayList<>();
            while (m > 0) {
                condition.add(scanner.nextLine());
                m--;
            }
            String two = scanner.nextLine();
            String[] twos = two.split(" ");
            // 构造图
            Map<Integer,List<Integer>> graph = new HashMap<>();
            int[][] distance = new int[1001][1001];
            for (String s : edges) {
                String[] ss = s.split(" ");
                Integer point1 = Integer.parseInt(ss[0]);
                Integer point2 = Integer.parseInt(ss[1]);
                distance[point1][point2] = Integer.parseInt(ss[2]);
                distance[point2][point1] = Integer.parseInt(ss[2]);

                List<Integer> edge;
                if (graph.containsKey(point1)) {
                    edge = graph.get(point1);
                } else {
                    edge = new ArrayList<>();
                    graph.put(point1, edge);
                }
                edge.add(point2);

            }

            // 条件表
            int[][] condi = new int[1001][1001];
            for (String s : condition) {
                String[] ss = s.split(" ");
                Integer point1 = Integer.parseInt(ss[0]);
                Integer point2 = Integer.parseInt(ss[1]);
                condi[point1][point2] = Integer.parseInt(ss[2]);
                condi[point2][point1] = Integer.parseInt(ss[2]);
            }

            // 经过数组
            boolean[] visited = new boolean[1001];
            // dfs找到 two[0] two[1]之间的路径
            Integer a = Integer.parseInt(twos[0]);
            Integer b = Integer.parseInt(twos[1]);
            Integer res = dfs(graph,distance,condi,visited,a,b);

            System.out.println(res);

        }
    }

    private static Integer dfs(Map<Integer, List<Integer>> graph, int[][] distance,int[][] condi, boolean[] visited,Integer cur, Integer dist) {

        if(visited[cur]) return 0;
        if(cur == dist) {
            return 0;
        }
        visited[cur] = true;
        List<Integer> edge = graph.get(cur);
        Integer res = Integer.MAX_VALUE;
        for (Integer e : edge) {
            visited[e] = true;
            res = Math.min(res,distance[cur][e] + dfs(graph, distance,condi, visited, e, dist));
        }
        return res;
    }
}
