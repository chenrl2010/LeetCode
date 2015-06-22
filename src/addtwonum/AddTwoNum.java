package addtwonum;

public class AddTwoNum {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		int addBit = 0;

		ListNode result = new ListNode(0);
		ListNode reListNode = result;
		while (p1 != null && p2 != null) {
			ListNode tempListNode = new ListNode(0);
			tempListNode.val = ((p1.val + p2.val + addBit) % 10);
			addBit = (p1.val + p2.val + addBit) / 10;
			p1 = p1.next;
			p2 = p2.next;

			result.next = tempListNode;
			result = result.next;
		}

		while (p1 != null) {
			ListNode tempListNode = new ListNode(0);
			tempListNode.val = ((p1.val + addBit) % 10);
			addBit = (p1.val + addBit) / 10;
			p1 = p1.next;
			result.next = tempListNode;
			result = result.next;
		}
		while (p2 != null) {
			ListNode tempListNode = new ListNode(0);
			tempListNode.val = ((p2.val + addBit) % 10);
			addBit = (p2.val + addBit) / 10;
			p2 = p2.next;
			result.next = tempListNode;
			result = result.next;
		}

		if (addBit > 0) {
			ListNode tempListNode = new ListNode(0);
			tempListNode.val = (addBit % 10);
			tempListNode.next = null;
			result.next = tempListNode;
			result = result.next;
		}

		return reListNode.next != null ? reListNode.next : null;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(9,
				new ListNode(9, null))));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));

		ListNode reListNode = new AddTwoNum().addTwoNumbers(l1, l2);

		while (reListNode != null) {
			System.out.println(reListNode.val);
			reListNode = reListNode.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int x) {
		val = x;
	}

	public ListNode() {
		val = 0;
		next = null;
	}

	public ListNode(int x, ListNode nextListNode) {
		this.val = x;
		this.next = nextListNode;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

}
