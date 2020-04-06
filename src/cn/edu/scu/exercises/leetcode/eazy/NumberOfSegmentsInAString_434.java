package cn.edu.scu.exercises.leetcode.eazy;

/**
 * 434. 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 */
public class NumberOfSegmentsInAString_434 {

    public int countSegments(String s) {
        s = s.trim();
        return s.equals("") ? 0 : s.split("\\s+").length;
    }
}