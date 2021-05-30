package cn.edu.scu.algorithms.exercises.leetcode;

public class SearchSumInRegion_307 {


    // 线段树 T = O(logn) 用数组来表示二叉树
    int[] tree;
    int n;

    // 构建线段树 自底向上构建
    private void buildTree(int[] nums){
        // 直接将原数组放在线段树数组的后半部分，作为树底
        for(int k=n,i=0;k<2*n;k++,i++){
            tree[k] = nums[i];
        }
        for(int k=n-1;k >0;k--){// tree[0]不用
            tree[k] = tree[2*k] + tree[2*k+1];
        }
    }

    public SearchSumInRegion_307(int[] nums) {
        n = nums.length;
        tree = new int[2*n];
        buildTree(nums);
    }

    // T = logn.  自底向上更新
    public void update(int index, int val) {
        index += n;
        tree[index] = val;
        while(index >0){
            int left = index;
            int right = index;
            // 保证left 为偶数
            if(index % 2 == 0) right = index+1;
            else left = index-1;

            tree[index>>1] = tree[left] + tree[right];
            index >>=1;
        }
    }

    // T = logn 自底向上求和
    public int sumRange(int l, int r) {
        int res = 0;
        l += n;
        r += n;
        while(l <= r){
            if(l % 2 == 1){
                res += tree[l];
                l++;
            }
            if(r % 2 == 0){
                res += tree[r];
                r--;
            }
            l>>=1;
            r>>=1;
        }
        return res;
    }

}
