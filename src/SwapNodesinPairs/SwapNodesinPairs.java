package SwapNodesinPairs;


public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if (null == head) {
			return null;
		}
		if (head.next == null) {
			return head;
		}

		ListNode result = head;
		while (head != null && head.next != null) {
			int tmp = head.val;
			head.val = head.next.val;
			head.next.val = tmp;

			head = head.next.next;
		}

		return result;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.setNextNode(new ListNode(2)).setNextNode(new ListNode(3)).setNextNode(new ListNode(4)).setNextNode(new ListNode(5));
		ListNode h = head;
		while(h != null) {
			System.out.print(h.val + "->");
			h = h.next;
		}
		System.out.println("");
		
		h = new SwapNodesinPairs().swapPairs(head);
		while(h != null) {
			System.out.print(h.val + "->");
			h = h.next;
		}
		System.out.println("");
		
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public ListNode setNextNode(ListNode node) {
		next = node;
		return next;
	}
}