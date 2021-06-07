package cn.edu.scu.algorithms.exercises.leetcode;

public class SearchSumInRegion_307 {

    public static void main(String[] args) {
        SearchSumInRegion_307 searchSumInRegion_307 = new SearchSumInRegion_307(new int[]{1, 3, 5});
        System.out.println(searchSumInRegion_307.sumRange(0, 2));
        searchSumInRegion_307.update(1, 2);
        System.out.println(searchSumInRegion_307.sumRange(0, 2));
    }


    // 树状数组
    int[] tree;
    int n;
    int[] nums;

    private void init(){
        for(int i = 0;i <n;i++){
            add(i,nums[i]);
        }
    }

    // 树状数组
    public SearchSumInRegion_307(int[] nums){
        this.n = nums.length;
        tree = new int[n+1];
        this.nums = nums;
        init();
    }

    public void update(int index,int val){
        int v = val - nums[index];
        nums[index] = val;
        add(index, v);
    }

    private void add(int x,int v){
        x++;
        while(x <= n){
            tree[x]+=v;
            x+=x&-x;
        }
    }

    private int query(int x){
        x++;
        int res = 0;
        while(x>0){
            res+=tree[x];
            x-=x&(-x);
        }
        return res;
    }

    public int sumRange(int left,int right){
        return query(right) - query(left-1);
    }


//    // 线段树 T = O(logn)
//    int[] tree;
//    int n;
//
//    // 构建线段树 自底向上构建
//    private void buildTree(int[] nums){
//        // 直接将原数组放在线段树数组的后半部分，作为树底
//        for(int k=n,i=0;k<2*n;k++,i++){
//            tree[k] = nums[i];
//        }
//        for(int k=n-1;k >0;k--){// tree[0]不用
//            tree[k] = tree[2*k] + tree[2*k+1];
//        }
//    }
//
//    public SearchSumInRegion_307(int[] nums) {
//        n = nums.length;
//        tree = new int[2*n];
//        buildTree(nums);
//    }
//
//    // T = logn.  自底向上更新
//    public void update(int index, int val) {
//        index += n;
//        tree[index] = val;
//        while(index >0){
//            int left = index;
//            int right = index;
//            // 保证left 为偶数
//            if(index % 2 == 0) right = index+1;
//            else left = index-1;
//
//            tree[index>>1] = tree[left] + tree[right];
//            index >>=1;
//        }
//    }
//
//    // T = logn 自底向上求和
//    public int sumRange(int l, int r) {
//        int res = 0;
//        l += n;
//        r += n;
//        while(l <= r){
//            if(l % 2 == 1){
//                res += tree[l];
//                l++;
//            }
//            if(r % 2 == 0){
//                res += tree[r];
//                r--;
//            }
//            l>>=1;
//            r>>=1;
//        }
//        return res;
//    }

}
