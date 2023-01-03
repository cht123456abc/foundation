package cn.edu.scu.algorithms.exercises.sword_toward_offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 *
 * 限制：
 *
 * 数组长度为 5
 *
 * 数组的数取值为 [0, 13] .
 */
public class IsConsecutive_61 {


    public boolean isStraight(int[] nums) {
        // 1. 不能有重复(除去大小王)
        // 2. max - min < 5(除去大小王)

        Set<Integer> rep = new HashSet<>();
        int max = -1;
        int min = 999;
        for(int i = 0;i<nums.length;i++){
            if(rep.contains(nums[i])) return false;

            if(nums[i] != 0){
                rep.add(nums[i]);
                max = Math.max(max,nums[i]);
                min = Math.min(min,nums[i]);
            }
        }
        return max - min < 5;


//        int max = Arrays.stream(nums).max().getAsInt();
//        int min = Arrays.stream(nums).filter(a -> a > 0).min().getAsInt();
//        boolean dup = Arrays.stream(nums).filter(a -> a > 0).boxed().collect(Collectors.toSet()).size() != Arrays.stream(nums).filter(a -> a > 0).count();
//
//
//        return !dup && max - min <= 4;



    }
}
