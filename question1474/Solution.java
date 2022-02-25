package question1474;

public class Solution {

    public ListNode deleteNodes(ListNode head, int m, int n) {
      ListNode dummyHead = new ListNode(-1);
      dummyHead.next = head;
      ListNode cur = dummyHead;
      while (true) {
        int cnt = 0;
        while (cnt < m) {
          cnt++;
          if (null == cur) {
            return dummyHead.next;
          }
          cur = cur.next;
        }
        ListNode temp = cur;
        if (null == temp) {
          return dummyHead.next;
        }
        cnt = 0;
        while (cnt < n) {
          cnt++;
          if (null == cur) {
            temp.next = null;
            return dummyHead.next;
          }
          cur = cur.next;
        }
        if (cur == null) {
          temp.next = null;
          return dummyHead.next;
        }
        temp.next = cur.next;
      }
    }

}