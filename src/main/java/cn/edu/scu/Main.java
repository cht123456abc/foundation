package cn.edu.scu;

import cn.edu.scu.algorithms.tree.TreeNode;

public class Main {


    private static String message = "abcd";

    public static void main(String[] args) {
        String a = "ab" + "cd";
        String b = "ab";
        String c = "cd";

        System.out.println(a == message);
        System.out.println(b+c == message);


    }
}
