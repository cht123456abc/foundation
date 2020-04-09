package cn.edu.scu.exercises.others;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class FindKthFromTail {
    public static ListNode FindKthToTail(ListNode head,int k) {
    	 if(head == null && k <=0) return null;
 		ListNode pre = head;
     	ListNode last = head;
         int i = 0;
     	for(;pre !=null;i++) {
             if(i>=k)
                 last = last.next;
             pre = pre.next;
         }
     	return i < k ? null : last;
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
			System.out.println(head.val);
			head = head.next;
		}
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		init(head);
		print(head);
		ListNode result = FindKthToTail(head,3);
		System.out.println(result.val);
		
	}
	
    
    static class ListNode {
    	int val;
    	ListNode next = null;
    	
    	ListNode(int val) {
    		this.val = val;
    	}
    }
}
