package cn.edu.scu.algorithms.exercises.SwordTowardOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 */
public class ContinuousSeqSum_57_II {

    //     // 前缀和
    // public int[][] findContinuousSequence(int target) {
    //     int sum = 0;
    //     Map<Integer,Integer> prefix = new HashMap<>();
    //     List<int[]> res = new ArrayList<>();
    //     for(int i = 0;i <= target[];i++){
    //         sum += i;
    //         int pre = sum - target;
    //         if(prefix.containsKey(pre)){
    //             int j = prefix.get(pre),f = j;
    //             int[] seq = new int[i-j];
    //             for(;j < i;j++) seq[j-f] = j+1;
    //             res.add(seq);
    //         }
    //         prefix.put(sum,i);

    //     }
    //     return res.toArray(new int[0][]);
    // }

    //     // 滑动窗口
    // public int[][] findContinuousSequence(int target) {
    //     List<int[]> res = new ArrayList<>();
    //     int i = 1,j = 1;
    //     int window_sum = 0;
    //     List<Integer> window = new LinkedList<>();
    //     while(j < target){
    //         window_sum += j;
    //         window.add(j);
    //         j++;
    //         while(window_sum >= target){
    //             if(window_sum == target) {
    //                 res.add(window.stream().mapToInt(Integer::intValue).toArray());
    //             }
    //             window_sum -= i;
    //             window.remove(0);
    //             i++;
    //         }
    //     }
    //     return res.toArray(new int[0][]);
    // }

    // 大哥算法：15(target) = 7 + (7+1) = 4 + (4+1) + (4+2) =  x + (x+1) + ... + (x+i-1) = i*x + 1+...+i-1;
    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        int i = 1;
        while(target>0)
        {
            target -= i++;
            if(target>0 && target%i == 0)// 基数x = target / i 一定为整数
            {
                int[] array = new int[i];
                for(int k = target/i, j = 0; k < target/i+i; k++,j++)
                {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }
}


