package question019;

/*
 * 解析请见：https://blog.csdn.net/qq_41231926/article/details/82250538
 */
public class Solution1 {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int count = 0;
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode cur1 = dummyHead;
		while(cur1.next != null) {
			count++;
			cur1 = cur1.next;
		}
		int delIndex = count + 1 - n;
		//删除节点的关键是找到待删除节点的前一个节点
		int preDelIndex = delIndex - 1; 
		int index = 0;
		ListNode cur2 = dummyHead;
		while(index != preDelIndex) {
			index++;
			cur2 = cur2.next;
		}
		 ListNode delNode = cur2.next;
	     cur2.next = delNode.next;
	     return dummyHead.next;
	}
}
