package cn.edu.scu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int k = scanner.nextInt();

        int[] mat = new int[n];

        for (int i = 0; i < n; i++) {
            mat[i] = scanner.nextInt();

        }

        if (mat[k - 1] == 0) {

            System.out.println(0);
            return;
        }

        int mid = k - 1;
        long res = 0;

        int j = mid + 1;
        while (j < n && mat[j] > 1) {
            res += mat[j];
            j++;
        }
        if (j < n && mat[j] == 1) res++;

        j = mid - 1;
        while (j >= 0 && mat[j] > 1) {
            res += mat[j];
            j--;
        }
        if (j >= 0 && mat[j] == 1) res++;

        res += mat[mid];
        System.out.println(res);

    }
}
