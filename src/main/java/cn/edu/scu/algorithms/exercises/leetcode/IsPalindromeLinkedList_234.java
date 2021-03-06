package cn.edu.scu.algorithms.exercises.leetcode;



/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class IsPalindromeLinkedList_234 {

    // 记录头指针全局变量
    ListNode firstNode;
    // 递归回溯解法
    public boolean isPalindrome(ListNode head) {
        firstNode = head;
        return isPal(head);
    }

    public boolean isPal(ListNode head) {
        if (head != null) {
            if (!isPal(head.next)) return false;// 回溯
            if (head.val != firstNode.val) return false;
            firstNode = firstNode.next;
        }
        return true;
    }
}
