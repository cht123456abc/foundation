package cn.edu.scu.exercises.leetcode.eazy;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class WordPattern_290 {

    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        int n = pattern.length();
        int m = strs.length;
        if(n != m) return false;
        // 两个表都表示对应字符或者字符串第一次出现的位置
        Map<Character,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        for(int i = 0;i < n;i++){
            char c = pattern.charAt(i);
            String s = strs[i];
            if(!map1.containsKey(c)) map1.put(c,i);
            if(!map2.containsKey(s)) map2.put(s,i);
            if(!map1.get(c).equals(map2.get(s))) return false;
        }
        return true;
    }


}
