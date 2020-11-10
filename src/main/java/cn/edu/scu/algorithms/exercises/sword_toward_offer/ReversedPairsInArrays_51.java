package cn.edu.scu.algorithms.exercises.sword_toward_offer;


/**
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 */
public class ReversedPairsInArrays_51 {

    // 归并排序计算数组中逆序对
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if(len < 2) return 0;

        int[] temp = new int[len];
        return reversePairs(nums,0,len-1,temp);
    }

    // 将两个有序数组temp[left..mid] 和 temp[mid + 1..right]合并，并计算合并所得的逆序数
    public int mergeAndCount(int[] nums,int left,int mid,int right,int[] temp){
        for(int i = left;i <= right;i++){
            temp[i] = nums[i];
        }

        int k = left;
        int i = left;
        int j = mid + 1;
        int count = 0;
        while(k <= right){

            if(i == mid+1){
                nums[k++] = temp[j++];
            }else if(j == right+1){
                nums[k++] = temp[i++];
            }else if(temp[i] <= temp[j]){
                nums[k++] = temp[i++];
            }else{
                nums[k++] = temp[j++];
                count += (mid+1-i);
            }
        }

        return count;
    }

    // 分治求和逆序数
    public int reversePairs(int[] nums,int left,int right,int[] temp){
        if(left >= right) return 0;

        int mid = left + (right - left) / 2;
        int leftCount = reversePairs(nums,left,mid,temp);
        int rightCount = reversePairs(nums,mid + 1,right,temp);

        if(nums[mid] <= nums[mid + 1]) return leftCount + rightCount;
        return leftCount + rightCount + mergeAndCount(nums,left,mid,right,temp);
    }
}