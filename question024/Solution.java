package question024;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82377317
 */
public class Solution {
	
	public ListNode swapPairs(ListNode head) {
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode cur1 = dummyHead;
		if(cur1.next == null || cur1.next.next == null) {
			return dummyHead.next;
		}
		ListNode cur2 = cur1.next;
		ListNode cur3 = cur2.next;
		while(true) {
			cur2.next = cur3.next;
			cur1.next = cur3;
			cur3.next = cur2;
			cur1 = cur2;
			if(cur1.next == null || cur1.next.next == null) {
				return dummyHead.next;
			}
			cur2 = cur1.next;
			cur3 = cur2.next;
		}
	}
}
