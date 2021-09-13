package cn.edu.scu.exam;

import java.util.*;

public class 最佳节点 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = scanner.nextInt();
        }

        Map<Integer,List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < n; i++) {
            edges.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            edges.get(a).add(b);
        }

        int res = -1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            int first = sum(vals, edges, 0, i);
            int second = sum(vals,edges,i,n);
            int sum = Integer.MIN_VALUE;
            sum = Math.max(sum, Math.abs(first - second));
            if (sum > max) {
                max = sum;
                res = i;
            }
        }

        System.out.println(res);
    }

    private static int sum(int[] vals, Map<Integer,List<Integer>> edges, int start, int end) {
        int sum = 0;
        LinkedList<Integer> list = new LinkedList<>();
        list.offer(start);
        while (!list.isEmpty()) {
            int node = list.poll();
            sum += vals[node];
            for(int child : edges.get(node)){
                if (child == end) {
                    continue;
                }
                list.offer(child);
            }
        }
        return sum;
    }


}
