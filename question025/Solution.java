package question025;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82377399
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        if (cur1.next == null || cur1.next.next == null) {
            return head;
        }
        ListNode cur2 = cur1.next;
        ListNode cur3 = cur1;
        int index = k;
        while (index > 0) {
            cur3 = cur3.next;
            if (cur3 == null) {
                return dummyHead.next;
            }
            index--;
        }
        while (true) {
            ListNode temp = cur3.next;
            cur3.next = null;
            cur1.next = reverseList(cur2);
            cur2.next = temp;
            cur1 = cur2;
            cur2 = temp;
            cur3 = cur1;
            index = k;
            while (index > 0) {
                cur3 = cur3.next;
                if (cur3 == null) {
                    return dummyHead.next;
                }
                index--;
            }
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        if (cur1.next == null || cur1.next.next == null) {
            return head;
        }
        ListNode cur2 = cur1.next;
        ListNode cur3 = cur2.next;
        while (cur3 != null) {
            cur2.next = cur3.next;
            ListNode temp = cur1.next;
            cur1.next = cur3;
            cur3.next = temp;
            cur3 = cur2.next;
        }
        return dummyHead.next;
    }
}
