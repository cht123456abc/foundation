package cn.edu.scu.algorithms.exercises.cracking_the_coding_interview;

import cn.edu.scu.algorithms.exercises.leetcode.ListNode;

/**
 * 面试题 02.06. 回文链表
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 *
 *
 * 示例 1：
 *
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 *
 * 输入： 1->2->2->1
 * 输出： true
 *
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Palindrome_0206 {

    // S = O(n)
    ListNode root;
    public boolean isPalindrome(ListNode head) {
        // 回溯 + 全局变量
        root = head;
        return dfs(head);

    }

    public boolean dfs(ListNode head){
        if(head == null) return true;
        boolean res = dfs(head.next);
        if(head.val != root.val) {
            res = false;
        }
        root = root.next;
        return res;


    }
}
