package cn.edu.scu.exam;

import java.util.LinkedList;
import java.util.Queue;

public class 计算疫情扩散时间 {

    public static int infect(int[][] matrix) {
        // bfs
        Queue<int[]> queue = new LinkedList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 1) queue.offer(new int[]{i,j});
            }
        }

        int res = 0;
        int[] dir = new int[]{0, 1, 0, -1, 0};
        int count = queue.size();
        int nextCount = count;
        int last = 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            last++;
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k];
                int ny = y + dir[k + 1];
                if (matrix[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    matrix[nx][ny] = 1;
                    nextCount++;
                }
            }
            if(last == count){
                res++;
                count = nextCount;
            }
        }
        return res;

    }
}
