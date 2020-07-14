package cn.edu.scu.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {


    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('c',1);
        map.put('h',1);
        map.put('a',1);
        map.put('b',1);
        map.put('a',1);
        map.forEach((k,v) -> System.out.println(k));
        System.out.println(map);
    }
}
