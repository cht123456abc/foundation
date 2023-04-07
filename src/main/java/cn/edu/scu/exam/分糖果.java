package cn.edu.scu.exam;

public class 分糖果 {

// 方法一：两次遍历
    // 空间复杂度O(n) 时间复杂度O(n)
    // 将规则拆分为：ratings[i] > ratings[i-1] 以及 ratings[i] > ratings[i+1]
    // 从左向右以及从右向左 分两次遍历 取两个遍历的最大值作为每一个位置的结果

    public int candy(int[] ratings) {

        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 1;
        int res = 0;
        for (int i = n-1; i>=0; i--) {
            if (i < n-1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            right = Math.max(right, left[i]);
            res += right;
        }
        return res;
    }

    // 方法二：
    // 空间复杂度:O(1) 时间复杂度O(n)
    // 任意两个相邻的元素可以分为递增序列和递减序列
    // 如果是非严格递增序列中，当前分配糖果数为上一个+1；当相等时，直接分配为1；
    // 如果是递减序列中，先直接给当前分配1个糖果，然后所处的递减序列中，每一个位置都要依次+1；
    public int candy2(int[] ratings) {

        int n = ratings.length;
        int res = 1;
        int last = 1;
        int inc = 1,dec = 0;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i-1]) {
                dec = 0;
                // 非严格递增序列
                last = ratings[i] == ratings[i - 1] ? 1 : last + 1;
                res += last;
                inc = last;
            } else {
                // 递减序列
                dec++;
                if (dec == inc) {
                    dec++;
                }
                res += dec;
                last = 1;
            }

        }

        return res;
    }
}
