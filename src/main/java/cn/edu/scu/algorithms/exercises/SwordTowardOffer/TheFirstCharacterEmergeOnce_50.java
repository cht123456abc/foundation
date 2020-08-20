package cn.edu.scu.algorithms.exercises.SwordTowardOffer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 */
public class TheFirstCharacterEmergeOnce_50 {

    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char c : chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) return entry.getKey();
        }
        return ' ';
    }

}
