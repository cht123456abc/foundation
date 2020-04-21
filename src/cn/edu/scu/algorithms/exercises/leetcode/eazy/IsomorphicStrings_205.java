package cn.edu.scu.algorithms.exercises.leetcode.eazy;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class IsomorphicStrings_205 {

    public boolean isIsomorphic(String s, String t) {
        // 用一个哈希表来存储已遍历过的字母对应关系
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c1 = s.charAt(i);
            Character c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) return false;
                else continue;
            }
            // 再判断一次ValueSet中是否有重复的值，有则返回false;
            if (map.containsValue(c2)) return false;
            // 都是独一无二的字母，才放入
            map.put(c1, c2);
        }
        return true;
    }
}
