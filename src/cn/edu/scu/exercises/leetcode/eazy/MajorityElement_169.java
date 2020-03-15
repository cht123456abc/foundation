package cn.edu.scu.exercises.leetcode.eazy;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement_169 {

    public int majorityElement(int[] nums) {
        // 用哈希表
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res = map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
        return res;
    }

    // O(T) = O(n)在线算法
    public int majorityElement1(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) count++;
            else if (count == 0) res = nums[i];
            else count--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 3, 3, 2, 2,2,2, 1};
        int res = new MajorityElement_169().majorityElement(a);
        System.out.println(res);
    }
}
