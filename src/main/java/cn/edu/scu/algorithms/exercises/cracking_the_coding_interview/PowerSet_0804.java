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


    // 位图
    public List<List<Integer>> subsets(int[] nums) {
        int n = 1 << nums.length;
        List<List<Integer>> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            res.add(list);

        }
        return res;
    }


    // dfs + 回溯
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    // 非递归
    public List<List<Integer>> subsets2(int[] nums) {
        // 每次遍历一个元素，向已有的集合中添加该元素，形成的新的集合加入已有集合
        List<List<Integer>> res = new ArrayList<>(1<<nums.length);
        res.add(new ArrayList<>());
        for (int num : nums) {

            /**
             * 注意这里的写法，
             * 1，用for代替for-each，这种写法可以避免for-each的ConcurrentModificationException
             * 2. res.size()需要事先存储在j里面，避免每次调用导致oom
             */
            for (int i = 0,j = res.size();i < j;i++) {//
                List<Integer> temp = new ArrayList<>(res.get(i));
                temp.add(num);
                res.add(temp);
            }
        }
        return res;
    }


}
