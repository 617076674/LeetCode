package question2074_reverse_nodes_in_even_length_groups;

public class Solution {

  public ListNode reverseEvenLengthGroups(ListNode head) {
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    ListNode cur = dummyHead;
    for (int len = 1; ; len++) {
      ListNode tail = cur;
      int i = 0;
      for (; i < len && null != tail.next; i++) {
        tail = tail.next;
      }
      if (i % 2 == 0) {
        if (tail.next == null) {
          cur.next = reverseList(cur.next);
          return dummyHead.next;
        }
        ListNode tailNext = tail.next;
        tail.next = null;
        ListNode curNext = cur.next;
        cur.next = reverseList(cur.next);
        curNext.next = tailNext;
        cur = curNext;
      } else {
        cur = tail;
      }
    }
  }

  private ListNode reverseList(ListNode listNode) {
    if (null == listNode || listNode.next == null) {
      return listNode;
    }
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = listNode;
    ListNode cur1 = dummyHead.next, cur2 = cur1.next;
    while (cur2 != null) {
      cur1.next = cur2.next;
      cur2.next = dummyHead.next;
      dummyHead.next = cur2;
      cur2 = cur1.next;
    }
    return dummyHead.next;
  }

}