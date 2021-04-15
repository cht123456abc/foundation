package cn.edu.scu.algorithms.bit_operation;


/**
 * 面试题 05.07. 配对交换
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 *
 * 示例1:
 *
 *  输入：num = 2（或者0b10）
 *  输出 1 (或者 0b01)
 * 示例2:
 *
 *  输入：num = 3
 *  输出：3
 * 提示:
 *
 * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 */
public class Exchange_0507 {


    public int exchangeBits(int num) {

        return ((num & 0x55555555) << 1) | ((num & 0xaaaaaaaa) >> 1);
    }

    public int exchangeBits1(int num) {


        int bits = 0;
        int res = 0;
        int k = 1;
        while(bits < 32){
            int one = 1 & num;
            num >>= 1;
            int another = 1 & num;
            num >>= 1;

            res = (~k&res)+(another<<bits);
            k <<= 1;
            bits++;
            res = (~k&res)+(one<<bits);
            k <<= 1;
            bits++;
        }
        return res;
    }

    public static void main(String[] args) {
        new Exchange_0507().exchangeBits(3);
    }



}
