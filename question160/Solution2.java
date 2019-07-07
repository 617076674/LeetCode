package question160;

/**
 * 让长链表先走几步。
 *
 * 时间复杂度是O(m + n)，其中m为链表headA的长度，n为链表headBand的长度。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败35.34%。消耗内存：47.5MB，击败16.72%。
 */
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA), lenB = getLength(headB);
        ListNode curA = headA, curB = headB;
        int gap = Math.abs(lenA - lenB);
        if (lenA >= lenB) {
            while (gap-- > 0) {
                curA = curA.next;
            }
        } else {
            while (gap-- > 0) {
                curB = curB.next;
            }
        }
        while (null != curA) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    private int getLength(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (null != cur) {
            cur = cur.next;
            len++;
        }
        return len;
    }
}
