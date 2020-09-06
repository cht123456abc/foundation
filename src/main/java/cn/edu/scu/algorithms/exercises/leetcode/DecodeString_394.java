package cn.edu.scu.algorithms.exercises.leetcode;

import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class DecodeString_394 {

    String str;
    int ptr;// 指针

    // 递归解，要一个全局指针，从左到右顺序递归
    public String decodeString(String s) {
        ptr = 0;
        str = s;
        return decode();
    }

    public String decode(){
        // 从左到右
        // [String]5[decode()] + decode();
        if(ptr == str.length() || str.charAt(ptr) == ']') return "";
        char c = str.charAt(ptr);
        String res = "";
        if(Character.isLetter(c)){
            ptr++;
            res += c;
        }else if(Character.isDigit(c)){
            // 计算总的数字
            int count = 0;
            while(Character.isDigit(c)){
                count = 10 * count + (c - '0');
                ptr++;
                c = str.charAt(ptr);
            }

            // 此时ptr指向 '['
            ptr++;// 过滤
            String inner = decode();
            // 此时ptr指向']'
            ptr++;// 过滤
            for(int i =0;i<count;i++){
                res += inner;
            }
        }
        return res + decode();


    }
}
