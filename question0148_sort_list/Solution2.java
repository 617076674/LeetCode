package question0148_sort_list;

/**
 * 自下而上的归并排序。
 *
 * 时间复杂度是 O(nlogn)，其中 n 为链表中的节点个数。空间复杂度是 O(1)。
 *
 * 执行用时：14ms，击败14.30%。消耗内存：46.9MB，击败8.98%。
 */
public class Solution2 {

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    int len = 0;
    ListNode cur = head;
    while (cur != null) {
      cur = cur.next;
      len++;
    }
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    for (int subLen = 1; subLen < len; subLen *= 2) {
      ListNode pre = dummyHead;
      cur = dummyHead.next;
      while (cur != null) {
        ListNode head1 = cur;
        for (int i = 0; i < subLen - 1 && cur.next != null; i++) {
          cur = cur.next;
        }
        ListNode head2 = cur.next;
        cur.next = null;
        cur = head2;
        for (int i = 0; i < subLen - 1 && cur != null; i++) {
          cur = cur.next;
        }
        ListNode next = null;
        if (cur != null) {
          next = cur.next;
          cur.next = null;
        }
        ListNode merged = mergeTwoLists(head1, head2);
        pre.next = merged;
        while (pre.next != null) {
          pre = pre.next;
        }
        cur = next;
      }
    }
    return dummyHead.next;
  }

  private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode cur1 = l1, cur2 = l2;
    ListNode dummyHead = new ListNode(-1);
    ListNode cur = dummyHead;
    while (cur1 != null || cur2 != null) {
      if (cur1 == null) {
        cur.next = cur2;
        cur2 = cur2.next;
      } else if (cur2 == null) {
        cur.next = cur1;
        cur1 = cur1.next;
      } else if (cur1.val > cur2.val) {
        cur.next = cur2;
        cur2 = cur2.next;
      } else {
        cur.next = cur1;
        cur1 = cur1.next;
      }
      cur = cur.next;
    }
    return dummyHead.next;
  }

}