package cn.edu.scu.algorithms.exercises.SwordTowardOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 面试题06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class PrintLinkedListFromTailToHead_6 {

    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while(head != null){
            res.add(head.val);
            head = head.next;
        }
        Collections.reverse(res);
        int[] r = res.stream().mapToInt(Integer::intValue).toArray();
        return r;
    }
}
