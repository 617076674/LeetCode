package question0023_merge_k_sorted_lists;

import java.util.PriorityQueue;

/**
 * 优先队列。
 *
 * 时间复杂度是O(mlogm)，其中m为lists数组中链表总节点个数。空间复杂度是O(m)。
 *
 * 执行用时：14ms，击败56.53%。消耗内存：43.9MB，击败57.53%。
 */
public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n;
        if (null == lists || (n = lists.length) == 0) {
            return null;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            ListNode cur = lists[i];
            while (null != cur) {
                pq.add(cur.val);
                cur = cur.next;
            }
        }
        ListNode dummyHead = new ListNode(-1), cur = dummyHead;
        while (!pq.isEmpty()) {
            cur.next = new ListNode(pq.poll());
            cur = cur.next;
        }
        return dummyHead.next;
    }
}