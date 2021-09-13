package cn.edu.scu.exam;

public class 旋转数组中查找 {

    public int search (int[] nums, int target) {

        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }

            if (nums[mid] >= nums[left]) {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
