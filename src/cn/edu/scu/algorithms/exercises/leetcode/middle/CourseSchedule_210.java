package cn.edu.scu.algorithms.exercises.leetcode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 210. 课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 *
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 说明:
 *
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 */
public class CourseSchedule_210 {

    int time;// 全局时间
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 拓扑排序
        // 构建邻接表
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[1];
            int dst = prerequisite[0];
            if (!graph.containsKey(pre)) {
                List<Integer> out = new ArrayList<>();
                out.add(dst);
                graph.put(pre, out);
            } else {
                List<Integer> out = graph.get(pre);
                out.add(dst);
            }
        }
        int[] visited = new int[numCourses];// 记录每个点的三种状态，0->未经过，1->正在经过，2->完全经过
        // dfs判断是否有环,并且根据时间记录拓扑顺序
        boolean res = true;
        int[] topo = new int[numCourses];
        for(int i = 0;i < numCourses;i++){
            if(visited[i] == 0){
                res = res && dfs(graph,visited,i,topo);
            }
        }
        if(!res) return new int[0];
        // 反转topo
        reverse(topo);
        return topo;
    }

    public boolean dfs(Map<Integer,List<Integer>> graph,int[] visited,int index,int[] topo){
        if(visited[index] == 1) return false;// 遇到正在遍历的路径
        if(visited[index] == 2) return true;// 遇到已经遍历过的点
        visited[index] = 1;
        List<Integer> out = graph.get(index);
        if(out == null){// 没有出度遍历完成
            topo[time++] = index;
            visited[index] = 2;
            return true;
        }
        boolean res = true;
        for(Integer o : out){
            res = res && dfs(graph,visited,o,topo);
        }
        visited[index] = 2;
        topo[time++] = index;
        return res;
    }

    public void reverse(int[] a){
        int n = a.length;
        int i = 0,j = n-1;
        while(i < j){
            int temp = a[i];
            a[i++] = a[j];
            a[j--] = temp;
        }
    }
}
