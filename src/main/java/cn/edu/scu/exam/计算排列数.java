package cn.edu.scu.exam;

import java.util.Scanner;

public class 计算排列数 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String S = scanner.nextLine();


        int n = S.length();

        int[] map = new int[26];

        for (char c : S.toCharArray()) {
            map[c-'A']++;
        }

        long fenmu = 1;
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                fenmu *= factorial(map[i]);
            }
        }

        System.out.println(factorial(n) / fenmu);
    }


    private static long factorial(long a) {
        if (a <= 1) return 1;
        return a * factorial(a - 1);
    }
}
