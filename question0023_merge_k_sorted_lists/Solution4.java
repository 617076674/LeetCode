package question0023_merge_k_sorted_lists;

/**
 * 两两合并链表。
 *
 * 时间复杂度是O(n * m)，其中n为lists数组的长度，m为lists数组中链表总节点个数。空间复杂度是O(1)。
 *
 * 执行用时：374ms，击败14.23%。消耗内存：53.7MB，击败20.79%。
 */
public class Solution4 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n;
        if (null == lists || (n = lists.length) == 0) {
            return null;
        }
        ListNode result = lists[0];
        for (int i = 1; i < n; i++) {
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2, dummyHead = new ListNode(-1), cur = dummyHead;
        while (null != cur1 || null != cur2) {
            if (null == cur1) {
                cur.next = cur2;
                cur2 = cur2.next;
            } else if (null == cur2) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else if (cur1.val > cur2.val) {
                cur.next = cur2;
                cur2 = cur2.next;
            } else {
                cur.next = cur1;
                cur1 = cur1.next;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}