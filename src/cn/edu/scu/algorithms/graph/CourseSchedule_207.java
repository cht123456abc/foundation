package cn.edu.scu.algorithms.graph;

import java.util.*;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 *
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 *
 * 提示：
 *
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 */
public class CourseSchedule_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建邻接表
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i = 0;i < prerequisites.length;i++){
            int pre = prerequisites[i][1];
            int dst = prerequisites[i][0];
            if(!graph.containsKey(pre)){
                List<Integer> out = new ArrayList<>();
                out.add(dst);
                graph.put(pre,out);
            }else{
                List<Integer> out = graph.get(pre);
                out.add(dst);
            }
        }
        int[] visited = new int[numCourses];// 记录每个点的三种状态，0->未经过，1->正在经过，2->完全经过
        // dfs判断是否有环
        boolean res = true;
        for(int i = 0;i < numCourses;i++){
            if(visited[i] == 0){
                res = res && dfs(graph,visited,i);
            }
        }
        return res;
    }

    public boolean dfs(Map<Integer,List<Integer>> graph,int[] visited,int index){
        if(visited[index] == 1) return false;// 遇到正在遍历的路径
        if(visited[index] == 2) return true;// 遇到已经遍历过的点
        visited[index] = 1;
        List<Integer> out = graph.get(index);
        if(out == null){// 没有出度遍历完成
            visited[index] = 2;
            return true;
        }
        boolean res = true;
        for(Integer o : out){
            res = res && dfs(graph,visited,o);
        }
        visited[index] = 2;
        return res;
    }

    public static void main(String[] args) {
        CourseSchedule_207 courseSchedule_207 = new CourseSchedule_207();
        int[][] edges = new int[3][2];
        edges[0][0] = 1;
        edges[0][1] = 0;
        edges[1][0] = 2;
        edges[1][1] = 0;
        edges[2][0] = 0;
        edges[2][1] = 2;

        System.out.println(courseSchedule_207.canFinish(3, edges));
    }
}
