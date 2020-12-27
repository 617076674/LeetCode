package lcof25_he_bing_liang_ge_pai_xu_de_lian_biao;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2, dummyHead = new ListNode(-1), cur = dummyHead;
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