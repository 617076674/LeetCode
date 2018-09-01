package question023;

import question021.ListNode;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82263333
 */
public class Solution5 {
	
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) {
			return null;
		}
		if(lists.length == 1) {
			return lists[0];
		}
		ListNode temp = mergeTwoLists(lists[0], lists[1]);
		for(int i = 2; i < lists.length; i++) {
			temp = mergeTwoLists(temp, lists[i]);
		}
		return temp;
	}
	
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		ListNode dummyHead = new ListNode(-1);
		ListNode cur = dummyHead;
		while(cur1 != null || cur2 != null) {
			if(cur1 == null) {
				cur.next = cur2;
				cur2 = cur2.next;
			}else if(cur2 == null) {
				cur.next = cur1;
				cur1 = cur1.next;
			}else if(cur1.val > cur2.val) {
				cur.next = cur2;
				cur2 = cur2.next;
			}else {
				cur.next = cur1;
				cur1 = cur1.next;
			}
			cur = cur.next;
		}
		return dummyHead.next;
	}
}
