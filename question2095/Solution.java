package question2095;

public class Solution {

  public ListNode deleteMiddle(ListNode head) {
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    int len = 0;
    ListNode cur = dummyHead;
    while (cur.next != null) {
      cur = cur.next;
      len++;
    }
    len /= 2;
    cur = dummyHead;
    while (len-- > 0) {
      cur = cur.next;
    }
    cur.next = cur.next.next;
    return dummyHead.next;
  }

}