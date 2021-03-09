package cn.edu.scu.algorithms.exercises.leetcode;

import org.w3c.dom.Node;

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

    // 方法三 用LinkedHashMap 实现自定义LRU缓存结构
    class LRU<K,V> extends LinkedHashMap<K,V> {
        int cap;

        public LRU(int cap) {
            super(cap, (float) 0.75,true);
            this.cap = cap;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            // 自实现删除eldest的condition
            if(this.size() > cap) return true;
            else return false;
        }
    }

    private LRU<Integer,Integer> lru;

    public LRUCache_146(int capacity) {
        this.lru = new LRU<>(capacity);
    }

    public int get(int key) {
        if (!lru.containsKey(key)) return -1;
        return lru.get(key);
    }

    public void put(int key, int value) {
        lru.put(key, value);
    }


    // 方法二：自定义链表节点
//    class Node{
//        private Node pre;
//        private Node next;
//        private int key;// map中对应的key，用于删除
//        private int val;
//        public Node(int value) {
//            val = value;
//        }
//
//        public Node(int key, int value) {
//            this.key = key;
//            val = value;
//        }
//    }
//
//
//    Map<Integer,Node> map = new HashMap<>();
//    Node head = new Node(-1);
//    Node tail = head;
//    private int cap;
//
//    public LRUCache_146(int capacity) {
//        cap = capacity;
//    }
//
//    public int get(int key) {
//        if (map.containsKey(key)) {
//            // 删除节点，放入链表尾部
//            Node node = map.get(key);
//            Node pre = node.pre;
//            Node next = node.next;
//            if(next == null){
//                // 已经在尾部
//                return node.val;
//            }
//            node.next = null;
//            node.pre = null;
//            pre.next = next;
//            next.pre = pre;
//            tail.next = node;
//            node.pre = tail;
//            tail = node;
//            return node.val;
//        } else {
//            return -1;
//        }
//    }
//
//
//    public void put(int key, int value) {
//        // 先看是否存在值
//        if (!map.containsKey(key)) {
//            // 判断是否满
//            int size = map.size();
//            if (size == cap) {
//                // 移除第一个元素
//                Node first = head.next;
//                head.next = first.next;
//                if(first.next != null) first.next.pre = head;
//                first.next = null;
//                first.pre = null;
//                // 将map中对应的first的key删除
//                map.remove(first.key);
//            }
//            // 加入队尾
//            Node node = new Node(key,value);
//            map.put(key,node);
//            tail.next = node;
//            node.pre = tail;
//            tail = node;
//            map.put(key, node);
//        } else {
//            // 将节点放入队尾,并更新值
//            Node node = map.get(key);
//            Node pre = node.pre;
//            Node next = node.next;
//            node.val = value;
//            if(next == null){
//                // 已经在尾部
//                return;
//            }
//            node.next = null;
//            node.pre = null;
//            pre.next = next;
//            next.pre = pre;
//            tail.next = node;
//            node.pre = tail;
//            tail = node;
//        }
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

        lruCache_146.put(1, 1);
        lruCache_146.put(2, 2);
        System.out.println(lruCache_146.get(1));
        lruCache_146.put(3, 3);
        System.out.println(lruCache_146.get(2));
        lruCache_146.put(4, 4);
        System.out.println(lruCache_146.get(1));
        System.out.println(lruCache_146.get(3));
        System.out.println(lruCache_146.get(4));
    }
}
