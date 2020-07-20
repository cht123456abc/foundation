package cn.edu.scu.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {


    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        Integer[][] a = list.stream().map(l -> l.toArray(new Integer[0])).toArray(Integer[][]::new);

        List<int[]> res = new ArrayList<>();
        int[][] b = res.toArray(new int[0][]);
    }
}
