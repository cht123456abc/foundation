package cn.edu.scu.exam;

import java.util.Arrays;

public class 兑换零钱一 {

    public class Solution {
        /**
         * 最少货币数
         * @param arr int整型一维数组 the array
         * @param aim int整型 the target
         * @return int整型
         */
        // 0-1背包 的变形
        public int minMoney (int[] arr, int aim) {
            if(aim == 0) return 0;

            int n = arr.length;
            int[] dp = new int[aim+1];// 组成钱数为i时，所需要的最小货币量

            // 初始化
            Arrays.fill(dp,aim+1);
            dp[0] = 0;

            // 状态转移
            for(int i = 1;i<=aim;i++){
                for(int j=0;j<arr.length;j++){
                    if(arr[j] <= i){
                        dp[i] = Math.min(dp[i],dp[i-arr[j]]+1);
                    }
                }
            }
            return dp[aim] > aim ? -1 : dp[aim];


        }
    }
}
