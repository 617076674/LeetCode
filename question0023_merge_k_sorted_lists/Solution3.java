package question0023_merge_k_sorted_lists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 优先队列，限制优先队列大小为n。
 *
 * 时间复杂度是O(mlogn)，其中m为lists数组中链表总节点个数，n为lists数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：85ms，击败35.29%。消耗内存：40.9MB，击败81.11%。
 */
public class Solution3 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n;
        if (null == lists || (n = lists.length) == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(n, Comparator.comparingInt(node -> node.val));
        for (int i = 0; i < n; i++) {
            if (null != lists[i]) {
                pq.add(lists[i]);
            }
        }
        ListNode dummyHead = new ListNode(-1), cur = dummyHead;
        while (!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            if (null != tmp.next) {
                pq.add(tmp.next);
            }
            cur.next = tmp;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}