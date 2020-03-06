package cn.edu.scu.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		TreeSet<Integer> input = new TreeSet<Integer>();
        while (in.hasNextInt()) {
            int a = in.nextInt();
            input.add(a);
        }
        List<Integer> list = input.stream().collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
	}
}
