package cn.edu.scu.exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最少需要主持人数 {

    // 方法一 排序+遍历
    // 将区间分为两个数组分别排序；按活动开始时间数组从小到大遍历，如果第二个活动开始时间大于第一个活动结束时间，那么进行下一个活动的比较；
    // 否则判断两个活动重叠，结果+1
    public int minmumNumberOfHost (int n, int[][] startEnd) {
        // 求最少需要多少名主持人，也就是求有重叠活动时间段最大活动数量
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = startEnd[i][0];
            end[i] = startEnd[i][1];
        }

        // 排序
        Arrays.sort(start);
        Arrays.sort(end);

        // 遍历
        int res = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (start[i] >= end[j]) {
                j++;
            } else {
                res++;
            }
        }
        return res;
    }

    // 方法二
    public int minmumNumberOfHost2 (int n, int[][] startEnd) {
        //按列排序，按开始时间递增排
        Arrays.sort(startEnd, Comparator.comparingInt(o -> o[0]));
        //小顶堆
        PriorityQueue<Integer> q = new PriorityQueue<>();
        //可能有负区间
        q.offer(Integer.MIN_VALUE);
        for(int i = 0; i < n; i++){
            //最近的活动结束时间小于当前活动开始时间
            if(q.peek() <= startEnd[i][0])
                q.poll();
            q.offer(startEnd[i][1]);
        }
        //剩余的活动等于主持人数
        return q.size();
    }
}
