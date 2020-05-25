package cn.edu.scu.algorithms.exercises.leetcode.middle;

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

    private Deque<Integer> delete_q;
    private Map<Integer,Integer> map;
    private static int size;


    public LRUCache_146(int capacity) {
        delete_q = new LinkedList<>();
        map = new HashMap<>();
        size = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key) || delete_q.isEmpty()) return -1;
        // get的时候将数据重新放到队尾
        delete_q.remove(key);
        delete_q.addLast(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            delete_q.remove(key);
        }else if (map.size() == size){
            int first = delete_q.pollFirst();
            map.remove(first);
        }
        map.put(key,value);
        delete_q.addLast(key);

    }
}
