package question2181;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public ListNode mergeNodes(ListNode head) {
    List<Integer> list = new ArrayList<>();
    ListNode cur = head;
    while (cur != null) {
      list.add(cur.val);
      cur = cur.next;
    }
    List<Integer> sumList = new ArrayList<>();
    int sum = -1;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == 0) {
        if (sum != -1) {
          sumList.add(sum);
        }
        sum = 0;
      } else {
        sum += list.get(i);
      }
    }
    ListNode result = new ListNode(sumList.get(0));
    cur = result;
    for (int i = 1; i < sumList.size(); i++) {
      cur.next = new ListNode(sumList.get(i));
      cur = cur.next;
    }
    return result;
  }

}