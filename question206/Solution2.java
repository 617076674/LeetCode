package question206;

public class Solution2 {

    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        if(cur1.next == null || cur1.next.next == null) {
            return head;
        }
        ListNode cur2 = cur1.next;
        ListNode cur3 = cur2.next;
        while(cur3 != null) {
            cur2.next = cur3.next;
            ListNode temp = cur1.next;
            cur1.next = cur3;
            cur3.next = temp;
            cur3 = cur2.next;
        }
        return dummyHead.next;
    }
}

