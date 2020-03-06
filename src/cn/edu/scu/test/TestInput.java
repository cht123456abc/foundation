package cn.edu.scu.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestInput {

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        String s = input.nextLine();
//        input.close();

        System.out.println("===============");

        BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s2 = input2.readLine();
            input2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("++++++++++");
    }
}
