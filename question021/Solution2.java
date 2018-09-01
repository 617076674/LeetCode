package question021;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82250787
 */
public class Solution2 {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		if(l1.val > l2.val) {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}else {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
	}
}
