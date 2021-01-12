package question1721_swapping_nodes_in_a_linked_list;

public class Solution {

  public ListNode swapNodes(ListNode head, int k) {
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    int step = 0;
    ListNode cur = dummyHead;
    while (step < k) {
      step++;
      cur = cur.next;
    }
    ListNode firstNode = cur, cur2 = dummyHead;
    while (cur != null) {
      cur = cur.next;
      cur2 = cur2.next;
    }
    int temp = cur2.val;
    cur2.val = firstNode.val;
    firstNode.val = temp;
    return dummyHead.next;
  }

}