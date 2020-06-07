package cn.edu.scu.algorithms.exercises.leetcode;

import java.util.*;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
public class NumbersOfIslands_200 {

    // dfs
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        if (m == 0) return 0;
        int res = 0;
        int[] dir_x = new int[]{0,-1,0,1};
        int[] dir_y = new int[]{-1,0,1,0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    // 遇到'1',就进行bfs
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }

    // bfs
    public int numIslands1(char[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        if (m == 0) return 0;
        int res = 0;
        int[] dir_x = new int[]{0,-1,0,1};
        int[] dir_y = new int[]{-1,0,1,0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    Queue<Integer> x = new LinkedList<>();
                    Queue<Integer> y = new LinkedList<>();
                    x.offer(i);
                    y.offer(j);
                    grid[i][j] = '0';// 应该在入队的时候就进行标记
                    while (!x.isEmpty()){
                        int r = x.poll();
                        int c = y.poll();
//                        grid[r][c] = '2';//不能将标记写在这里，这样会延迟标记，导致队列里面会产生重复的坐标。
                        for (int k = 0; k < 4; k++) {
                            int next_x = r + dir_x[k];
                            int next_y = c + dir_y[k];
                            if (next_x >= 0 && next_x < n && next_y >=0 && next_y < m && grid[next_x][next_y] == '1'){
                                // 加入队列
                                x.offer(next_x);
                                y.offer(next_y);
                                grid[next_x][next_y] = '0';// 应该在入队的时候就进行标记
                            }
                        }
                    }
                    res++;
                }
            }
        }
        return res;
    }
}
