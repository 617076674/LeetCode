package question234;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur2 = dummyHead;
        ListNode cur3 = dummyHead;
        while(cur3 != null && cur3.next != null) {
            cur2 = cur2.next;
            cur3 = cur3.next.next;
        }
        cur2 = cur2.next;
        ListNode preCur2 = dummyHead;
        while(preCur2.next != cur2) {
            preCur2 = preCur2.next;
        }
        preCur2.next = null;
        ListNode newHead = reverseLinkedList(cur2);
        ListNode cur = head;
        ListNode newCur = newHead;
        while(cur != null && newCur != null) {
            if(cur.val != newCur.val) {
                return false;
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return true;
    }
    private ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while(cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if(cur != null) {
                next = cur.next;
            }
        }
        return pre;
    }
}
