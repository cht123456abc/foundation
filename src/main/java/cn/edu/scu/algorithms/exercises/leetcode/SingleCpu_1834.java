package cn.edu.scu.algorithms.exercises.leetcode;

import java.util.*;

public class SingleCpu_1834 {

    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.<int[]>comparingInt(o -> o[0]).thenComparingInt(o -> o[1]));// [processTime,index] // 如果队列里面processTime是相同的，有可能会poll出index更大的task，所以需要先对processTime排序，再对index排序
        int[][] index_enqueueTime = new int[n][2];
        for (int i = 0; i < n; i++) {
            index_enqueueTime[i][0] = i;
            index_enqueueTime[i][1] = tasks[i][0];
        }
        Arrays.sort(index_enqueueTime, Comparator.comparingInt(o -> o[1]));// 这里排序

        List<Integer> res = new ArrayList<>();
        int timestamp = 0;
        int ptr = 0;
        for(int i = 0;i < n;i++)  {
            if (queue.isEmpty()) {
                timestamp = Math.max(timestamp,index_enqueueTime[ptr][1]);
            }

            int task;
            while (ptr < n && tasks[(task=index_enqueueTime[ptr][0])][0] <= timestamp) {
                queue.add(new int[]{tasks[task][1],task});
                ptr++;
            }
            int[] temp = queue.poll();
            timestamp += temp[0];
            res.add(temp[1]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
