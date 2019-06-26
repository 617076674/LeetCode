package question0021;

/**
 * 循环实现。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为链表l1和链表l2中的结点总数。
 *
 * 执行用时：2ms，击败95.09%。消耗内存：39.1MB，击败69.64%。
 */
public class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2, dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (cur1 != null || cur2 != null) {
            if (cur1 == null) {
                cur.next = cur2;
                cur2 = cur2.next;
            } else if (cur2 == null) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                if (cur1.val > cur2.val) {
                    cur.next = cur2;
                    cur2 = cur2.next;
                } else {
                    cur.next = cur1;
                    cur1 = cur1.next;
                }
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
