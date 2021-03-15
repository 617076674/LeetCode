package question1793_maximum_score_of_a_good_subarray;

import java.util.LinkedList;

/**
 * 同 LeetCode0084，单调栈。
 */
public class Solution {

  public int maximumScore(int[] nums, int k) {
    int result = 0;
    int[] newHeights = new int[nums.length + 2];
    newHeights[0] = newHeights[nums.length + 1] = -1;
    for (int i = 0; i < nums.length; i++) {
      newHeights[i + 1] = nums[i];
    }
    LinkedList<Integer> stack = new LinkedList<>();
    for (int i = 0; i < newHeights.length; i++) {
      while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
        int index = stack.pop();
        if (k <= i - 2 && k >= stack.peek()) {
          result = Math.max(result, newHeights[index] * (i - stack.peek() - 1));
        }
      }
      stack.push(i);
    }
    return result;
  }

}