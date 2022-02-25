package question1708;

public class Solution {

  public int[] largestSubarray(int[] nums, int k) {
    int maxIndex = -1;
    for (int i = 0; i < nums.length - k + 1; i++) {
      if (maxIndex == -1 || nums[i] > nums[maxIndex]) {
        maxIndex = i;
      }
    }
    int[] result = new int[k];
    for (int i = maxIndex; i < maxIndex + k; i++) {
      result[i - maxIndex] = nums[i];
    }
    return result;
  }

}