package question019;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82250538
 */
public class Solution2 {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode cur1 = dummyHead;
		ListNode cur2 = dummyHead;
		while(n > 0) {
			cur2 = cur2.next;
			n--;
		}
		while(cur2.next != null) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		ListNode delNode = cur1.next;
		cur1.next = delNode.next;
		return dummyHead.next;
	}
}
