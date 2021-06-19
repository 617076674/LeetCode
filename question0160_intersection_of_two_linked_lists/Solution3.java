package question0160_intersection_of_two_linked_lists;

public class Solution3 {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode cur1 = headA, cur2 = headB;
    boolean flag1 = false, flag2 = false;
    while (true) {
      if (cur1 == cur2) {
        return cur1;
      }
      cur1 = cur1.next;
      if (cur1 == null) {
        if (flag1 && flag2) {
          break;
        }
        flag1 = true;
        cur1 = headB;
      }
      cur2 = cur2.next;
      if (cur2 == null) {
        if (flag1 && flag2) {
          break;
        }
        flag2 = true;
        cur2 = headA;
      }
    }
    return null;
  }

}
