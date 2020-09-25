package cn.edu.scu.algorithms.exercises.SwordTowardOffer;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 *
 * 提示：
 *
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 */
public class AddUsingBitwise_65 {

    // 模板
    public int add(int a, int b) {
        while(b != 0){
            int c = (a&b) << 1;// 保存进位
            a ^= b;// 保存无进位的和
            b = c;// 将进位赋值给b,继续迭代，直到没有进位
        }
        return a;
    }
}
