package facebook;

import java.util.Stack;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class ReverseLinkedList {
    
	public static void main(String[] args) {
        ReverseLinkedList test = new ReverseLinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        
      //  ListNode pre;
     //   pre = test.reverse2(node1);
     /*   while(pre != null){
        	System.out.println(pre.val);
        	pre = pre.next;
        } */
        test.print3(node1);
    }
	
	private ListNode reverse1(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode pre = reverse1(head.next);
		head.next.next = head;
		head.next = null;
		return pre;
	}
	
	private ListNode reverse2(ListNode head){
		ListNode newHead = null;
		while(head != null){
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
	
	private void print1(ListNode head){
		if(head == null) return;
		print1(head.next);
		System.out.println(head.val);
	}
	
	private void print2(ListNode head){
		Stack<ListNode> stack = new Stack<>();
		while(head != null){
			stack.push(head);
			head = head.next;
		}
		while(!stack.empty()){
			System.out.println(stack.pop().val);
		}
	}
	
	private void print3(ListNode node3){
		ListNode newHead = null;
		while(node3 != null){
			ListNode next = node3.next;
			node3.next = newHead;
			newHead = node3;
			node3 = next;
		}
		ListNode head = newHead;
		newHead = null;
		while(head != null){
			System.out.println(head.val);
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
	}
}
