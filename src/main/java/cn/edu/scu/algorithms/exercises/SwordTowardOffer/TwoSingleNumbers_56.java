package cn.edu.scu.algorithms.exercises.SwordTowardOffer;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 *
 * 限制：
 *
 * 2 <= nums.length <= 10000
 */
public class TwoSingleNumbers_56 {

    // 分组异或
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum ^= i;
        }

        // 查看sum中哪一位为1，如果该位为1，则表明不同的两数在该位上不同
        int bit = 1;
        for(;;){
            if((sum & bit) != 0) break;
            bit <<= 1;
        }

        // 将该位0或1分来两组各自异或得出两个值
        int a = 0,b = 0;
        for(int i : nums){
            if((i & bit) != 0) a ^= i;
            else b ^= i;
        }
        return new int[]{a,b};

    }
}
