package question0143_reorder_list;

public class Solution {

  public void reorderList(ListNode head) {
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    ListNode cur1 = head, cur2 = dummyHead, cur3 = dummyHead;
    while (cur3 != null && cur3.next != null) {
      cur2 = cur2.next;
      cur3 = cur3.next.next;
    }
    ListNode middle = cur2.next;
    cur2.next = null;
    ListNode newHead = reverseLinkedList(middle), newCur1 = newHead;
    while (cur1 != null && newCur1 != null) {
      ListNode nextCur1 = cur1.next, nextNewCur1 = newCur1.next;
      cur1.next = newCur1;
      newCur1.next = nextCur1;
      newCur1 = nextNewCur1;
      cur1 = nextCur1;
    }
  }

  private ListNode reverseLinkedList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode pre = null, cur = head, next = cur.next;
    while (cur != null) {
      cur.next = pre;
      pre = cur;
      cur = next;
      if (cur != null) {
        next = cur.next;
      }
    }
    return pre;
  }

}