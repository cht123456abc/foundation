package cn.edu.scu.exam;

import java.util.*;

public class 员工打卡 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
//            int n = in.nextInt();
            int[] arrM = new int[30];
            for (int i = 0; i < 30; i++) {
                int m = in.nextInt();
                arrM[i] = m;
            }

            int[][] count = new int[n][2];
            int[][] arr = new int[30][];
            int k = 0;// 先后关系优先级
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < arrM[i]; j++) {
                    int id = in.nextInt();
//                    arr[i][j] = id;
                    if (count[id][0] == 0) {
                        count[id][1] = k++;
                    }
                    count[id][0]++;

                }
            }

            PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
                if (o2[1] == o1[1]) {
                    if (o1[2] == o2[2]) {
                        return o1[0] - o2[0];
                    }
                    return o1[2] - o2[2];
                }
                return o2[1] - o1[1];
            });
            for (int i = n-1; i >=0; i--) {
                if(count[i][0] == 0) continue;
                heap.add(new int[]{i,count[i][0],count[i][1]});
            }

            for (int i = 0; i < 5 && !heap.isEmpty(); i++) {
                System.out.print(heap.poll()[0] + " ");
            }

        }
    }
}
