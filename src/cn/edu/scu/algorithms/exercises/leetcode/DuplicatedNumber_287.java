package cn.edu.scu.algorithms.exercises.leetcode;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class DuplicatedNumber_287 {

     // 快慢指针
     public int findDuplicate1(int[] nums) {
         int slow = 0, fast = 0;
         do {
             slow = nums[slow];
             fast = nums[nums[fast]];
         } while (slow != fast);
         slow = 0;
         while (slow != fast) {
             slow = nums[slow];
             fast = nums[fast];
         }
         return slow;
     }

    // 快慢指针2
     public int findDuplicate2(int[] nums) {
         int n = nums.length;
         int slow = 0,fast = 1;
         while(nums[slow] != nums[fast]){
             slow = (slow + 1) % n;
             fast = (fast + 2) % n;
             if(slow == fast) fast = (slow + 1) % n;
         }
         return nums[slow];
     }

    // 根据抽屉原理的二分法：二分法的思路是先猜一个数（有效范围 [left, right]里的中间数 mid），
    public int findDuplicate(int[] nums) {
        int left = 1,right = nums.length-1;
        while(left < right){
            int mid = (left + right) >> 1;
            // 统计原始数组中小于等于这个中间数的元素的个数 cnt
            int cnt = 0;
            for(int num : nums){
                if(num <= mid) cnt++;
            }

            // 判断cnt与mid的大小关系
            if(cnt > mid){
                right = mid;//如果 cnt 严格大于 mid，（注意我加了着重号的部分「小于等于」、「严格大于」）。根据抽屉原理，重复元素就在区间 [left, mid] 里；
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
