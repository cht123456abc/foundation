package cn.edu.scu.algorithms.exercises.leetcode;

import cn.edu.scu.algorithms.exercises.leetcode.eazy.ListNode;

/**
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseLinkedList_206 {

    // 递归回溯法
    public cn.edu.scu.algorithms.exercises.leetcode.eazy.ListNode reverseList(cn.edu.scu.algorithms.exercises.leetcode.eazy.ListNode head) {
        if (head == null || head.next == null) return head;
        cn.edu.scu.algorithms.exercises.leetcode.eazy.ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
