package cn.edu.scu;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        int[] a = new int[]{2, 1, 6};

        Arrays.sort(a);

        Arrays.stream(a).forEach(System.out::println);

    }
}