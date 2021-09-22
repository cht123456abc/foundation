package cn.edu.scu.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 小于n的最大数 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String in = scanner.nextLine();

        char[] sin = in.toCharArray();
        int n = sin.length;

        int max_i  = 0;
        int max_j = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = sin[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                char c2 = sin[j];
                if (c2 > c) {
                    if (j > max_j) {
                        max_j = j;
                        max_i = i;
                    } else if (max_j == j) {
                        max_i = c > sin[max_i] ? i : max_i;
                    }

                    break;
                }
            }
            if (max_j >= i) {
                break;
            }

        }

        char temp = sin[max_i];
        sin[max_i] = sin[max_j];
        sin[max_j] = temp;

        if (max_i <= max_j) {
            System.out.println(0);
        } else {
            System.out.println(sin);

        }
    }
}
