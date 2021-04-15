package cn.edu.scu.exam;

import java.util.Scanner;

public class 评分最高的两本书 {

    public static void main(String[] args) {




        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();


        for(int k = 0;k < t;k++){

            int n = scanner.nextInt();
            int[][] arr = new int[n][5];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 5; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            int[] maxc = new int[5];
            int[] maxc_idx = new int[5];
            for (int i = 0; i < 5; i++) {
                for(int j = 0;j < n;j++){
                    if(arr[j][i] > maxc[i]){
                        maxc[i] = arr[j][i];
                        maxc_idx[i] = j;
                    }

                }
            }

//            for (int i : maxc) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//
//            for (int maxcIdx : maxc_idx) {
//                System.out.print(maxcIdx + " ");
//
//            }



            int min = Integer.MAX_VALUE;


            int min_idx = 0;
            for (int i = 0; i < 5; i++) {
                if (maxc[i] < min){
                    min = maxc[i];
                    min_idx = maxc_idx[i];
                }
            }

//            System.out.println(min);
//            System.out.println(min_idx);


            int[] one = arr[min_idx];
//            for (int i : one) {
//                System.out.print(i + " ");
//
//            }

            int another_idx = 0;
            for (int i = 0; i < n; i++) {

                int max = 0;
                int j = 0;
                for (;j < 5; j++) {
                    max = Math.max(arr[i][j], one[j]);
                    if(max < min) break;
                }
                if(j == 5 && i != min_idx){
                    another_idx = i;
                    break;
                }

            }

//            System.out.println(another_idx);

            if (min_idx > another_idx) {
                int temp = min_idx;
                min_idx = another_idx;
                another_idx = temp;
            }

            min_idx++;
            another_idx++;

            System.out.print(min);
            System.out.print(" ");
            System.out.print(min_idx);
            System.out.print(" ");
            System.out.print(another_idx);
//            System.out.println(min + " " + min_idx + " " + another_idx);

        }

    }
}
