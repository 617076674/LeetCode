package lcof24_fan_zhuan_lian_biao;

/**
 * 循环实现。
 *
 * 时间复杂度是 O(n)，其中 n 为链表中的节点个数。空间复杂度是 O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：39.5MB，击败100.00%。
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = head.next;
        while (null != cur) {
            ListNode tmp = cur.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
            head.next = tmp;
            cur = tmp;
        }
        return dummyHead.next;
    }
}
