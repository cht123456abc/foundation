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

    // 方法二；自定义map 和 双端链表节点
    // 用一个removeAfterAccess包含 get和put的操作
    // put节点放入链表队列尾
    // size超过容量的时候，删除队列头部

    static class Node {
        int key;
        int value;
        Node pre;
        Node next;
    }

    Map<Integer,Node> LRU;
    Node head;
    Node tail;
    int capacity;


    public LRUCache_146(int capacity) {
        LRU = new HashMap<>(capacity);
        this.capacity = capacity;

    }

    // 访问了的元素放到队列尾
    private void removeAfterAccess(Node e){
        if(tail == e) return;
        // 两个节点以上并且e不为tail
        Node next = e.next;
        if(head == e){
            e.next = null;
            next.pre = null;
            head = next;
        }else{
            Node pre = e.pre;
            e.pre = null;
            e.next = null;
            pre.next = next;
            next.pre = pre;
        }
        tail.next = e;
        e.pre = tail;
        tail = e;
    }

    public int get(int key) {
        Node e = LRU.get(key);
        if(e == null){
            return -1;
        }
        removeAfterAccess(e);
        return e.value;
    }


    public void put(int key, int value) {
        int oldV = get(key);
        Node e;
        if(oldV == -1){
            // size到达容量需要删除队列头
            if(LRU.size() == capacity){
                Node next = head.next;
                if(next != null){
                    head.next = null;
                    next.pre = null;
                }
                LRU.remove(head.key);// 关键，删除了链表，还要删除map中的节点
                head = next;
            }
            e = new Node();
            e.key = key;
            e.value = value;
            LRU.put(key,e);
            if(LRU.size() == 1){
                head = tail = e;
                return;
            }
            tail.next = e;
            e.pre = tail;
            tail = e;
        }else{
            e = tail;
            e.value = value;
        }

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
