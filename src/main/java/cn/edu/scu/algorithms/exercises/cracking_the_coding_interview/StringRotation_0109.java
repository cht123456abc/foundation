package cn.edu.scu.algorithms.exercises.cracking_the_coding_interview;


/**
 * 面试题 01.09. 字符串轮转
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 * 示例2:
 *
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 * 提示：
 *
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 *
 * 你能只调用一次检查子串的方法吗？
 */
public class StringRotation_0109 {

    public boolean isFlipedString(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 != len2) return false;
        return (s2 + s2).contains(s1);

    }
}
