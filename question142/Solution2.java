package question142;

public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        ListNode cur2 = dummyHead;
        while(true){
            if(null == cur2.next || null == cur2.next.next){
                return null;
            }
            cur1 = cur1.next;
            cur2 = cur2.next.next;
            if(cur1 == cur2){
                break;
            }
        }
        cur1 = dummyHead;
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
