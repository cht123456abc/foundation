package cn.edu.scu.exam;

import cn.edu.scu.algorithms.exercises.leetcode.ListNode;

/**
 * cn.edu.scu.exam.两个链表的第一个公共结点 相似的企业真题
 * 时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 64M，其他语言128M 热度指数：456075
 * 本题知识点： 链表
 *  算法知识视频讲解
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class 两个链表的第一个公共结点 {

    public static void main(String[] args) {
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;

        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != null || p2 != null) {
            if(p1 == null) p1 = pHead2;
            if(p2 == null) p2 = pHead1;
            if (p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;

    }

}
