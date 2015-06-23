package RemoveNthNodeFromEndofList;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n <= 0) {
			return null;
		}
		
		ListNode preNode = head;
		while(n > 1) {
			if(preNode == null) {
				return null;
			}
			preNode = preNode.next;
			n--;
		}
		ListNode beforeNode = head;
		ListNode delNode = head;
		while(preNode.next != null) {
			beforeNode = delNode;
			delNode = delNode.next;
			preNode = preNode.next;
		}
		if(delNode == head) {
			return delNode.next;
		}
		
		beforeNode.next = delNode.next;
		
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.setNextNode(new ListNode(2));
//		head.setNextNode(new ListNode(2)).setNextNode(new ListNode(3)).setNextNode(new ListNode(4)).setNextNode(new ListNode(5));
		head = new RemoveNthNodeFromEndofList().removeNthFromEnd(head, 2);
		
		while(head != null) {
			System.out.print(head.val + "->");
			head = head.next;
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
