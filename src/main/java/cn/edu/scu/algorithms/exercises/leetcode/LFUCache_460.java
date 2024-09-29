package cn.edu.scu.algorithms.exercises.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LFUCache_460 {

    static class Node implements Comparable<Node> {
        int key;
        int value;
        int use;// 使用次数
        int time;// 使用时间

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        // TreeSet中的对象的大小比较只看compareTo方法
        @Override
        public int compareTo(Node o) {
            return use == o.use ? time - o.time : use - o.use;
        }

    }


    private int time;
    private Map<Integer, Node> LFU;
    private TreeSet<Node> AVL;
    private int capacity;

    public LFUCache_460(int capacity) {
        // 初始化
        LFU = new HashMap<>();
        AVL = new TreeSet<>();
        this.capacity = capacity;
    }

    public int get(int key) {

        if (!LFU.containsKey(key)) {
            return -1;
        }
        Node node = LFU.get(key);
        // 先删除
        boolean flag = AVL.remove(node);// 删除key=1时，失败
        // 再改变值后添加
        node.use++;
        node.time = ++time;
        AVL.add(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (LFU.containsKey(key)) {
            // 更新值
            Node node = LFU.get(key);
            AVL.remove(node);
            node.value = value;
            node.use++;
            node.time = ++time;
            AVL.add(node);
            return;
        }

        // 先判断是否满容量，满了就进行删除操作
        if (LFU.size() == capacity) {
            Node first = AVL.pollFirst();
            LFU.remove(first.key);
        }
        Node node = new Node(key, value);
        node.use++;
        node.time = ++time;
        LFU.put(key, node);
        AVL.add(node);
    }




}
