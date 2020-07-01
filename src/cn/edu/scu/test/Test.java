package cn.edu.scu.test;

import java.util.*;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Set<String> set = list.stream().collect(Collectors.toSet());
    }
}
