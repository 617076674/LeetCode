package question023;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82263333
 */
public class Solution3 {

	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) {
			return null;
		}
		PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {

			@Override
			public int compare(ListNode node1, ListNode node2) {
				return node1.val - node2.val;
			}
		});
		for (int i = 0; i < lists.length; i++) {
			if(lists[i] != null) {
				priorityQueue.add(lists[i]);
			}
		}
		ListNode dummyHead = new ListNode(-1);
		ListNode cur = dummyHead;
		while(!priorityQueue.isEmpty()) {
			ListNode temp = priorityQueue.poll();
			if(temp.next != null) {
				priorityQueue.add(temp.next);
			}
			cur.next = temp;
			cur = cur.next;	
		}
		return dummyHead.next;
	}
}
