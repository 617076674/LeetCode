package question2130;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int pairSum(ListNode head) {
    List<Integer> list = new ArrayList<>();
    ListNode cur = head;
    while (cur != null) {
      list.add(cur.val);
      cur = cur.next;
    }
    int result = 0;
    for (int i = 0; i < list.size() / 2; i++) {
      result = Math.max(result, list.get(i) + list.get(list.size() - 1 - i));
    }
    return result;
  }

}