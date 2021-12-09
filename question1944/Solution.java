package question1944;

import java.util.LinkedList;

public class Solution {

  public int[] canSeePersonsCount(int[] heights) {
    int[] result = new int[heights.length];
    LinkedList<Integer> stack = new LinkedList<>();
    for (int i = heights.length - 1; i >= 0; i--) {
      while (!stack.isEmpty()) {
        result[i]++;
        if (heights[i] > heights[stack.peekLast()]) {
          stack.pollLast();
        } else {
          break;
        }
      }
      stack.addLast(i);
    }
    return result;
  }

}