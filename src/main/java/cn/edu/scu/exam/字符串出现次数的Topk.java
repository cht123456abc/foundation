package cn.edu.scu.exam;

import java.util.*;

public class 字符串出现次数的Topk {

    public String[][] topKstrings (String[] strings, int k) {

        Map<String, Integer> map = new HashMap<>();
        for (String string : strings) {
            map.put(string, map.getOrDefault(string, 0) + 1);
        }

        Queue<String> queue = new PriorityQueue<>((o1, o2) -> {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2) {
                return compareStrings(o1, o2);
            }
            return count2 - count1;
        });


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry.getKey());
        }

        String[][] ans = new String[k][2];
        for (int i = 0; i < k; i++) {
            ans[i][0] = queue.poll();
            ans[i][1] = String.valueOf(map.get(ans[i][0]));
        }
        return ans;
    }

    public int compareStrings(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        for (int i = 0; i < n1 || i < n2; i++) {
            if (i >= n1) return -1;
            if (i >= n2) return 1;
            if (ss1[i] < ss2[i]) return -1;
            if (ss1[i] > ss2[i]) return 1;
        }
        return 0;
    }
}
