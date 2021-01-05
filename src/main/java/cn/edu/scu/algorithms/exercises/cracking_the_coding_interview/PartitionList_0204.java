package cn.edu.scu.algorithms.exercises.cracking_the_coding_interview;

import cn.edu.scu.algorithms.exercises.leetcode.ListNode;

/**
 * 面试题 02.04. 分割链表
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 *
 * 示例:
 *
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 */
public class PartitionList_0204 {

    public ListNode partition(ListNode head, int x) {
        // 比x更大的数包括x，移到链表尾部
        if(head == null || head.next == null) return head;

        // 左右指针
        ListNode left = head,right = head;
        while(right != null){
            if(right.val < x){
                int temp = left.val;
                left.val = right.val;
                right.val = temp;
                left = left.next;
            }
            right = right.next;

        }
        return head;
    }


     public ListNode partition1(ListNode head, int x) {
         // 比x更大的数包括x，移到链表尾部
         if(head == null || head.next == null) return head;

         ListNode p = head;
         while(p != null){
             if(p.val >= x){
                 ListNode q = p;
                 while(q != null){
                     if(q.val < x){
                         int temp = p.val;
                         p.val = q.val;
                         q.val = temp;
                         break;
                     }
                     q = q.next;
                 }
             }
             p = p.next;
         }
         return head;
     }
}
