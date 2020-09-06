package cn.edu.scu.algorithms.exercises.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. 回旋镖的数量
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 *
 * 示例:
 *
 * 输入:
 * [[0,0],[1,0],[2,0]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 */
public class NumberOfBoomerangs_447 {

    public int numberOfBoomerangs(int[][] points) {
        // 构建邻接矩阵edge[x][y] = z,存储顶点x到顶点y的边长z
        int n = points.length;
        int[][] edge = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                if(i == j) continue;
                edge[i][j] = edge[j][i] = (int)Math.pow(points[j][0] - points[i][0],2) + (int)Math.pow(points[j][1]-points[i][1],2);// 这里因为是int,所以就直接存平方和，而不用开方
            }
        }
        // 遍历每个顶点，统计属于该顶点的不同边长组成的等腰三角形
        int count = 0;
        Map<Integer,Integer> edgeNum;
        for(int i = 0;i < n;i++){
            edgeNum = new HashMap<>();
            for(int j = 0;j < n;j++){
                if(i == j) continue;
                edgeNum.put(edge[i][j],edgeNum.getOrDefault((edge[i][j]),0)+1);
            }
            // 计算等腰三角形个数
            for(Map.Entry<Integer,Integer> entry : edgeNum.entrySet()){
                int num = entry.getValue();
                count += num * (num-1);
            }
        }
        return count;
    }
}
