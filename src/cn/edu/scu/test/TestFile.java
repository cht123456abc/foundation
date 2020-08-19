package cn.edu.scu.test;

import java.io.File;

public class TestFile {

    public static void main(String[] args) {

        File file = new File("/Users/cht/squirrel-vpn.dat");
        System.out.println(file.isDirectory());
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());
        System.out.println(file.getPath());
        file = new File(file.getParent() + "/path");
        System.out.println(file.mkdirs());
        System.out.println(file.mkdir());
    }
}
