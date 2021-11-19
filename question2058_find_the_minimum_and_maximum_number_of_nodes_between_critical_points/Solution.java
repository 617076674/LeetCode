package question2058_find_the_minimum_and_maximum_number_of_nodes_between_critical_points;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int[] nodesBetweenCriticalPoints(ListNode head) {
    List<Integer> list = new ArrayList<>();
    ListNode cur = head;
    while (cur != null) {
      list.add(cur.val);
      cur = cur.next;
    }
    List<Integer> edges = new ArrayList<>();
    for (int i = 1; i < list.size() - 1; i++) {
      if ((list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1))
          || (list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1))) {
        edges.add(i);
      }
    }
    if (edges.size() < 2) {
      return new int[] {-1, -1};
    }
    int minDistance = Integer.MAX_VALUE;
    for (int i = 1; i < edges.size(); i++) {
      minDistance = Math.min(minDistance, edges.get(i) - edges.get(i - 1));
    }
    int maxDistance = edges.get(edges.size() - 1) - edges.get(0);
    return new int[] {minDistance, maxDistance};
  }

}