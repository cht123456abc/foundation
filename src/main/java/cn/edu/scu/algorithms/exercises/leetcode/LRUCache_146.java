package cn.edu.scu.algorithms.exercises.leetcode;

import cn.edu.scu.Solution;

import java.util.*;

/**
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class LRUCache_146 {

    // 方法二；自定义map 和 双端链表节点
    // 一个自定义Node类表示双向链表
    // 将使用过（包括get和put更新）的节点放入队尾
    // 容量满后，插入节点会使队头节点移除

    // 自定义Node类
    static class Node {
        private Node pre;
        private Node next;
        private Integer key;
        private Integer value;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> LRU;// 用hashmap代表LRU结构，value存放双向链表节点。
    private Node tail;// 加入刚使用过的节点，包括get和put操作
    private Node head;// 移除最久没有使用过的节点

    public LRUCache_146(int capacity) {
        this.capacity = capacity;
        LRU = new HashMap<>();
        head = new Node(-1,-1);// dummyhead
        tail = head;
    }

    public int get(int key) {
        if (!LRU.containsKey(key)) {
            return -1;
        }

        Node node = LRU.get(key);
        // 进行后续操作
        operationAfterUpdate(node);
        return node.value;
    }

    public void set(int key, int value) {
        // 先判断是否存在LRU中
        if (LRU.containsKey(key)) {
            Node node = LRU.get(key);
            node.value = value;// 更新值

            // 进行后续操作
            operationAfterUpdate(node);
            return;
        }

        // 如果不存在LRU中，先插入到链表尾
        Node node = new Node(key, value);
        LRU.put(key, node);
        tail.next = node;
        node.pre = tail;
        tail = node;

        // 判断是否删除头结点
        removeFirst();
    }

    private void removeFirst() {
        // 如果此时size大于容量，则移除最开始节点
        if (LRU.size() > capacity) {
            Node remove = head.next;
            // remove from LRU
            LRU.remove(remove.key);
            if (remove == tail) {
                head.next = null;
                tail = head;
            } else {
                Node next = remove.next;
                head.next = next;
                next.pre = head;
            }
        }
    }

    // 先判断是否在链表尾，如果是直接返回；如果不是则将其放置链表尾
    private void operationAfterUpdate(Node node) {
        if (node == tail) {
            return;
        }
        // 断开节点前后链接
        Node pre = node.pre;
        Node next = node.next;
        node.next = null;
        node.pre = null;
        pre.next = next;
        next.pre = pre;

        // 放置链表尾部
        tail.next = node;
        node.pre = tail;
        tail = node;
    }

//    // 方法三 用LinkedHashMap 实现自定义LRU缓存结构
//    class LRU<K,V> extends LinkedHashMap<K,V> {
//        private int cap;
//
//        public LRU(int cap) {
//            super(cap, 0.75f,true);
//            this.cap = cap;
//        }
//
//        @Override
//        protected boolean removeEldestEntry(Map.Entry eldest) {
//            // 自实现删除eldest的condition
//            return this.size() > cap;
//        }
//    }
//
//    private LRU<Integer,Integer> lru;
//
//    public LRUCache_146(int capacity) {
//        this.lru = new LRU<>(capacity);
//    }
//
//    public int get(int key) {
//        return lru.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        lru.put(key, value);
//    }

    // 方法一 用map和队列
//    private Deque<Integer> delete_q;
//    private Map<Integer,Integer> map;
//    private static int size;
//
//    public LRUCache_146(int capacity) {
//        delete_q = new LinkedList<>();
//        map = new HashMap<>();
//        size = capacity;
//    }
//
//    public int get(int key) {
//        if (!map.containsKey(key) || delete_q.isEmpty()) return -1;
//        // get的时候将数据重新放到队尾
//        delete_q.remove(key);
//        delete_q.addLast(key);
//        return map.get(key);
//    }
//
//    public void put(int key, int value) {
//        if(map.containsKey(key)){
//            delete_q.remove(key);
//        }else if (map.size() == size){
//            int first = delete_q.pollFirst();
//            map.remove(first);
//        }
//        map.put(key,value);
//        delete_q.addLast(key);
//
//    }

    public static void main(String[] args) {

        LRUCache_146 lruCache_146 = new LRUCache_146(2);

        lruCache_146.set(1, 1);
        lruCache_146.set(2, 2);
        System.out.println(lruCache_146.get(1));
        lruCache_146.set(3, 3);
        System.out.println(lruCache_146.get(2));
        lruCache_146.set(4, 4);
        System.out.println(lruCache_146.get(1));
        System.out.println(lruCache_146.get(3));
        System.out.println(lruCache_146.get(4));
    }
}
