package question023;

import question021.ListNode;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82263333
 */
public class Solution4 {
    public ListNode mergeKLists(ListNode[] lists) {
        while (lists.length > 1) {
            if (lists.length % 2 == 0) {
                ListNode[] newLists = new ListNode[lists.length / 2];
                int k = 0;
                for (int i = 0; i < lists.length - 1; i += 2) {
                    newLists[k++] = mergeTwoLists(lists[i], lists[i + 1]);
                }
                lists = newLists;
            } else {
                ListNode[] newLists = new ListNode[(lists.length - 1) / 2 + 1];
                int k = 0;
                for (int i = 0; i < lists.length - 2; i += 2) {
                    newLists[k++] = mergeTwoLists(lists[i], lists[i + 1]);
                }
                newLists[k] = lists[lists.length - 1];
                lists = newLists;
            }
        }
        if (lists.length == 0) {
            return null;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (cur1 != null || cur2 != null) {
            if (cur1 == null) {
                cur.next = cur2;
                cur2 = cur2.next;
            } else if (cur2 == null) {
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
