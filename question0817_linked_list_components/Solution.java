package question0817_linked_list_components;

public class Solution {

  public int numComponents(ListNode head, int[] G) {
    boolean[] inG = new boolean[10001];
    for (int num : G) {
      inG[num] = true;
    }
    if (null == head) {
      return 0;
    }
    int result = 0;
    ListNode cur1 = head;
    while (cur1 != null) {
      if (inG[cur1.val]) {
        ListNode cur2 = cur1;
        while (cur2 != null && inG[cur2.val]) {
          cur2 = cur2.next;
        }
        result++;
        if (cur2 == null) {
          return result;
        }
        cur1 = cur2.next;
      } else {
        cur1 = cur1.next;
      }
    }
    return result;
  }

}