package cn.edu.scu.algorithms.exercises.cracking_the_coding_interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.04. 幂集
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 *  输入： nums = [1,2,3]
 *  输出：
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class PowerSet_0804 {


    // 非递归
    public List<List<Integer>> subsets(int[] nums) {

        // 每次遍历一个元素就在原来的所有集合上面加上该元素

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            for (List<Integer> re : res) {

            }
            res.add(new ArrayList<>());// 每次加一个空数组
        }
        return res;
    }


}
