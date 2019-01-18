package question160;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode curA = headA;
        ListNode curB = headB;
        int gap = Math.abs(lenA - lenB);
        if (lenA >= lenB) {
            while(gap-- > 0){
                curA = curA.next;
            }
        } else {
            while(gap-- > 0){
                curB = curB.next;
            }
        }
        while(null != curA){
            if(curA == curB){
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
