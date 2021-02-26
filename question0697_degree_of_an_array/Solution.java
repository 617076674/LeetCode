package question0697_degree_of_an_array;

public class Solution {

  public int findShortestSubArray(int[] nums) {
    int degree = 0;
    int[] map = new int[50000];
    for (int num : nums) {
      map[num]++;
      degree = Math.max(degree, map[num]);
    }
    int result = nums.length, left = 0, right = -1;
    int[] window = new int[50000];
    while (right + 1 < nums.length) {
      right++;
      window[nums[right]]++;
      while (degree <= window[nums[right]]) {
        if (degree == window[nums[right]]) {
          result = Math.min(result, right - left + 1);
        }
        window[nums[left]]--;
        left++;
      }
    }
    return result;
  }

}
