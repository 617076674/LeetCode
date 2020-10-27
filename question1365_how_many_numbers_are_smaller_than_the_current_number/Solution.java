package question1365_how_many_numbers_are_smaller_than_the_current_number;

/**
 * 执行用时：1ms，击败100.00%。消耗内存：38.4MB，击败96.98%。
 */
public class Solution {

  public int[] smallerNumbersThanCurrent(int[] nums) {
    int n = nums.length;
    int[] count = new int[101], lessCount = new int[101], result = new int[n];
    for (int num : nums) {
      count[num]++;
    }
    for (int i = 1; i < 101; i++) {
      lessCount[i] = lessCount[i - 1] + count[i - 1];
    }
    for (int i = 0; i < n; i++) {
      result[i] = lessCount[nums[i]];
    }
    return result;
  }

}