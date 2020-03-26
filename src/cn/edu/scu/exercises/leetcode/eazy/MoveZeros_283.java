package cn.edu.scu.exercises.leetcode.eazy;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 通过次数122,961提交次数204,679
 */
public class MoveZeros_283 {

    public void moveZeroes(int[] nums) {
        // 在线算法
        int n = nums.length;
        int count = 0;
        for(int i =0;i<n;i++){
            if(nums[i] == 0) count++;
            else nums[i-count] = nums[i];
        }
        int j = n-1;
        while(count>0){
            nums[j--] = 0;
            count--;
        }
    }
}
