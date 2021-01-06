package question0086_partition_list;

public class Solution {

    public ListNode partition(ListNode head, int x) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode lessNode = new ListNode(-1), greaterNode = new ListNode(-1), cur = head,
            cur1 = lessNode, cur2 = greaterNode;
        while (null != cur) {
            ListNode nextNode = cur.next;
            cur.next = null;
            if (cur.val < x) {
                cur1.next = cur;
                cur1 = cur1.next;
            } else {
                cur2.next = cur;
                cur2 = cur2.next;
            }
            cur = nextNode;
        }
        cur1.next = greaterNode.next;
        return lessNode.next;
    }

}
