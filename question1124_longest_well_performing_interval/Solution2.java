package question1124_longest_well_performing_interval;

import java.util.LinkedList;

/**
 * 单调栈。
 */
public class Solution2 {

  public int longestWPI(int[] hours) {
    int[] sums = new int[hours.length + 1];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
    }
    LinkedList<Integer> linkedList = new LinkedList<>();
    for (int i = 0; i < sums.length; i++) {
      if (linkedList.isEmpty() || sums[linkedList.peekLast()] > sums[i]) {
        linkedList.addLast(i);
      }
    }
    int result = 0;
    for (int i = sums.length - 1; i >= 0 && !linkedList.isEmpty(); i--) {
      while (!linkedList.isEmpty() && sums[i] > sums[linkedList.peekLast()]) {
        result = Math.max(result, i - linkedList.pollLast());
      }
    }
    return result;
  }

}