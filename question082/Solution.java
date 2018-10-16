package question082;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82963136
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        ListNode cur2 = cur1.next;
        ListNode cur3 = cur2.next;
        while(cur3 != null){
            if(cur2.val != cur3.val){
                cur1 = cur2;
                cur2 = cur3;
                cur3 = cur3.next;
            }else {
                while (cur2.val == cur3.val) {
                    cur3 = cur3.next;
                    if (cur3 == null) {
                        cur1.next = null;
                        return dummyHead.next;
                    }
                }
                cur1.next = cur3;
                cur2 = cur3;
                cur3 = cur3.next;
            }
        }
        return dummyHead.next;
    }
}
