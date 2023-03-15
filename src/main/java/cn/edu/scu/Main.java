package cn.edu.scu;

import cn.edu.scu.algorithms.tree.TreeNode;

import java.util.*;

public class Main {

    // 归并排序思想
    public class Solution {

        int mod = (int) (1e9+7);

        public int InversePairs(int [] array) {
            // 归并排序思想
            int n = array.length;
            int[] temp = new int[n];
            return sort(array,0,n-1,temp);
        }

        // 合并两个正序数组并且计算逆序数
        private int mergeAndCount(int[] A,int lo,int mid,int hi,int[] temp){
            // 先把原数组copy到temp中
            for(int i=lo;i<=hi;i++){
                temp[i] = A[i];
            }

            int count = 0;
            // 合并并计数
            for(int k=lo,i=lo,j=mid+1;k<=hi;){
                if(i==mid+1){
                    A[k++] = temp[j++];
                }else if(j == hi+1){
                    A[k++] = temp[i++];
                }else if(temp[i] <= temp[j]){
                    A[k++] = temp[i++];
                }else{
                    A[k++] = temp[j++];
                    count += mid-i+1;// 逆序数
                }
            }
            return count % mod;

        }

        // 归并排序
        private int sort(int[] A,int lo,int hi,int[] temp){
            if(lo >= hi) return 0;
            int mid = (hi-lo)/2+lo;
            int left = sort(A,lo,mid,temp);
            int right = sort(A,mid+1,hi,temp);
            int res = (left+right) % mod;
            return A[mid]>A[mid+1] ? res + mergeAndCount(A,lo,mid,hi,temp) : res;
        }
    }


    // 离散化 + 树状数组  比较牛逼的思想
    class Solution2 {
        public int reversePairs(int[] nums) {
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



    public static void main(String[] args) {

    }
}