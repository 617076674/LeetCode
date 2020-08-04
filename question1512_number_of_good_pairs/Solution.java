package question1512_number_of_good_pairs;

/**
 * 暴力破解法。
 *
 * 时间复杂度是 O(n ^ 2)，其中 n 为数组 nums 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败83.21%。消耗内存：37.2MB，击败35.87%。
 */
public class Solution {
  public int numIdenticalPairs(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          result++;
        }
      }
    }
    return result;
  }
}