package amazon;

public class ReverseSecond {
    public static void main(String[] args) {
    	ReverseSecond test = new ReverseSecond();
		ListNode a0 = new ListNode(0);
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		a0.next = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		
		ListNode head = test.solve(a0);
		while(head != null){
			System.out.print(head.value + "-");
			head = head.next;
		}
	}
    private ListNode solve(ListNode head){
    	if(head == null || head.next == null) return head;
    	ListNode fast = head.next;
    	ListNode slow = head;
    	while(fast.next != null && fast.next.next != null){
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	ListNode pre = slow.next;
    	ListNode cur = pre.next;
    	while(cur != null){
    		pre.next = cur.next;
    		cur.next = slow.next;
    		slow.next = cur;
    		cur = pre.next;
    	}
    	return head;
    }
}
