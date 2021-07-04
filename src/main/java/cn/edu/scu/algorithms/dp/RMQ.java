package cn.edu.scu.algorithms.dp;

import java.util.Arrays;
import java.util.Random;

/**
 * 区间最值问题
 */
public class RMQ {

    static int M;

    public static void main(String[] args) {
        Random random = new Random();
        final int COUNT = (int)1e7;
        int[] a = new int[1000];
        for (int i = 0; i < 1000; i++) {
            a[i] = random.nextInt(1000);
        }

        // 暴力
        long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            int l = random.nextInt(500);
            int r = 500 + random.nextInt(500);
            int min = Integer.MAX_VALUE;
            for (int j = l; j <= r; j++) {
                if (a[j] < min) min = a[j];
            }
            M = min;
        }
        long end = System.currentTimeMillis();
        System.out.println("暴力法耗时：" + (end - start) + "ms");



        // 线段树
        SegmentTree segmentTree = new SegmentTree(a);
        segmentTree.init(1,0,a.length-1);
        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            int l = random.nextInt(500);
            int r = 500 + random.nextInt(500);
            M = segmentTree.query(1,0,a.length-1,l,r);
        }
        end = System.currentTimeMillis();
        System.out.println("线段树耗时：" + (end - start) + "ms");


        // st表
        ST st = new ST(a);
        st.init();
        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            int l = random.nextInt(500);
            int r = 500 + random.nextInt(500);
            M = st.query(l, r);
        }
        end = System.currentTimeMillis();
        System.out.println("st表耗时：" + (end - start) + "ms");

    }
}

/**
 * 线段树
 */
class SegmentTree {
    int[] source;// 源数据
    int[] tree;// 线段树

    public SegmentTree(int[] a) {
        this.source = a;
        this.tree = new int[10000];
    }

    // 构建线段树 T=O(n)
    void init(int node, int l, int r) {
        if (l == r) {
            tree[node] = source[l]; //只有一个元素
            return;
        }
        init(2 * node, l, (l + r) / 2);
        init(2 * node + 1, (l + r) / 2 + 1, r);
        tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
    }

    // 查询区间[i, j]上的最小值 T=O(logn)
    int query(int node, int l, int r, int i, int j) {
        // 查询区间和节点区间没有交集
        if (i > r || j < l) return -1;
        // 查询区间包含节点区间直接返回
        if (i <= l && r <= j) return tree[node];
        // 查询区间与节点区间存在交集
        int p1 = query(2 * node, l, (l + r) / 2, i, j);
        int p2 = query(2 * node + 1, (l + r) / 2 + 1, r, i, j);
        if (p1 == -1) return p2;
        if (p2 == -1) return p1;
        return Math.min(p1, p2);
    }
}

/**
 * BIT树状数组
 */
class BIT {
    int[] source;// 源数据
    int[] tree;// 树状数组

    public BIT(int[] source) {
        this.source = source;
        int n = source.length;
        this.tree = new int[n + 1];
    }

    public void init() {
        int i, j;
        for (i = 1; i <= source.length; i++) {
            tree[i] = source[i - 1];
            for (j = 1; j < lowbit(i); j <<= 1)
                tree[i] = Math.min(tree[i], tree[i - j]);
        }
    }

    private int lowbit(int i) {
        return i & -i;
    }

//    public void update(int i,int v) {
//        i=i+1;
//        // 修改当前节点最值
//        while()
//
//        // 修改祖先节点最值
//        while (i < source.length) {
//            tree[i] = Math.max(tree[i], v);
//            i += lowbit(i);
//        }
//    }

    // 查询区间最值
    public int query(int l, int r)//区间查询最大值
    {
        if (r > l) {
            if (r - lowbit(r) > l) return Math.max(tree[r], query(l, r - lowbit(r)));
            else return Math.max(source[r], query(l, r - 1));
        }
        return source[l];
    }
}


/**
 * ST表
 */
class ST {
    int[] source;// 源数据
    int[][] dp;// st表     ,dp[i][j] 代表从a[i]开始，到a[i+2^j-1]即区间[source[i],source[i+2^j-1]]的最值

    public ST(int[] source) {
        this.source = source;
        int n = source.length;
        this.dp = new int[n][31];
    }

    // 初始化 T=O(nlogn)
    public void init() {
        int n = source.length;
        for (int i = 0; i < n; i++) {
            dp[i][0] = source[i];
        }
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    // 查询区间最值 T=O(1)
    public int query(int l, int r) {
        int k = (int) (Math.log(r - l + 1) / Math.log(2));
        return Math.min(dp[l][k], dp[r - (1 << k) + 1][k]);
    }
}
