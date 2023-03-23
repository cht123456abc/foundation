package cn.edu.scu.algorithms.exercises.sword_toward_offer;


import cn.edu.scu.Main;

import java.util.Arrays;

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
    // 两个有序数组中的逆序对数计数在于：当把右半部分数组存在较小的数放回到原数组中时，左半部分数组中还剩余的个数等价于当次归并的逆序数。
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
                count += (mid+1-i);// 本次归并逆序数就等价于前半部分数组中还剩余的个数
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

        if(nums[mid] <= nums[mid + 1]) return leftCount + rightCount;// 两个有序数组组成的大数组本身正序，就不必再合并
        return leftCount + rightCount + mergeAndCount(nums,left,mid,right,temp);
    }

    // 离散化 + 树状数组  比较牛逼的思想
    public int reversePairs2(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        System.arraycopy(nums, 0, tmp, 0, n);
        // 离散化 用于解约空间，将稀疏的数组离散为紧凑的数组
        Arrays.sort(tmp);// 先排序
        for (int i = 0; i < n; ++i) {
            nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;// 二分查找该位置在temp中的位置，用位置次序（大小关系）来代替原数组
        }
        // 树状数组统计逆序对
        BIT bit = new BIT(n);
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {// 从后往前对离散化数组进行遍历
            ans += bit.query(nums[i] - 1);
            bit.update(nums[i]);
        }
            return ans;
        }
}

// 树状数组 用于计算离散化后数组个数统计的前缀和
class BIT {
    private int[] tree;
    private int n;

    public BIT(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    public int lowbit(int x) {
        return x & (-x);
    }

    public int query(int x) {
        int ret = 0;
        while (x != 0) {
            ret += tree[x];
            x -= lowbit(x);
        }
        return ret;
    }

    public void update(int x) {
        while (x <= n) {
            ++tree[x];
            x += lowbit(x);
        }
    }
}