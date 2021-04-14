package cn.edu.scu.algorithms.exercises.cracking_the_coding_interview;

/**
 * 面试题 05.03. 翻转数位
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 *
 * 示例 1：
 *
 * 输入: num = 1775(11011101111)
 * 输出: 8
 * 示例 2：
 *
 * 输入: num = 7(0111)
 * 输出: 4
 */
public class ReverseBit_0503 {

    public int reverseBits(int num) {

        int maxLen = 0,preLen = 0,curlen = 0,bits = 32;
        while(bits-- > 0){
            if((num & 1) == 0){
                curlen -= preLen;
                preLen = curlen + 1;
            }

            curlen++;
            maxLen = Math.max(maxLen,curlen);
            num >>= 1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int k = 32;
        int i = 0;
        while (k-- > 0) {
            System.out.println(k);
        }
    }


}
