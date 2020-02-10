package question0061_rotate_list;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 *
 * 时间复杂度是O(n)，其中n为链表中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.92%。消耗内存：37.9MB，击败7.14%。
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1), cur = dummyHead;
        dummyHead.next = head;
        int len = 0;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        k %= len;
        if (0 == k) {
            return head;
        }
        ListNode cur1 = dummyHead, cur2 = dummyHead;
        for (int i = 0; i < k; i++) {
            cur1 = cur1.next;
        }
        while (null != cur1.next) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        cur1.next = dummyHead.next;
        dummyHead.next = cur2.next;
        cur2.next = null;
        return dummyHead.next;
    }
}