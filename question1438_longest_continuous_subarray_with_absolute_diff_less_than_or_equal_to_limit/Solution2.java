package question1438_longest_continuous_subarray_with_absolute_diff_less_than_or_equal_to_limit;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

  public int longestSubarray(int[] nums, int limit) {
    Deque<Integer> queMax = new LinkedList<>(), queMin = new LinkedList<>();
    int result = 0, left = 0, right = -1;
    while (right + 1 < nums.length) {
      right++;
      while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
        queMax.pollLast();
      }
      while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
        queMin.pollLast();
      }
      queMax.addLast(nums[right]);
      queMin.addLast(nums[right]);
      while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
        if (nums[left] == queMin.peekFirst()) {
          queMin.pollFirst();
        }
        if (nums[left] == queMax.peekFirst()) {
          queMax.pollFirst();
        }
        left++;
      }
      result = Math.max(result, right - left + 1);
    }
    return result;
  }

}