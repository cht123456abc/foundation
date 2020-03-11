package cn.edu.scu.exercises;

import java.util.ArrayList;

public class PrintListFromTailToHead {
	public static void main(String[] args) {
		ListNode listNode = new ListNode();
		for(int i=0;i<10;i++) {
			insert(listNode,i);
		}
		ArrayList<Integer> list = printListFromTailToHead(listNode);
		System.out.println(list.toString());
	}

	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
		ListNode head = listNode;
		while(head != null) {
			System.out.println(head.val);
			list.add(head.val);
			head = head.next;
		}
		ArrayList<Integer> list2 = new ArrayList<>();
		for(int i=list.size()-1;i>=0;i--) {
			list2.add(list.get(i));
		}
		return list2;

	}
	
	public static void insert(ListNode listNode,int p) {
		ListNode newP = new ListNode(p);
		ListNode head = listNode;
		while(head.next != null) {
			head = head.next;
		}
		head.next = newP;
		
	}
}

