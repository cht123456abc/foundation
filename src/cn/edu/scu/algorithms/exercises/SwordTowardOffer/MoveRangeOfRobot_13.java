package cn.edu.scu.algorithms.exercises.SwordTowardOffer;

/**
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class MoveRangeOfRobot_13 {

    public int movingCount(int m, int n, int k) {
        boolean[][] passed = new boolean[m][n];
        return dfs(m,n,k,0,0,passed);

    }

    // dfs + 剪枝
    public int dfs(int m,int n,int k,int r,int c,boolean[][] passed){
        if(r < 0 || c < 0 || r >= m || c >= n || passed[r][c] == true) return 0;
        if(dightsSum(r,c) > k) return 0;
        passed[r][c] = true;
        return 1 + dfs(m,n,k,r+1,c,passed)+dfs(m,n,k,r-1,c,passed)+dfs(m,n,k,r,c+1,passed)+dfs(m,n,k,r,c-1,passed);
    }

    public int dightsSum(int r,int c){
        int res = 0;
        while(r > 0){
            res += r % 10;
            r = r / 10;
        }
        while(c > 0){
            res += c % 10;
            c = c / 10;
        }
        return res;
    }
}
