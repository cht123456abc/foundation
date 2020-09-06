package cn.edu.scu.test;

import java.io.IOException;
import java.net.URL;

public class TestJavaPath {

    public static void main(String[] args) {
        System.out.println(TestJavaPath.class.getResource(""));
        System.out.println(TestJavaPath.class.getResource("/"));
        System.out.println(System.getProperty("foundation"));


    }
}
