package cn.edu.scu.algorithms.exercises.leetcode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

    // 左右指针滑动窗口
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();// 用map来统计字符个数
        int left = 0,right = 0;// 双指针
        int res = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            window.put(c1,window.getOrDefault(c1,0)+1);
            right++;
            while (window.get(c1) > 1) {
                char c2 = s.charAt(left);
                window.put(c2,window.get(c2)-1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;

    }



    // 右指针滑动窗口 T = O(n^2)
    public int lengthOfLongestSubstring1(String s) {
        List<Character> window = new ArrayList<>();
        int max = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            int last_index = window.indexOf(c);
            if (last_index >= 0) {// 如果存在当前元素
                window = window.subList(last_index+1, window.size());
                window.add(c);
            }else{// 如果不存在当前元素
                window.add(c);
                max = Math.max(max,window.size());
            }
            right++;
        }
        return max;
    }

}
