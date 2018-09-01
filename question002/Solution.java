package question002;

/*
 * ½âÎöÇë¼û£ºhttps://blog.csdn.net/qq_41231926/article/details/81784208
 */
public class Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		int flag = 0;
		while(true) {
			cur1.val = cur1.val + cur2.val + flag;
			if(cur1.val >= 10) {
				cur1.val -= 10;
				flag = 1;
			}else {
				flag = 0;
			}
			if(cur1.next == null || cur2.next == null) {
				break;
			}
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		if(cur1.next == null && cur2.next == null && flag == 1) {
			cur1.next = new ListNode(flag);
		}else if(cur1.next == null && cur2.next != null) {
			cur1.next = cur2.next;
			cur1.next.val = flag + cur2.next.val;
			ListNode cur = cur1.next;
			while(cur.val >= 10) {
				cur.val -= 10;
				if(cur.next == null) {
					cur.next = new ListNode(1);
				}else {
					cur.next.val += 1;
					cur = cur.next;
				}
			}
		}else if(cur1.next != null && cur2.next == null) {
			cur1.next.val = flag + cur1.next.val;
			ListNode cur = cur1.next;
			while(cur.val >= 10) {
				cur.val -= 10;
				if(cur.next == null) {
					cur.next = new ListNode(1);
				}else {
					cur.next.val += 1;
					cur = cur.next;
				}
			}
		}
		return l1;
	}
}
