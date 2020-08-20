package cn.edu.scu.algorithms.exercises.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class FindAllAnagramInAString_438 {

    // 拥有左右指针的滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> window = new HashMap<>();// 滑动窗口
        Map<Character, Integer> needs = new HashMap<>();// 固定需要
        int n = s.length(), m = p.length();
        for (int i = 0; i < m; i++) {
            char c = p.charAt(i);
            needs.put(c,needs.getOrDefault(c,0)+1);
        }
        int match = 0,left = 0,right = 0;// 左右指针
        List<Integer> result = new ArrayList<>();
        while (right < n) {
            // 增大窗口
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                window.put(c1,window.getOrDefault(c1,0)+1);
                if(window.get(c1).equals(needs.get(c1))) match++;// 计数相同的字母匹配数
            }
            right++;
            while (match == needs.size()) {// 当匹配数与需求窗口大小相同
                if (right - left == m) result.add(left);// 当长度也相同时，加入结果集。
                char c2 = s.charAt(left);
                // 缩小窗口
                if (needs.containsKey(c2)) {
                    window.put(c2, window.getOrDefault(c2, 0) - 1);
                    if (window.get(c2) < needs.get(c2)) match--;
                }
                left++;
            }
        }
        return result;
    }
}
