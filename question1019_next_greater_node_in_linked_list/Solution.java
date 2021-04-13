package question1019_next_greater_node_in_linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  //[2,1,5]
  //[5,5,0]
  //[0,1,2]
  //[1,0,2]

  //[2,7,4,3,5]
  //[0,1,2,3,4]
  //[0,3,2,4,1]
  public int[] nextLargerNodes(ListNode head) {
    List<Integer> list = new ArrayList<>();
    ListNode cur = head;
    while (cur != null) {
      list.add(cur.val);
      cur = cur.next;
    }
    int[] result = new int[list.size()];
    LinkedList<Integer> linkedList = new LinkedList<>();
    for (int i = 0; i < list.size(); i++) {
      while (!linkedList.isEmpty() && list.get(i) > list.get(linkedList.getLast())) {
        result[linkedList.pollLast()] = list.get(i);
      }
      linkedList.addLast(i);
    }
    return result;
  }

  public static void main(String[] args) {

  }

}