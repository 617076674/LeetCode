package question1546_maximum_number_of_non_overlapping_subarrays_with_sum_equals_target;

import java.util.HashSet;
import java.util.Set;

/**
 * 贪心算法。
 *
 * 如果存在重叠子数组同时满足和为 target，肯定取右端点较小的那个子数组。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为数组 nums 的长度。
 *
 * 执行用时：43ms，击败54.25%。消耗内存：52.5MB，击败26.35%。
 */
public class Solution {

  public int maxNonOverlapping(int[] nums, int target) {
    int result = 0;
    for (int i = 0; i < nums.length; ) {
      i = nextBeginIndex(nums, i, target);
      if (i == -1) {
        return result;
      }
      result++;
    }
    return result;
  }

  private int nextBeginIndex(int[] nums, int index, int target) {
    Set<Integer> set = new HashSet<>();
    set.add(0);
    int sum = 0;
    for (int i = index; i < nums.length; i++) {
      sum += nums[i];
      if (set.contains(sum - target)) {
        return i + 1;
      }
      set.add(sum);
    }
    return -1;
  }

}