package question141;

public class Solution2 {
    public boolean hasCycle(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        ListNode cur2 = dummyHead;
        while(true){
            if(null == cur2.next || null == cur2.next.next){
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next.next;
            if(cur1 == cur2){
                return true;
            }
        }
    }
}
