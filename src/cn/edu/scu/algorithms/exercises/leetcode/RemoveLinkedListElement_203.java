package cn.edu.scu.algorithms.exercises.leetcode;



/**
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveLinkedListElement_203 {

    // 用前指针指向dummyhead
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p = head;
        while (p != null) {
            if (p.val == val) {
                if (p == head) head = head.next;
                pre.next = p.next;
                p.next = null;
                p = pre.next;
            } else {
                pre = pre.next;
                p = p.next;
            }
        }
        return head;
    }

    // 递归回溯法
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
