package cn.edu.scu.exercises.leetcode.eazy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 */
public class FirstUniqueCharInAString_387 {

    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) return i;
        }
        return -1;
    }
}
