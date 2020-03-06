package cn.edu.scu.exercises;

public class MergeTwoListNode {
	public static void main(String[] args) {
		ListNode list1 = new ListNode(0);
		ListNode list2 = new ListNode(0);
		init(list1);
		init(list2);
		print(list1);
		print(list2);
		ListNode result = Merge(list1,list2);
		print(result);
	}
	
	public static ListNode Merge(ListNode list1,ListNode list2) {
		ListNode result = null;
		ListNode p1 = list1;
		ListNode p2 = list2;
		if(p1 == null) {
			if(p2 == null) return null;
			else {
				result = p2.next;
				return result;
			}
		}else {
			if(p2 == null) {
				result = p1.next;
				return result;
			}else {
				if(p1.val <= p2.val) {
					result = p1;
					p1 = p1.next;
				}else {
					result = p2;
					p2 = p2.next;
				}
				ListNode p0 = result;
				//两个连表的每个节点都相互进行比较，每比较出一次较小值，较小值所在的那个链表指针向后移一位。
				while(true) {
					if(p1 == null) {
						if(p2 == null) break;
						else {
							p0.next = p2;
						}
						break;
					}else {
						if(p2 == null) {
							p0.next = p1;
							break;
						}else {
							if(p1.val <= p2.val) {
								p0.next = p1;
								p1 = p1.next;
							}else {
								p0.next = p2;
								p2 = p2.next;
							}
							p0 = p0.next;
						}
					}
				}
			}
		}
		return result;
	}
	
	 private static void init(ListNode head) {
	    	for(int i=1;i<10;i++) {
				ListNode newNode = new ListNode(i);//这一步相当于对引用对象的属性赋值。
				head.next = newNode;//这一步相当与对引用赋值，方法一旦调用完毕，原引用变量不变
				head = head.next;
			}
	    }
	    
	    private static void print(ListNode head) {
	    	while(head != null) {
				System.out.print(head.val+" ");
				head = head.next;
			}
	    }

	static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
}
