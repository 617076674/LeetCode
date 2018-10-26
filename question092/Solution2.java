package question092;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83140703
 */
public class Solution2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        int interval = n - m;
        while(m > 1){
            m--;
            cur1 = cur1.next;
        }
        ListNode cur2 = cur1.next;
        while(interval > 0){
            interval--;
            cur2 = cur2.next;
        }
        ListNode temp1 = cur1.next;
        ListNode temp2 = cur2.next;
        cur2.next = null;
        cur1.next = reverse(temp1);
        temp1.next = temp2;
        return dummyHead.next;
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        ListNode cur2 = dummyHead.next;
        ListNode cur3 = cur2.next;
        while(cur3 != null){
            cur2.next = cur3.next;
            ListNode temp = cur1.next;
            cur1.next = cur3;
            cur3.next = temp;
            cur3 = cur2.next;
        }
        return dummyHead.next;
    }
}
