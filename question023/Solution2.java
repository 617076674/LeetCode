package question023;

import java.util.PriorityQueue;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82263333
 */
public class Solution2 {
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		for (int i = 0; i < lists.length; i++) {
			ListNode cur = lists[i];
			while(cur != null) {
				priorityQueue.add(cur.val);
				cur = cur.next;
			}
		}
		ListNode dummyHead = new ListNode(-1);
		ListNode cur = dummyHead;
		while(!priorityQueue.isEmpty()) {
			cur.next = new ListNode(priorityQueue.poll());
			cur = cur.next;
		}
		return dummyHead.next;
	}
}
