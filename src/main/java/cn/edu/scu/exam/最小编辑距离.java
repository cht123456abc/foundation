package cn.edu.scu.exam;

public class 最小编辑距离 {

    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int n1 = s1.length;
        int n2 = s2.length;

        int[][] dp = new int[n1+1][n2+1];

        for(int i = 1;i<=n1;i++){
            dp[i][0] = dp[i-1][0] + dc;// 删除
        }
        for(int j = 1;j <=n2;j++){
            dp[0][j] = dp[0][j-1] + ic;// 添加
        }



        for(int i = 1;i < n1+1;i++){
            for(int j = 1;j < n2+1;j++){
                if(s1[i-1] == s2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j] + dc,dp[i][j-1] + ic),dp[i-1][j-1] + rc);
                }
            }
        }

        return dp[n1][n2];
    }
}
