package cn.edu.scu.algorithms.exercises.leetcode.eazy;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class ValidPalindrome_125 {

    public boolean isPalindrome(String s) {
        // 双指针，仅当字符为数字或者字母的时候才进行比较
        int i = 0,j = s.length() - 1;
        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!isDigitOrLetter(ci)) {
                i++;
                continue;
            }
            if (!isDigitOrLetter(cj)) {
                j--;
                continue;
            }
            // 如果匹配
            if (ci == cj || (Math.abs(ci-cj) == 32 && isLetter(ci) && isLetter(cj))){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isDigitOrLetter(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57);
    }

    public boolean isLetter(char c) {
        return (c >= 65 && c <= 90) || (c >=97 && c <=122);
    }
}
