package cn.edu.scu.algorithms.exercises.sword_toward_offer;


/**
 * 剑指 Offer 20. 表示数值的字符串
 * 中等
 * 429
 * 相关企业
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 数值（按顺序）可以分成以下几个部分：
 * <p>
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分数值列举如下：
 * <p>
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 * <p>
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "0"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "e"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s = "."
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "    .1  "
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
 */
public class DigitString_20 {

    // 有限状态机 + 表驱动
    // eg:string = " -3.2e-9 "
    // 根据当前字符可能存在的状态，可以总结总共9种状态，分别为0-8
    public boolean isNumber(String s) {
        int state = 0;
        int finals = 0b101101000;// 状态为3 5 6 8 时，才能正确结尾
        int[][] transfer = new int[][]{
                {0, 1, 6, 2, -1}, // 0:开头的blank
                {-1, -1, 6, 2, -1},// 1:e之前的sign
                {-1, -1, 3, -1, -1},// 2:dot
                {8, -1, 3, -1, 4},// 3:dot之后的digit
                {-1, 7, 5, -1, -1},// 4:e
                {8, -1, 5, -1, -1},// 5:e之后的digit
                {8, -1, 6, 3, 4},// 6:dot之前的digit
                {-1, -1, 5, -1, -1},// 7:e之后就的sign
                {8, -1, -1, -1, -1}// 8:末尾的blank
        };
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; ++i) {
            int id = make(ss[i]);
            if (id < 0) return false;
            state = transfer[state][id];
            if (state < 0) return false;
        }
        return (finals & (1 << state)) > 0;
    }

    public int make(char c) {
        switch (c) {
            case ' ':
                return 0;
            case '+':
            case '-':
                return 1;
            case '.':
                return 3;
            case 'e':
                return 4;
            default:
                if (c >= 48 && c <= 57) return 2;
        }
        return -1;
    }
}
