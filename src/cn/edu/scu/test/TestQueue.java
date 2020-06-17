package cn.edu.scu.test;

import java.util.*;
import java.util.stream.Collectors;

public class TestQueue {

    public static void main(String[] args) {

        // 基本数据类型数组转集合，java8的优雅解决
        int[] list = new int[]{1,2,3,4};
        Queue<Integer> queue = Arrays.stream(list).boxed().collect(Collectors.toCollection(LinkedList::new));
        queue.forEach(System.out::println);

    }
}
