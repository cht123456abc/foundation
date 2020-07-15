package cn.edu.scu.algorithms.exercises.SwordTowardOffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 *
 * 提示:
 *
 * 0 < nums.length <= 100
 * 说明:
 *
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */
public class SortToMin_45 {

//    // 自定义排序
//    public String minNumber(int[] nums) {
//        Integer[] a = Arrays.stream(nums).boxed().toArray(Integer[]::new);
//        Arrays.sort(a, (o1, o2) -> (int) (Long.parseLong("" + o1 + o2) - Long.parseLong("" + o2 + o1)));
//        StringBuilder res = new StringBuilder();
//        for(Integer i : a){
//            res.append(i);
//        }
//        return res.toString();
//    }

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));// 自定义排序
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}
