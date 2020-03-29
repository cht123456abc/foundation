package cn.edu.scu.exercises.leetcode.eazy;

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 */
public class ReverseVowelsOfAString_345 {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            while(i < j && !isVowel(chars[i])) i++;
            while(i < j && !isVowel(chars[j])) j--;
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }
        return String.valueOf(chars);
    }

    public boolean isVowel(char c){
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') return true;
        return false;
    }
}
