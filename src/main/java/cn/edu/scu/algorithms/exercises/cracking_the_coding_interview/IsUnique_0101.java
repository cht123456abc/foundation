package cn.edu.scu.algorithms.exercises.cracking_the_coding_interview;

/**
 * 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 */
public class IsUnique_0101 {

    public boolean isUnique(String astr) {

        int[] map = new int[125];

        for (int i = 0; i < astr.length(); i++) {

            char c = astr.charAt(i);
            if(map[c] == 1) return false;
            else map[c] = 1;
        }

        return true;
    }
}
