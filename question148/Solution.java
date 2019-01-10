package question148;

class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode preCur1 = null;
        ListNode cur1 = head;
        ListNode cur2 = head;
        while(null != cur2 && null != cur2.next){
            preCur1 = cur1;
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        ListNode node1 = sortList(preCur1.next);
        preCur1.next = null;
        ListNode node2 = sortList(head);
        return mergeTwoLists(node1, node2);
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while(cur1 != null || cur2 != null) {
            if(cur1 == null) {
                cur.next = cur2;
                cur2 = cur2.next;
            }else if(cur2 == null) {
                cur.next = cur1;
                cur1 = cur1.next;
            }else if(cur1.val > cur2.val) {
                cur.next = cur2;
                cur2 = cur2.next;
            }else {
                cur.next = cur1;
                cur1 = cur1.next;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}