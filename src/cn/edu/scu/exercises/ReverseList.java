package cn.edu.scu.exercises;

public class ReverseList {
	public static ListNode ReverseList1(ListNode head) {
		 if(head==null)
	            return null;
	        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
	        ListNode pre = null;
	        ListNode next = null;
	        //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
	        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
	        //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
	        //所以需要用到pre和next两个节点
	        //1->2->3->4->5
	        //1<-2<-3 4->5
	        while(head!=null){
	            //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
	            //如此就可以做到反转链表的效果
	            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
	            next = head.next;
	            //保存完next，就可以让head从指向next变成指向pre了，代码如下
	            head.next = pre;
	            //head指向pre后，就继续依次反转下一个节点
	            //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
	            pre = head;
	            head = next;
	        }
	        //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
	        //直接输出pre就是我们想要得到的反转后的链表
	        return pre;
		
    }
	
	private static ListNode ReverseList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode tail = ReverseList(head.next);//tail指针记录链表末尾节点，返回过程不参与运算。
		//一旦调用结束，此时第一个返回的head指针，指向的是tail节点的前一个节点。  
		head.next.next = head;//将当前节点的引用赋值给下一个节点的的next引用，即让下一个节点的next引用指向当前结点对象;
		head.next = null;//必要。将当前节点的next引用赋值为空,在前面的每一次赋值都不必要,但当栈帧到栈底时，必须要将最后head指向的节点的next指针赋值为null，否则该链表会成循环链表,
		return tail;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		init(head);
		print(head);
		ListNode result = ReverseList(head);
		print(result);
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
