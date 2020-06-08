package cn.edu.scu.algorithms.union_find;

/**
 * 并查集数据结构。
 * 形成的不同的树。
 */
public class UnionFind {

    private int[] parent;

    UnionFind(int n){
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // 找到跟节点
    public int find(int x) {
        while(x != parent[x]){
            parent[x] = parent[parent[x]];// 隔代压缩
            x = parent[x];
        }
        return x;
    }

    // 合并
    public void merge(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        parent[rootX] = rootY;
    }

    // 两节点是否联通
     public boolean isConnected(int x,int y){
        return find(x) == find(y);
     }
}
