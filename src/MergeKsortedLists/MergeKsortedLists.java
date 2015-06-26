package MergeKsortedLists;


public class MergeKsortedLists {
	/**
	 * TLE method,思路：扫描数组list中的每一个节点，如果list[i]最小，则取出，同时设置list[i] = list[i].next，继续扫描数组list，重复操作，直到数组list所有的元素都为null，完成，时间复杂度O(KN)
	 * @param list
	 * @return
	 */
	public ListNode merge(ListNode[] list) {
		if (list.length < 1) {
			return null;
		}
		ListNode result = new ListNode(Integer.MAX_VALUE);
		ListNode tmpNode = new ListNode(Integer.MAX_VALUE);
		int index = 0;
		// 初始一个tmpNode;
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				tmpNode = list[i];
				index = i;
				break;
			}
		}
		boolean isFirst = true;
		ListNode head = list[0];
		while (true) {
			// 如果list中全部元素为null，返回
			if (checkNull(list)) {
				break;
			}
			for (int i = 0; i < list.length; i++) {
				if (list[i] != null && list[i].val < tmpNode.val) {
					tmpNode = list[i];
					index = i;
				}
			}
			list[index] = list[index].next;
			result.next = tmpNode;
			// 初始一个tmpNode;
			for (int i = 0; i < list.length; i++) {
				if (list[i] != null) {
					tmpNode = list[i];
					index = i;
					break;
				}
			}
			if (isFirst) {
				head = result.next;
				isFirst = false;
			}
			result = result.next;

		}
		return head;
	}

	private boolean checkNull(ListNode[] list) {
		if (list == null || list.length == 0)
			return true;
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * method 2 思路：典型的归并排序，最终延伸为两个有序链表的合并，时间复杂度O(NlogN)
	 * @param l1
	 * @param l2
	 * @return
	 */
	
	public ListNode merge2(ListNode[] lists) {
		if (lists.length < 1) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		
		int mid = (lists.length-1)/2;
		ListNode[] list1 = new ListNode[mid+1];
		
		for(int i = 0; i <= mid; i++) {
			list1[i] = lists[i];
		}
		
		ListNode[] list2 = new ListNode[lists.length-mid-1];
		for(int i = mid + 1; i < lists.length; i++) {
			list2[i-mid-1] = lists[i];
		}
		
		ListNode l1 = merge2(list1);
		ListNode l2 = merge2(list2);
		
		return mergeTwoLists(l1, l2);

	}
	
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
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
		head1.setNextNode(new ListNode(3)).setNextNode(new ListNode(8))
				.setNextNode(new ListNode(12)).setNextNode(new ListNode(18));
		ListNode head = head1;
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println("");

		ListNode head2 = new ListNode(2);
		head2.setNextNode(new ListNode(4)).setNextNode(new ListNode(5))
				.setNextNode(new ListNode(9)).setNextNode(new ListNode(10));
		head = head2;
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println("");

		ListNode head3 = new ListNode(2);
		// head3.setNextNode(new ListNode(4)).setNextNode(new
		// ListNode(6)).setNextNode(new ListNode(9)).setNextNode(new
		// ListNode(10));
		head = head3;
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println("");

//		ListNode[] list = { head1, head2, head3 };
		ListNode[] list = { new ListNode(1), new ListNode(2) };

		ListNode result = new MergeKsortedLists().merge2(list);

		while (result != null) {
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

	public ListNode setNextNode(ListNode node) {
		next = node;
		return next;
	}
}
