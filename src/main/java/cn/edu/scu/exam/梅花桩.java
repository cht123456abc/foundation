package cn.edu.scu.exam;


import java.util.Scanner;

public class 梅花桩 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String f = scanner.nextLine();
        String[] fs = f.split(",");
        int M = Integer.parseInt(fs[0]);
        int N = Integer.parseInt(fs[1]);

        int[][] mat = new int[M][N];
        for(int i = 0 ;i < M;i++){
            for(int j = 0;j < N;j++){
                mat[i][j] = scanner.nextInt();
            }
        }

        int[][] dp = new int[M][N];
        for(int i = 0;i < M;i++){
            for(int j = 0;j < N;j++){
                dp[i][j] = 999;
            }
        }

        dp[0][0] = 0;

        for(int i = 0;i < M;i++){
            for(int j = 0;j < N;j++){
                int dist = mat[i][j];
                for (int k = 1; k <= dist; k++) {
                    if (i+k < M && mat[i+k][j] != 0){
                        dp[i+k][j] = Math.min(dp[i+k][j],dp[i][j] + 1);
                    }
                    if (j+k< N && mat[i][j+k] != 0){
                        dp[i][j + k] = Math.min(dp[i][j+k],dp[i][j] + 1);
                    }
                }

            }
        }

//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        if (dp[M - 1][N - 1] == 999) {
            System.out.println(-1);
        } else {
            System.out.println(dp[M-1][N-1]);
        }

    }

}

