package question147;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = dummyHead.next;
        ListNode newPre = dummyHead;
        ListNode newCur = dummyHead.next;
        while(cur != null) {
            while(newCur != cur && newCur.val < cur.val) {
                newPre = newPre.next;
                newCur = newCur.next;
            }
            if(newCur != cur) {
                ListNode nextCur = cur.next;
                newPre.next = cur;
                cur.next = newCur;
                pre.next = nextCur;
                cur = nextCur;
            }else {
                pre = pre.next;
                cur = cur.next;
            }
            newPre = dummyHead;
            newCur = dummyHead.next;
        }
        return dummyHead.next;
    }
}
