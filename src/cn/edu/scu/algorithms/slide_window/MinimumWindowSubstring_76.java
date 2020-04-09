package cn.edu.scu.algorithms.slide_window;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class MinimumWindowSubstring_76 {

    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();// 统计字符的个数
        Map<Character, Integer> needs = new HashMap<>();// 统计需要字符的个数
        int n = s.length(), m = t.length();
        for (int i = 0; i < m; i++) {
            char c = t.charAt(i);
            needs.put(c,needs.getOrDefault(c,0)+1);
        }
        int match = 0,left = 0,right = 0;
        int min = 0,start = 0;
        while (right < n) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                window.put(c1,window.getOrDefault(c1,0)+1);
                if (window.get(c1).equals(needs.get(c1))) {
                    match++;
                }
            }
            right++;
            while (match == needs.size()) {
                int len = right - left;
                if (left == 0 || len < min) {
                    min = len;
                    start = left;
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (window.get(c2) < needs.get(c2)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return s.substring(start,start+min);
    }

}
