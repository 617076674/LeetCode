package question1703_minimum_adjacent_swaps_for_k_consecutive_ones;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
  public int minMoves(int[] nums, int k) {
    List<Integer> oneList = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        oneList.add(i);
      }
    }
    int left = 0, right = k - 1, mid = left + ((right - left) >> 1);
    int tmp = 0;
    for (int i = left; i <= right; i++) {
      tmp += Math.abs(oneList.get(mid) - mid + i - oneList.get(i));
    }
    int result = tmp;
    while (right < oneList.size() - 1) {
      tmp -= oneList.get(mid) - oneList.get(left);
      if ((k & 1) == 0) {
        tmp -= oneList.get(mid + 1) - oneList.get(mid);
      }
      tmp += oneList.get(right + 1) - oneList.get(mid + 1);
      result = Math.min(result, tmp);
      left++;
      right++;
      mid++;
    }
    return result;
  }

}