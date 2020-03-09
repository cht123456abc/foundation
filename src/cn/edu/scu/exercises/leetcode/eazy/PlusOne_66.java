package cn.edu.scu.exercises.leetcode.eazy;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne_66 {

    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry == 1 || i == digits.length-1) {// 如果有进位或者是位于个位
                carry = (digits[i] + 1) / 10;
                digits[i] = (digits[i] + 1) % 10;
            }else break;
        }
        if (carry == 1) {// 如果最大一位仍然有进位，则加一位数
            int[] res = new int[digits.length + 1];
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
