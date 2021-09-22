package cn.edu.scu.exam;

import java.util.Scanner;

public class 千分位 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder(line);

        int n = line.length();
        for (int i = n - 3; i >= 0; i -= 3) {

            stringBuilder.insert(i, ",");
        }
        System.out.println(stringBuilder);
    }
}
