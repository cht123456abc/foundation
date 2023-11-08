package cn.edu.scu.exam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 计算最大乘积 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String line = in.nextLine();

            String[] lines = line.split(",");

            System.out.println(maxProduct(lines));
        }
    }

    private static int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        int n = words.length;
        int[] bitRepresentations = new int[n];

        for (int i = 0; i < n; i++) {
            String word = words[i];
            int bitRepresentation = 0;
            for (int j = 0; j < word.length(); j++) {
                bitRepresentation |= 1 << (word.charAt(j) - 'a');
            }
            bitRepresentations[i] = bitRepresentation;
        }

        int maxLength = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bitRepresentations[i] & bitRepresentations[j]) == 0) {
                    maxLength = Math.max(maxLength, words[i].length() * words[j].length());
                }
            }
        }

        return maxLength;
    }


    private static int maxProduct1(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        int n = words.length;
        Set<Character>[] sets = new Set[n];

        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
            for (int j = 0; j < words[i].length(); j++) {
                sets[i].add(words[i].charAt(j));
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!exist(sets[i], sets[j])) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }

            }
        }
        return res;
    }

    private static boolean exist(Set<Character> a, Set<Character> b) {
        return a.stream().anyMatch(b::contains);
    }
}
