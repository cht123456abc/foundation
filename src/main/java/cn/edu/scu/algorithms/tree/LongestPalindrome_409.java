package cn.edu.scu.algorithms.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindrome_409 {

    // 贪心？
    public int longestPalindrome(String s) {
        // 找到个数为偶数的字符，将这些个数相加，再最多可加上一个
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int res = 0;
        boolean hasSingle = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value % 2 == 0) res += value;
            else {
                res += value-1;
                hasSingle = true;
            }
        }
        return hasSingle == true ? res+1 : res;
    }
}
