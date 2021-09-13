package cn.edu.scu.exam;

import java.text.NumberFormat;
import java.util.Scanner;

public class 单次重量 {


    public static void main(String[] args) {

        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);


        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine().trim();
        if (s.isEmpty()) {
            System.out.println(0);
            return;
        }


        String[] ss = s.split("\\s+");
        int total = 0;
        for (String s1 : ss) {
            total += s1.length();
        }

        double res = (double)total / (double)ss.length;

        System.out.println(numberFormat.format(res));
    }
}
