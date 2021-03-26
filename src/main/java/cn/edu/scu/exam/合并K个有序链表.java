package cn.edu.scu.exam;

import cn.edu.scu.algorithms.exercises.leetcode.ListNode;

import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class 合并K个有序链表 {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // 分治
        if(lists.size() == 0) return null;
        return dividedAndConquer(lists,0,lists.size()-1);

    }
    public ListNode dividedAndConquer(ArrayList<ListNode> lists,int lo,int hi){
        if(lo == hi) return lists.get(lo);
        int mid = lo + (hi - lo) / 2;
        ListNode left = dividedAndConquer(lists,lo,mid);
        ListNode right = dividedAndConquer(lists,mid+1,hi);
        ListNode res = merge(left,right);
        return res;
    }

    public ListNode merge(ListNode l1,ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }
        else{
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }


    public ListNode mergeKLists1(ArrayList<ListNode> lists) {

        // k指针
        int n = lists.size();
        ListNode[] p = new ListNode[n];
        ListNode res = new ListNode(-1);
        ListNode r = res;

        boolean flag = true;
        while(flag){
            flag = false;
            int min = Integer.MAX_VALUE;
            int min_p = 0;
            for(int i = 0;i < n;i++){
                p[i] = lists.get(i);
                if(p[i] == null) continue;
                flag = true;
                if(p[i].val < min){
                    min = p[i].val;
                    min_p = i;
                }
            }
            if(flag){
                r.next = p[min_p];
                r = r.next;
                lists.set(min_p,lists.get(min_p).next);
            }

        }
        return res.next;

    }
}