package cn.edu.scu.algorithms.exercises.leetcode.eazy;

import java.util.stream.Stream;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix_14 {

// 或:
//    public String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) return "";
//        String prefix = strs[0];
//        for (int i = 1; i < strs.length; i++)
//            while (strs[i].indexOf(prefix) != 0) {
//                prefix = prefix.substring(0, prefix.length() - 1);
//                if (prefix.isEmpty()) return "";
//            }
//        return prefix;
//    }

    public String longestCommonPrefix(String[] strs) {
        return Stream.of(strs).reduce((a,b) -> commonPrefix(a,b)).orElseGet(String::new);

    }

    // 找两个字符串中的最长公共前缀
    public String commonPrefix(String a, String b) {
        while (b.indexOf(a) != 0) {// b串中是否在开头位置存在子串a
            a = a.substring(0, a.length() - 1);
            if (a.isEmpty()) return "";
        }
        return a;
    }

    // 或:
//    public String commonPrefix(String a, String b) {
//        String res = "";
//        int k = 0;
//        while (k < a.length() && k < b.length()) {
//            if (a.charAt(k) == b.charAt(k)) {
//                res += a.charAt(k++);
//            }else break;
//        }
//        return res;
//    }

    public static void main(String[] args) {
        String[] strs = new String[]{
                "flower", "flow", "flight"};
        String res = new LongestCommonPrefix_14().longestCommonPrefix(strs);
        System.out.println(res);

    }
}
