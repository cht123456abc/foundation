package cn.edu.scu.algorithms.bit_operation;

import java.math.BigInteger;

/**
 * 67. 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class AddBinary_67 {

    // api
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    // 位操作，当位数很大的时候
    public String addBinary1(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }

    // 位操作，当位数较小的时候
    public String addBinary2(String a, String b) {
        int x = Integer.parseInt(a, 2);
        int y = Integer.parseInt(b, 2);
        int carry, answer;
        while (y != 0) {
            answer = x ^ y;// 相异或
            carry = (x & y) << 1;// 相与再左移1位
            x = answer;
            y = carry;
        }
        return Integer.toBinaryString(x);
    }


    public static void main(String[] args) {
        System.out.println(new AddBinary_67().addBinary1("11","10"));
        System.out.println(new AddBinary_67().addBinary2("11","10"));
    }
}
