package cn.edu.scu.exercises.leetcode.middle;

/**
 * 400. 第N个数字
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 *
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 *
 * 示例 1:
 *
 * 输入:
 * 3
 *
 * 输出:
 * 3
 * 示例 2:
 *
 * 输入:
 * 11
 *
 * 输出:
 * 0
 *
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 */
public class NthDigit_400 {

    public int findNthDigit(int n) {
        int i = 1;
        long count = 9;
        // 算出n属于几位数
        while(n > count){
            n -= count;
            i++;
            count = i*9*(long)Math.pow(10,i-1);
        }
        // n在第i位数中的位置
        int num = (n-1) / i;
        int pos = (n-1) % i;
        int number = (int)Math.pow(10,i-1) + num;
        String res = String.valueOf(String.valueOf(number).charAt(pos));
        return Integer.parseInt(res);

    }

    public static void main(String[] args) {
        System.out.println(new NthDigit_400().findNthDigit(3));
    }
}
