package cn.edu.scu.algorithms.exercises.leetcode;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class ReverseNodesInKGroup_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode previous = dummyNode,p = dummyNode.next;
        while(p != null){
            ListNode next_p = p;
            ListNode ori = p;
            boolean flag = false;
            for(int i = k;i>0;i--){
                if(next_p== null){
                    previous.next = ori;
                    flag = true;
                    break;
                }
                next_p = next_p.next;
            }
            if(flag) break;
            // 对k个节点链表进行反转
            ListNode pre = null;
            while(p != next_p){
                ListNode pn = p.next;
                p.next = pre;
                pre = p;
                p = pn;
            }
            previous.next = pre;
            previous = ori;
        }
        return dummyNode.next;
    }

}
