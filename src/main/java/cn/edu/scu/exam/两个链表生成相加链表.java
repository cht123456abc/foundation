package cn.edu.scu.exam;

import cn.edu.scu.algorithms.exercises.leetcode.ListNode;

/**
 * cn.edu.scu.exam.两个链表生成相加链表
 * 时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 512M，其他语言1024M 热度指数：36630
 * 本题知识点： 链表
 * 算法知识视频讲解
 * 题目描述
 * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 * 示例1
 * 输入
 * 复制
 * [9,3,7],[6,3]
 * 返回值
 * 复制
 * {1,0,0,0}
 * 备注:
 * 1 \leq n, m \leq 10^61≤n,m≤10
 * 6
 * <p>
 * 0 \leq a_i, b_i \leq 90≤a
 * i
 * ​
 * ,b
 * i
 * ​
 * ≤9
 */
public class 两个链表生成相加链表 {

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);

        System.out.println(new 两个链表生成相加链表().reverseLinkedList(root).val);

    }

    public ListNode addInList(ListNode head1, ListNode head2) {

        // 反转链表
        ListNode p1 = reverseLinkedList(head1);
        ListNode p2 = reverseLinkedList(head2);

        ListNode res = new ListNode(0);
        ListNode p = res;
        int carry = 0;
        while (p1 != null || p2 != null || carry == 1) {
            int a = p1 == null ? 0 : p1.val;
            int b = p2 == null ? 0 : p2.val;

            int sum = a + b + carry;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            p.next = new ListNode(sum);
            p = p.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }


        return reverseLinkedList(res.next);

    }

    private ListNode reverseLinkedList(ListNode head) {

        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
}
