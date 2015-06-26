package MergeTwoSortedLists;


public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		
		ListNode head = null;
		if(l1.val <= l2.val) {
			head = l1;
			l1 = l1.next;
		}else {
			head = l2;
			l2 = l2.next;
		}
		ListNode result = head;
		while(l1 != null && l2 != null) {
			if(l1.val <= l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		if (l1 != null) {
			head.next = l1;
		}
		if (l2 != null) {
			head.next = l2;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		head1.setNextNode(new ListNode(2)).setNextNode(new ListNode(8)).setNextNode(new ListNode(12)).setNextNode(new ListNode(18));
		ListNode head = head1;
		while(head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println("");
		
		ListNode head2 = new ListNode(1);
		head2.setNextNode(new ListNode(2)).setNextNode(new ListNode(5)).setNextNode(new ListNode(9)).setNextNode(new ListNode(10));
		head = head2;
		while(head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println("");

		
		ListNode result = new MergeTwoSortedLists().mergeTwoLists(head1, head2);
		
		while(result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
		
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
	
	public ListNode setNextNode( ListNode node) {
		next = node;
		return next;
	}
}