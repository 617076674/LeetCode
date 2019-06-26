package question061;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82834157
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        int len = 0;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode cur1 = dummyHead;
        ListNode cur2 = dummyHead;
        for (int i = 0; i < k; i++) {
            cur1 = cur1.next;
        }
        while (cur1.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        cur1.next = dummyHead.next;
        dummyHead.next = cur2.next;
        cur2.next = null;
        return dummyHead.next;
    }
}
