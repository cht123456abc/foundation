package cn.edu.scu.exercises.leetcode.eazy;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class RemoveDuplicatesFromSortedList_83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode p = head.next;
        while (p != null) {
            if (p.val == pre.val) {
                // 删除p节点
                pre.next = p.next;
                p.next = null;
                p = pre.next;
            } else {
                p = p.next;
                pre = pre.next;
            }
        }
        return head;
    }
}
