package lcof24_fan_zhuan_lian_biao;

/**
 * 递归实现。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为链表中的节点个数。
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}