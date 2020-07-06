package cn.edu.scu.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Character> a = new ArrayList<>();

        Character[] chars = a.toArray(new Character[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("123");
        sb.delete(0,1);
        System.out.println(sb.toString());

    }
}
